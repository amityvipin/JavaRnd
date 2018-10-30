/*
 * Created on Jul 27, 2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */


import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.jms.BytesMessage;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.Subject;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JmsUtil {
	
	public static final long DEFAULT_MESSAGE_TIMEOUT_MS = 1000;
	public static final String JMS_MESSAGE_ID_EVENT_MAP_KEY = "messageId";
	
	public static final String JMS_PROVIDER = "JmsProvider";
	
	public static final String QUEUE_TOPIC_NAME = "queueTopicName";
	
	public static final String JMS_USERNAME = "jmsUsername";
	
	public static final String JMS_PASSWORD = "jmsPassword";
	
	public static final String JMS_MESSAGE_PROPERTIES_MAP_KEY = "jmsMessagePropertiesMapKey";
	
	public static final String JMS_MESSAGE_DELIVERY_MODE = "Transaction.JMS.JMSDeliveryMode";
	
	public static final String JMS_MESSAGE_CORRELATION_ID = "Transaction.JMS.JMSCorrelationID";

	public static final String JMS_MESSAGE_PRIORITY = "Transaction.JMS.JMSPriority";

    public static final String JMS_MESSAGE_PROPERTIES = "Transaction.JMS.JMSMessageProperties";
    
    public static final String JMS_MESSAGE_REPLY_TO = "Transaction.JMS.JMSReplyTo";
    
    public static final String JMS_MESSAGE_EXPIRATION_TIME = "Transaction.JMS.JMSExpirationTime";
    
    public static final String JMS_MESSAGE_ID = "Transaction.JMS.JMSMessageID";
    
    public static final String JMS_MESSAGE_DESTINATION = "Transaction.JMS.JMSDestination";
    
    public static final String JMS_MESSAGE_TIMESTAMP = "Transaction.JMS.JMSTimestamp";
    
    public static final String JMS_MESSAGE_TYPE = "Transaction.JMS.JMSType";
    
    public static final String JMS_MESSAGE_REDELIVERED = "Transaction.JMS.JMSRedelivered";
    
    public static final String PERSISTENT = "Persistent";
    
    public static final String NON_PERSISTENT = "Non-Persistent";
    
    public static final String JMSX_DELIVERY_COUNT = "JMSXDeliveryCount";
    
    public static final String JMS_MESSAGETYPE_TEXT = "TEXT";
    
    public static final String JMS_MESSAGETYPE_BYTE = "BYTE";
    
    public static final String JMS_MESSAGETYPE_ALL = "BOTH";
	
	static Map providerMap = new Hashtable();
	
	private static Map jmsEventConnectionObjMap = null;
	
    //Mange: To my knowledge this method is redundent, this method is not called from anywhere
	public static TopicConnectionFactory getTopicConnection(String service) throws Exception {
		try {
			
			Connection connection=null;
		   	String driverCompleteString = service;
		   
		   	String driver = driverCompleteString.substring(0,driverCompleteString.indexOf('$'));
		   	String [] jars =  driverCompleteString.substring(driverCompleteString.indexOf('$')+1,driverCompleteString.length()).split(",");
		   	File file = new File("IndigoConfig.getTempRepositoryRoot()");
			for(int i = 0 ; i < jars.length;i++)	   	
			{
				jars[i] = "file:///" + file.getAbsolutePath() + "/../libs/driver/" + jars[i];
			}
			
			URL[] urls = new URL[jars.length];
			for (int i = 0; i < jars.length; ++i) {
				urls[i] = new URL(jars[i]);
			}
	 	   URLClassLoader loader = new URLClassLoader(urls);
	 	  TopicConnectionFactory d = (TopicConnectionFactory) Class.forName(driver, true, loader).newInstance();
	 	    	   
	 	   return d;
	 	 
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/**
	 * Method to add the url in the current class loader.
	 * 
	 * @param url
	 * @throws Exception
	 */
	public static void addURL(URL url) throws Exception { 
		Class sysclass = URLClassLoader.class;
		try {
			Method method = sysclass.getDeclaredMethod("addURL",
					new Class[] { URL.class });
			method.setAccessible(true);
			method.invoke(JmsUtil.class.getClassLoader(), new Object[] { url });
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error, could not add URL " + url
					+ " to system classloader", e);
		}
	}

	/**
	 * Creates initial context from environment hashtable created by putting JMS
	 * Provider JDOs i.e. initialContextXML, driverClassName and jmsURL
	 * 
	 * @param jmsProvider
	 * @return
	 * @throws Exception
	 */
	public static InitialContext getIntialContext(JmsProvider jmsProvider)
			throws Exception {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				jmsProvider.getDriverClassName());
		String jmsProviderURL = jmsProvider.getJmsURL();
		String jmsServerType = jmsProvider.getJmsServerType();
		if (!(jmsProviderURL == null || jmsProviderURL.trim().equals(""))) {
			if (jmsServerType != null
					&& jmsServerType.trim().equalsIgnoreCase("Oracle AQ")) {
				env.put("db_url", jmsProviderURL);
			} else {
				env.put(Context.PROVIDER_URL, jmsProviderURL);
			}
		}
		String jmsProviderUsername = jmsProvider.getUserName();
		String jmsProviderPassword = jmsProvider.getPassword();
		if (!(jmsProviderUsername == null
				|| jmsProviderUsername.trim().equals("") || jmsProviderPassword == null)) {
			env.put(Context.SECURITY_PRINCIPAL, jmsProviderUsername);
			env.put(Context.SECURITY_CREDENTIALS, jmsProviderPassword);
		}
		return new InitialContext(env);
	}


	/**
	 * Generates XML by using initial context table values provided in GUI
	 * 
	 * @param mapOfValues
	 * @return
	 * @throws Exception
	 */
	public static String createXMLOfValues(Map mapOfValues)
			throws Exception {
		if (mapOfValues == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<initialcontext>\n");
		int rowCount = Integer.parseInt((String) mapOfValues
				.get("record1FldCount"));
		for (int i = 1; i <= rowCount; i++) {
			if (mapOfValues.get("record1fld" + i) != null
					&& !((String) mapOfValues.get("record1fld" + i)).equals("")) {
				sb.append("<param>\n");
				sb.append("<name>");
				sb.append(mapOfValues.get("record1fld" + i) != null ? mapOfValues
						.get("record1fld" + i) : "");
				sb.append("</name>\n");
				sb.append("<description>");
				sb.append(mapOfValues.get("record1description" + i) != null ? mapOfValues
						.get("record1description" + i) : "");
				sb.append("</description>\n");
				sb.append("<value>");
				sb.append(mapOfValues.get("record1fldvalue" + i) != null ? mapOfValues
						.get("record1fldvalue" + i) : "");
				sb.append("</value>\n");
				sb.append("</param>\n");
			}
		}
		sb.append("</initialcontext>\n");
		return sb.toString();
	}

	/**
	 * Sets JMS message properties which are specified at messagePropertiesXML,
	 * these values can be a String or a context variable
	 * 
	 * @param message
	 * @param transactionContext
	 * @param messagePropertiesXML
	 * @throws Exception
	 */
	public static void setMessageProperties(Message message,
			Map<Object, Object> messagePropertiesMap) throws Exception {
		if (message == null) {
			throw new JMSException("No message has been received");
		}
		try {
			if (messagePropertiesMap != null && messagePropertiesMap.size() > 0) {
				Iterator<Object> messagePropertiesMapIterator = messagePropertiesMap
						.keySet().iterator();
				while (messagePropertiesMapIterator.hasNext()) {
					String propertyName = (String) messagePropertiesMapIterator.next();
					message.setObjectProperty(propertyName,
							messagePropertiesMap.get(propertyName));
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Sets JMS message header properties on messageProducer and message objects
	 * 
	 * @param messageProducer
	 * @param message
	 * @param jmsCorrelationID
	 * @param messageDeliveryMode
	 * @param jmsPriority
	 * @param timeToLive
	 * @throws Exception
	 */
	public static void setMessageHeaders(MessageProducer messageProducer,
			Message message, String jmsCorrelationID,
			String messageDeliveryMode, String jmsPriority, String timeToLive,
			Destination replyToDestination) throws Exception {
		if (messageProducer == null) {
			throw new JMSException("JMS Message Producer is null");
		} else if (message == null) {
			throw new JMSException("No message has been received");
		}
		if (!(jmsCorrelationID == null || jmsCorrelationID.trim().equals(""))) {
			message.setJMSCorrelationID(jmsCorrelationID);
		}
		if (!(messageDeliveryMode == null || messageDeliveryMode.trim().equals(
				""))) {
			if (messageDeliveryMode.equalsIgnoreCase(NON_PERSISTENT)
					|| messageDeliveryMode.equalsIgnoreCase(PERSISTENT)) {
				int deliveryMode = messageDeliveryMode
						.equalsIgnoreCase(NON_PERSISTENT) ? DeliveryMode.NON_PERSISTENT
						: DeliveryMode.PERSISTENT;
				messageProducer.setDeliveryMode(deliveryMode);
			} else {
				messageProducer.setDeliveryMode(Integer
						.parseInt(messageDeliveryMode));
			}
		}
		if (!(jmsPriority == null || jmsPriority.trim().equals(""))) {
			messageProducer.setPriority(Integer.parseInt(jmsPriority));
		}
		if (!(timeToLive == null || timeToLive.trim().equals(""))) {
			long timeToLiveToBeSet = Long.parseLong(timeToLive);
			if (timeToLiveToBeSet >= 0) {
				messageProducer.setTimeToLive(timeToLiveToBeSet);
			}
		}
		if (replyToDestination != null) {
			message.setJMSReplyTo(replyToDestination);
		}
	}

	/**
	 * Receives enqueued messages, if timeout is not provided then receives
	 * message by providing DEFAULT_MESSAGE_TIMEOUT_MS timeout
	 * 
	 * @param messageConsumer
	 * @param timeout
	 * @return
	 * @throws JMSException
	 */
	public static Message receiveJMSMessage(MessageConsumer messageConsumer,
			String timeout) throws JMSException {
		if(messageConsumer == null){
			throw new JMSException("JMS Message Consumer is null");
		}
		Message msg = null;
		if (!(timeout == null || timeout.trim().equals(""))) {
			msg = messageConsumer.receive(1000 * Long.parseLong(timeout));
		} else {
			msg = messageConsumer.receive(DEFAULT_MESSAGE_TIMEOUT_MS);
		}
		return msg;
	}
	
	/**
	 * Returns a map which has JMS message properties key-value pairs
	 * 
	 * @param message
	 * @return
	 * @throws JMSException
	 */
	public static Map<Object, Object> generateJMSMessagePropertiesMap(
			Message message) throws JMSException {
		if (message == null) {
			throw new JMSException("No message has been received");
		}
		Map<Object, Object> propertiesMap = new HashMap<Object, Object>();
		propertiesMap.put(JMS_MESSAGE_DELIVERY_MODE,
				String.valueOf(message.getJMSDeliveryMode()));
		propertiesMap.put(JMS_MESSAGE_CORRELATION_ID,
				message.getJMSCorrelationID());
		propertiesMap.put(JMS_MESSAGE_PRIORITY,
				String.valueOf(message.getJMSPriority()));
		propertiesMap.put(JMS_MESSAGE_REPLY_TO, message.getJMSReplyTo());
		propertiesMap.put(JMS_MESSAGE_EXPIRATION_TIME,
				message.getJMSExpiration());
		propertiesMap.put(JMS_MESSAGE_ID, message.getJMSMessageID());
		propertiesMap.put(JMS_MESSAGE_DESTINATION, message.getJMSDestination());
		propertiesMap.put(JMS_MESSAGE_TIMESTAMP, message.getJMSTimestamp());
		propertiesMap.put(JMS_MESSAGE_TYPE, message.getJMSType());
		propertiesMap.put(JMS_MESSAGE_REDELIVERED, message.getJMSRedelivered());
		Map<Object, Object> messagePropertiesMap = generateMessagePropertiesMap(message);
		if (messagePropertiesMap != null) {
		propertiesMap.put(JMS_MESSAGE_PROPERTIES, messagePropertiesMap);
		}
		return propertiesMap;
	}

	/**
	 * Cache JMS Session and Connection objects on kernel JVM
	 * 
	 * @param jmsProviderEntity
	 * @param eventTypedId
	 * @throws Exception
	 */
	public static void cacheJMSQueueConnectionObjects(
			JmsProvider jmsProviderEntity, String eventTypedId)
			throws Exception {
		if (jmsEventConnectionObjMap == null) {
			jmsEventConnectionObjMap = new HashMap();
		} else if (jmsEventConnectionObjMap.containsKey(eventTypedId)) {
			throw new Exception(
					"JMS Event connection objects are already cached for event: "
							+ eventTypedId);
		}
		InitialContext ic = getInitialContext(jmsProviderEntity, false);
		// get queue connection factory
		QueueConnectionFactory qcf = (QueueConnectionFactory) ic
				.lookup(jmsProviderEntity.getQueueConnectionFactory());
		// create queue connection
		QueueConnection qc = qcf.createQueueConnection();
		QueueSession qs = qc
				.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		if (!(qc == null || qs == null)) {
			jmsEventConnectionObjMap.put(eventTypedId,
					new JMSConnectionDataModel(qc, qs));
		} else {
			throw new Exception(
					"JMS Event connection object is null for event: "
							+ eventTypedId);
		}
	}

	/**
	 * Returns JMSConnectionDataModel corresponding to the provided typed id
	 * 
	 * @param eventTypedId
	 * @return
	 */
	public static JMSConnectionDataModel getJMSConnectionDataModel(
			String eventTypedId) {
		JMSConnectionDataModel jmsConnectionDataModel = null;
		if (jmsEventConnectionObjMap != null) {
			jmsConnectionDataModel = (JMSConnectionDataModel) jmsEventConnectionObjMap
					.get(eventTypedId);
		}
		return jmsConnectionDataModel;
	}

	/**
	 * Closes cache connection and session objects and removes them from
	 * jmsEventConnectionObjMap Hash Map
	 * 
	 * @param eventTypedId
	 */
	public static void cleanUpCachedJMSEventConnectionObjects(
			String eventTypedId) {
		Session session = null;
		javax.jms.Connection connection = null;
		JMSConnectionDataModel jmsConnectionDataModel = getJMSConnectionDataModel(eventTypedId);
		if (jmsConnectionDataModel != null) {
			session = jmsConnectionDataModel.getSession();
			connection = jmsConnectionDataModel.getConnection();
		}
		if (session != null) {
			try {
				session.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		if (jmsEventConnectionObjMap != null) {
			jmsEventConnectionObjMap.remove(eventTypedId);
		}
	}
	
	/**
	 * Returns JMS Destination for provided queue/topic name
	 * 
	 * @param jmsProvider
	 * @param queueTopicName
	 * @return
	 * @throws Exception
	 */
	public static Destination getReplyToDestination(JmsProvider jmsProvider,
			String queueTopicName) throws Exception {
		Destination replyToDestination = null;
		if (!(queueTopicName == null || queueTopicName.trim().equals(""))) {
			InitialContext ic = getInitialContext(jmsProvider, false);
			replyToDestination = (Destination) ic.lookup(queueTopicName);
		}
		return replyToDestination;
	}
	
	/**
	 * Generates map by getting all the message properties using
	 * getPropertyNames() method of Message API
	 * 
	 * @param message
	 * @return
	 * @throws JMSException
	 */
	public static Map<Object, Object> generateMessagePropertiesMap(
			Message message) throws JMSException {
		if (message == null) {
			throw new JMSException("No message has been received");
		}
		Enumeration msgPropertyNamesEnum = message.getPropertyNames();
		if (msgPropertyNamesEnum == null
				|| !msgPropertyNamesEnum.hasMoreElements()) {
			return null;
		}
		Map<Object, Object> messagePropertiesMap = new HashMap<Object, Object>();
		while (msgPropertyNamesEnum.hasMoreElements()) {
			String messagePropertyName = (String) msgPropertyNamesEnum
					.nextElement();
			messagePropertiesMap.put(messagePropertyName,
					message.getObjectProperty(messagePropertyName));
		}
		return messagePropertiesMap;
	}

	/**
	 * Returns map by reading JMS message properties XML
	 * 
	 * @param transactionContext
	 * @param messagePropertiesXML
	 * @return
	 * @throws Exception
	 */
	public static Map<Object, Object> generateMessagePropertiesMapFromXML(
			com.adeptia.indigo.system.Context transactionContext,
			String messagePropertiesXML) throws Exception {
		Map<Object, Object> messagePropertiesMap = null;
		if (!(messagePropertiesXML == null || messagePropertiesXML.trim()
				.equals(""))) {
			messagePropertiesMap = new HashMap<Object, Object>();
			NodeList nodeList = XmlUtils.getElementsByTagName(
					XmlUtils.parse(messagePropertiesXML), "variable");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Object valueToBeSet = null;
				Node node = nodeList.item(i);
				String messagePropertyName = XmlUtils.getValueFromChildNode(
						node, "name");
				String messagePropertyType = XmlUtils.getValueFromChildNode(
						node, "type");
				String messagePropertyValue = XmlUtils.getValueFromChildNode(
						node, "value");
				if (!(messagePropertyType == null || messagePropertyType.trim()
						.equals("")) && messagePropertyType.equals("encrypted")) {
					valueToBeSet = PasswordService.getInstance().decrypt(
							messagePropertyValue);
				}
				valueToBeSet = JellyUtils.parseValueForContextVar(
						transactionContext,
						JellyUtils.parseMessageForDate(messagePropertyValue));
				messagePropertiesMap.put(messagePropertyName, valueToBeSet);
			}
		}
		return messagePropertiesMap;
	}
	
	/**
	 * @param msg
	 * @param event
	 * @param msgMap
	 * @throws JMSException
	 */
	public static void processTextMessage(Message msg, AbstractEvent event,
			HashMap msgMap) throws JMSException {
		String msgText = ((TextMessage) msg).getText();
		msgMap.put(EventUtils.EVENTMAPVAR, msgText);
		Map<Object, Object> jmsMessagePropertiesMap = JmsUtil
				.generateJMSMessagePropertiesMap(msg);
		msgMap.put(JmsUtil.JMS_MESSAGE_PROPERTIES_MAP_KEY,
				jmsMessagePropertiesMap);
		boolean triggerInSequence = event.isTriggerInSequence();
		msgMap.put(EventUtils.TRIGGEREVENT_IN_SEQUENCE, triggerInSequence);

	}

	/**
	 * @param msg
	 * @param event
	 * @param msgMap
	 * @throws JMSException
	 */
	public static void processByteMessage(Message msg, AbstractEvent event,
			HashMap msgMap) throws JMSException { 
//		msgMap.put(JmsUtil.JMS_MESSAGE_ID_EVENT_MAP_KEY, msg.getJMSMessageID());
		Map<Object, Object> jmsMessagePropertiesMap = JmsUtil
				.generateJMSMessagePropertiesMap(msg);
		jmsMessagePropertiesMap.put(JmsUtil.JMS_MESSAGE_ID_EVENT_MAP_KEY, msg.getJMSMessageID());  
		BytesMessage bytesMessage = (BytesMessage)msg;
        byte[] body = new byte[(int) bytesMessage.getBodyLength()]; 
        bytesMessage.readBytes(body);
        msgMap.put(EventUtils.EVENTMAPVAR, body);   
		msgMap.put(JmsUtil.JMS_MESSAGE_PROPERTIES_MAP_KEY,
				jmsMessagePropertiesMap);
		boolean triggerInSequence = event.isTriggerInSequence();
		msgMap.put(EventUtils.TRIGGEREVENT_IN_SEQUENCE, triggerInSequence);

	}
	
	
	/**
	 * @param msg
	 * @return
	 * @throws JMSException
	 */
	public static String readTextMessage(Message msg) throws JMSException {
		return ((TextMessage) msg).getText();
	}

	/**
	 * @param msg
	 * @return
	 * @throws JMSException
	 */
	public static byte[] readBytesMessage(Message msg) throws JMSException {
		BytesMessage bytesMessage = (BytesMessage) msg;
		byte[] body = new byte[(int) bytesMessage.getBodyLength()];
		bytesMessage.readBytes(body);
		return body;
	}

}
