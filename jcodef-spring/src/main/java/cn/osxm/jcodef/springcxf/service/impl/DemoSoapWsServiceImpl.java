/**
 * @Title: DemoSoapWsServiceImpl.java
 * @Package cn.osxm.jcodef.springcxf.service.impl
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018��11��19�� ����7:15:57
 * @version V1.0
 */

package cn.osxm.jcodef.springcxf.service.impl;

import cn.osxm.jcodef.springcxf.model.Demo;
import cn.osxm.jcodef.springcxf.service.DemoSoapWsService;

/**
 * @ClassName: DemoSoapWsServiceImpl
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class DemoSoapWsServiceImpl implements DemoSoapWsService {

	@Override
	public Demo get() {
		Demo demo = new Demo("SOAP Ws Demo", "This is Demo for SOAP Webservice");
		System.out.println("DemoSoapWsServiceImpl:get Run...");
		return demo;
	}
}
