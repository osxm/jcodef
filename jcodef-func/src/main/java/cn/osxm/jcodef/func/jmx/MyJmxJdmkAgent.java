/**
 * @Title: MyJmxJdmkAgent.java
 * @Package cn.osxm.jcodef.func.jmx
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月30日 上午5:44:20
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

import com.sun.jdmk.comm.HtmlAdaptorServer;
/**
 * @ClassName: MyJmxJdmkAgent
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class MyJmxJdmkAgent {
	public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException,
			MBeanRegistrationException, NotCompliantMBeanException {
		// TODO Auto-generated method stub
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		ObjectName myJmxName = new ObjectName("jmxBean:name=myJmx");
		server.registerMBean(new MyJmx(), myJmxName);

		//
		ObjectName adapterName = new ObjectName("MyJmxAgent:name=htmladapter,port=8082");
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		server.registerMBean(adapter, adapterName);
		adapter.start();
	}
}
