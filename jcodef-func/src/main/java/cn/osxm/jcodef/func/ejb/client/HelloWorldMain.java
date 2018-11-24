/**
 * @Title: HelloWorldMain.java
 * @Package cn.osxm.jcodef.ejb
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018��11��24�� ����5:51:47
 * @version V1.0
 */

package cn.osxm.jcodef.func.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



/**
 * @ClassName: HelloWorldMain
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class HelloWorldMain {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @throws NamingException
	 */

	public static void main(String[] args) throws NamingException {

		Properties props = new Properties();

		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		//props.put(Context.PROVIDER_URL, "ejb:127.0.0.1:9990");
		props.put("jboss.naming.client.ejb.context", true);
		//props.put(Context.SECURITY_PRINCIPAL,"admin");/
		//props.put(Context.SECURITY_CREDENTIALS, "admin");//

		//props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	
		InitialContext context = new InitialContext(props);

		// JNDI·
		String fullEJBName = "ejb_service/HelloWorld!cn.osxm.jcodef.ejb.HelloWorldRemote";
		cn.osxm.jcodef.ejb.HelloWorldRemote helloWorld = (cn.osxm.jcodef.ejb.HelloWorldRemote) context.lookup(fullEJBName);

		System.out.println(helloWorld.sayHello("osxm"));

	}

}
