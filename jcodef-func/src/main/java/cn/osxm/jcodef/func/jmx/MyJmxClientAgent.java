/**
 * @Title: MyJmxClientAgent.java
 * @Package cn.osxm.jcodef.func.jmx
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月30日 上午5:43:43
 * @version V1.0
 */

package cn.osxm.jcodef.func.jmx;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

/**
 * @ClassName: MyJmxClientAgent
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class MyJmxClientAgent {
	public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException,
			MBeanRegistrationException, NotCompliantMBeanException {
// TODO Auto-generated method stub
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		ObjectName myJmxName = new ObjectName("jmxBean:name=myJmx");
		server.registerMBean(new MyJmx(), myJmxName);
// TODO Auto-generated method stub
		try {
			LocateRegistry.createRegistry(9999);
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
			JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);
			System.out.println("begin rmi start");
			jcs.start();
			System.out.println("rmi start");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
