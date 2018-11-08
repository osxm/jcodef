/**
 * @Title: QueueConsumer.java
 * @Package cn.osxm.jcodef.func.activemq
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月8日 下午8:45:56
 * @version V1.0
 */

package cn.osxm.jcodef.func.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @ClassName: QueueConsumer
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class QueueConsumer {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	private Session session;

	private Destination destination;

	private MessageConsumer messageConsumer;

	public void doReceive() {

		try {
			connectionFactory = new ActiveMQConnectionFactory();
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue(QueuePublisher.QUEUE_NAME);
			messageConsumer = session.createConsumer(destination);
			receiveByListener();
			// messageConsumer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// connection.close();
		}

	}

	private void receiveByListener() {
		try {
			messageConsumer.setMessageListener(new MessageListener() {
				public void onMessage(Message message) {
					if (message instanceof TextMessage) {
						try {
							TextMessage msg = (TextMessage) message;
							System.out.println("Received:“" + msg.getText() + "”");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueConsumer consumer = new QueueConsumer();
		consumer.doReceive();
	}
}
