/**
 * @Title: MyJmxAgent.java
 * @Package cn.osxm.jcodef.func.jmx
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月30日 上午5:42:58
 * @version V1.0
 */

package cn.osxm.jcodef.func.jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 * @ClassName: MyJmxAgent
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class MyJmxAgent {
	public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException,
			MBeanRegistrationException, NotCompliantMBeanException, InterruptedException {
		// TODO Auto-generated method stub
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		ObjectName myJmxName = new ObjectName("jmxBean:name=myJmx");
		server.registerMBean(new MyJmx(), myJmxName);
		Thread.sleep(60 * 60 * 1000);
	}
}
