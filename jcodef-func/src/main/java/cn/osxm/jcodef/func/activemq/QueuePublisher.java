/**
 * @Title: QueuePublisher.java
 * @Package cn.osxm.jcodef.func.activemq
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月8日 下午8:43:27
 * @version V1.0
 */

package cn.osxm.jcodef.func.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @ClassName: QueuePublisher
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class QueuePublisher {

	public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

	public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

	public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static final String QUEUE_NAME = "Hello World ActiveMQ";

	private ConnectionFactory connectionFactory;

	private Connection connection;

	private Session session;

	private Destination destination;

	private MessageProducer messageProducer;

	public void doSend() {
		try {
			connectionFactory = new ActiveMQConnectionFactory();
			connection = connectionFactory.createConnection();

			connection.start();

			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue(QUEUE_NAME);
			messageProducer = session.createProducer(destination);
			messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			messageProducer.setTimeToLive(60000);

			TextMessage message = session.createTextMessage("send message content:");
			messageProducer.send(message);

			session.commit();
			messageProducer.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					// connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		QueuePublisher publisher = new QueuePublisher();
		publisher.doSend();
	}

}
