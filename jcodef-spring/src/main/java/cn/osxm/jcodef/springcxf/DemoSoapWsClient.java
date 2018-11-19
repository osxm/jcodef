/**
 * @Title: DemoSoapWsClient.java
 * @Package cn.osxm.jcodef.springcxf
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月19日 下午9:56:56
 * @version V1.0
 */

package cn.osxm.jcodef.springcxf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.osxm.jcodef.springcxf.client.DemoRestWsService;
import cn.osxm.jcodef.springcxf.client.DemoSoapWsService;
import cn.osxm.jcodef.springcxf.model.Demo;


/**
 * @ClassName: DemoSoapWsClient
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class DemoSoapWsClient {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-cxf-rest-soap-client.xml");
		// 1.for SOAP Webservice
		DemoSoapWsService demoSoapWsService = (DemoSoapWsService) context.getBean("demoSoapWsClient");
		Demo demo = demoSoapWsService.get();
		System.out.println("DemoSoapWsService:" + demo.getName());
		
		
		  // test for security client
        DemoSoapWsService demoSoapWsServiceSec = (DemoSoapWsService) context.getBean("demoSoapWsSecurityClient");
        demo = demoSoapWsServiceSec.get();
        System.out.println("demoSoapWsSecurityClient:" + demo.getName());
        
        //2.for Rest Web Service
        /* DemoRestWsService DemoRestWsService = (DemoRestWsService) context.getBean("demoRestWsClient");
        String str = DemoRestWsService.run();
        System.out.println("DemoRestWsService:" + str);*/
        

	}

}
