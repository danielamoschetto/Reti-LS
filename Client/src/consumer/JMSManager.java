package consumer;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import ejb_cl_pkg.LocalServer;

public class JMSManager {

    private  ConnectionFactory connectionFactory;
    private  Connection connection;
    private  Topic topicADV;
    private  Topic topicSP;
    private  boolean transacted = false;
    public  ADVConsumer AdvCons;
    private  SPConsumer SpCons;
    public  Session session;

	
	public JMSManager(LocalServer LS) throws JMSException {
		// TODO Auto-generated method stub
	    
        String serverURL = "mq://"+LS.getName()+":7676";
        
        connectionFactory = new  ConnectionFactory();		
        connectionFactory.setProperty(ConnectionConfiguration.imqAddressList, serverURL);
        connectionFactory.setProperty(ConnectionConfiguration.imqConnectionURL, serverURL);
        connectionFactory.setProperty(ConnectionConfiguration.imqDefaultUsername, "admin");
        connectionFactory.setProperty(ConnectionConfiguration.imqDefaultPassword, "admin");
        connection = (Connection)connectionFactory.createConnection();

        session = (Session) connection.createSession(transacted, Session.AUTO_ACKNOWLEDGE);
        
        topicADV = session.createTopic("topicADV");
        topicSP = session.createTopic("topicSP");
        connection.start();

        MessageConsumer receiverADV = session.createConsumer(topicADV);
        AdvCons = new ADVConsumer();
        connection.setExceptionListener(AdvCons);
        receiverADV.setMessageListener(AdvCons);
        
        MessageConsumer receiverSP = session.createConsumer(topicSP);
        SpCons = new SPConsumer();
        connection.setExceptionListener(SpCons);
        receiverSP.setMessageListener(SpCons);
    }

}
