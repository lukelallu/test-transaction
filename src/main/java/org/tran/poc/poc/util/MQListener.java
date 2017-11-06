package org.tran.poc.poc.util;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class MQListener {


    private final Logger slf4jLogger = LoggerFactory.getLogger(MQListener.class);
    Session session;
    Connection connection;
    ActiveMQConnectionFactory connectionFactory;

    public void sendMessage(String json) {
        try {
            // Create a ConnectionFactory
            connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            slf4jLogger.info(" -- json -- " + json);
            // Create a Connection
            connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("inboundPay");
            Destination destinationArchieve = session.createQueue("inboundPayArchieve");

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            MessageProducer producerArchieve = session.createProducer(destinationArchieve);

            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            producerArchieve.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // Create a messages
            TextMessage messageT = session.createTextMessage(json);
            slf4jLogger.info(" Message published : "+ json);
            // Tell the producer to send the message
            producer.send(messageT);
            producerArchieve.send(messageT);

            // Clean up
         /*   session.close();
            connection.close();*/
        } catch (Exception e) {
            slf4jLogger.info("Caught: " + e);
            e.printStackTrace();
        }

    }

    public String consumeMessage() {
        try {

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("inboundPay");
            // Create a MessageConsumer from the Session to the Topic or Queue
            MessageConsumer consumer = session.createConsumer(destination);
            // Wait for a message
            Message message = consumer.receive(1000);
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                slf4jLogger.info("Received: " + text);
                return text;
            } else {
                slf4jLogger.info("Received: " + message);
            }
            consumer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            slf4jLogger.info("Caught: " + e);
            e.printStackTrace();
        }
        return null;
    }

}
