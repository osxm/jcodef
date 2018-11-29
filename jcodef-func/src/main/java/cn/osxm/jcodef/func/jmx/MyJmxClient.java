/**
 * @Title: MyJmxClient.java
 * @Package cn.osxm.jcodef.func.jmx
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月30日 上午5:41:53
 * @version V1.0
 */

package cn.osxm.jcodef.func.jmx;

import javax.management.Attribute;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * @ClassName: MyJmxClient
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class MyJmxClient {
	public static void main(String[] args) {
		try {
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
			JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
			MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
			ObjectName mbeanName = new ObjectName("jmxBean:name=myJmx");

			System.out.println("Domains ......");
			String[] domains = mbsc.getDomains();

			for (int i = 0; i < domains.length; i++) {
				System.out.println("doumain[" + i + "]=" + domains[i]);
			}

			System.out.println("MBean count = " + mbsc.getMBeanCount());
			mbsc.setAttribute(mbeanName, new Attribute("Name", "Oscar999 JMX Value"));
			String name = (String) mbsc.getAttribute(mbeanName, "Name");
			System.out.println("name=" + name);

			MyJmxMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc, mbeanName, MyJmxMBean.class, false);
			proxy.setName("New Oscar999 JMX Value");
			mbsc.invoke(mbeanName, "getName", null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
