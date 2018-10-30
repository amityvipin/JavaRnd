/**
 * $Id$
 *
 * Copyright (C) 2003, Adeptia, Inc.
 *
 * @author <a href="mailto:satbir.singh@adeptia.com">Satbir Singh</a>
 * @version CVS $Revision$
 *
 * Date          Author          Changes
 */

public class JmsProvider {
	private String _jmsURL;

	private String _driverJarFiles;

	private String _driverClassName;
	private String _queueConnectionFactory;

	private String _topicConnectionFactory;

	private String _initialContextXML;

	private String _jmsServerType;

	private String _userName;

	private String _password;

	public String getDriverJarFiles() {
		return _driverJarFiles;
	}

	public String getDriverClassName() {
		return _driverClassName;
	}

	/**
	 * @param string
	 */
	public void setDriverClassName(String string) {
		_driverClassName = string;
	}

	/**
	 * @param string
	 */
	public void setDriverJarFiles(String string) {
		_driverJarFiles = string;
	}

	public String getJmsURL() {
		return _jmsURL;
	}

	public String getQueueConnectionFactory() {
		return _queueConnectionFactory;
	}

	public String getTopicConnectionFactory() {
		return _topicConnectionFactory;
	}

	/**
	 * @param string
	 */
	public void setJmsURL(String string) {
		_jmsURL = string;
	}

	/**
	 * @param string
	 */
	public void setQueueConnectionFactory(String string) {
		_queueConnectionFactory = string;
	}

	/**
	 * @param string
	 */
	public void setTopicConnectionFactory(String string) {
		_topicConnectionFactory = string;
	}

	/**
	 * @param string
	 */
	public void setInitialContextXML(String initialContextXML) {
		this._initialContextXML = initialContextXML;
	}

	public String getInitialContextXML() {
		return _initialContextXML;
	}

	public String getJmsServerType() {
		return _jmsServerType;
	}

	/**
	 * Sets JMS Server Type
	 * 
	 * @param string
	 */
	public void setJmsServerType(String jmsServerType) {
		_jmsServerType = jmsServerType;
	}

	/**
	 * JMS Server username
	 * 
	 * @param sets
	 * 
	 */
	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getUserName() {
		return _userName;
	}

	/**
	 * JMS Server password
	 * 
	 * @param sets
	 * 
	 */
	public void setPassword(String password) {
		_password = password;
	}

	public String getPassword() {
		return _password;
	}

}
