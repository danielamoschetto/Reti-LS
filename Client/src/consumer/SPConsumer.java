package consumer;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SPConsumer implements MessageListener, ExceptionListener {

	public void onMessage(Message msg) {			 
		try {
			System.out.println(((TextMessage)msg).getText() + " at " + System.currentTimeMillis());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onException(JMSException jmse) {
		System.out.println(jmse.getMessage());
	}

}
