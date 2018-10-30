

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class JMSQueueManager{
	
	public InitialContext getInitialContext() throws NamingException {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"driverclassname");
		String jmsProviderURL = "jmsurl";
		String jmsServerType = "jmsservertype";
		if (!(jmsProviderURL == null || jmsProviderURL.trim().equals(""))) {
			if (jmsServerType != null
					&& jmsServerType.trim().equalsIgnoreCase("Oracle AQ")) {
				env.put("db_url", jmsProviderURL);
			} else {
				env.put(Context.PROVIDER_URL, jmsProviderURL);
			}
		}
		String jmsProviderUsername = "jmsProvider.getUserName()";
		String jmsProviderPassword = "jmsProvider.getPassword()";
		if (!(jmsProviderUsername == null
				|| jmsProviderUsername.trim().equals("") || jmsProviderPassword == null)) {
			env.put(Context.SECURITY_PRINCIPAL, jmsProviderUsername);
			env.put(Context.SECURITY_CREDENTIALS, jmsProviderPassword);
		}
		return new InitialContext(env);
	}
	
	
	public void main(String args[]) {
	}
	
}
