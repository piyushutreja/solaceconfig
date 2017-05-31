package com.sapient.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessages() throws JMSException {

		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage("test");
				return message;
			}
		});

	}

}
