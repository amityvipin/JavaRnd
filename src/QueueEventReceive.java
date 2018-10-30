import javax.jms.ExceptionListener;
import javax.jms.InvalidSelectorException;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.security.auth.Subject;

public class QueueEventReceive implements javax.jms.MessageListener, ExceptionListener {

	private QueueConnectionFactory _queueConnectionFactory;

	private QueueConnection _queueConnection;

	private QueueSession _queueSession;

	private QueueReceiver _queueReceiver;

	private Queue _queue;

	@Override
	public void onMessage(Message arg0) {

	}

	public void init(Context ctx, JmsProvider jmsProvider, String queueOrtopicName, String jmsUserName,
			String jmsPassword, boolean createDynamically, String subscriberID, String messageSelector, String id,
			String eventName, Subject subject, String messageType) {
		String jmsFactory = jmsProvider.getQueueConnectionFactory();
		try {
			_queueConnectionFactory = (QueueConnectionFactory) ctx.lookup(jmsFactory);
		} catch (NamingException e) {
			ctx = JmsUtil.getInitialContext(jmsProvider, true);
			_queueConnectionFactory = (QueueConnectionFactory) ctx.lookup(jmsFactory);
		}

		if (!(jmsUserName == null || jmsUserName.trim().equals("") || jmsPassword == null)) {
			_queueConnection = _queueConnectionFactory.createQueueConnection(jmsUserName, jmsPassword);
		} else {
			_queueConnection = _queueConnectionFactory.createQueueConnection();
		}
		_queueConnection.setExceptionListener(this);
		_queueSession = _queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

		try {
			_queue = (Queue) ctx.lookup(queueOrtopicName);
		} catch (NamingException ne) {
			/*
			 * _queue = _queueSession.createQueue(queueOrtopicName); ctx.bind(_queueName,
			 * _queue);
			 */
			throw ne;
		}

		try {
			if (messageSelector == null) {
				_queueReceiver = _queueSession.createReceiver(_queue);
			} else {
				_queueReceiver = _queueSession.createReceiver(_queue, messageSelector);
			}
		} catch (InvalidSelectorException ise) {
			throw new JMSException("Invalid message Selector" + messageSelector);
		}
		_queueReceiver.setMessageListener(this);
		_queueConnection.start();
	}

	@Override
	public void onException(JMSException arg0) {
		// TODO Auto-generated method stub

	}

}