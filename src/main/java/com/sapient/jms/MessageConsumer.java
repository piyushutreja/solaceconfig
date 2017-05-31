package com.sapient.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


public class MessageConsumer implements MessageListener {

	@Override
	public void onMessage(Message message) {

		try {
			System.out.println("Received message on destination: " + message.getJMSDestination().toString());
		} catch (JMSException ex) {
			throw new RuntimeException(ex);
		}

	}

}
