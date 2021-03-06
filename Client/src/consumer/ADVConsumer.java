package consumer;

import java.util.Observable;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import client.ClientMessage;

public class ADVConsumer extends Observable implements MessageListener, ExceptionListener{

	public void onMessage(Message msg) {
		try {
			setChanged();
			notifyObservers(new ClientMessage(((TextMessage)msg).getText()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onException(JMSException jmse) {
		setChanged();
		notifyObservers(new ClientMessage(jmse.getMessage()));
	}

}
