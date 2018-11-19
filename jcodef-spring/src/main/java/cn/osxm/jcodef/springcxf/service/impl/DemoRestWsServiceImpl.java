/**
 * @Title: DemoRestWsServiceImpl.java
 * @Package cn.osxm.jcodef.springcxf.service.impl
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月20日 上午4:31:35
 * @version V1.0
 */

package cn.osxm.jcodef.springcxf.service.impl;

import cn.osxm.jcodef.springcxf.model.Demo;
import cn.osxm.jcodef.springcxf.service.DemoRestWsService;

/**
  * @ClassName: DemoRestWsServiceImpl
  * @Description: TODO
  * @author osxm:oscarxueming
  */

public class DemoRestWsServiceImpl implements DemoRestWsService {
	@Override
	public Demo get() {
		Demo demo = new Demo("SOAP Ws Demo", "This is Demo for SOAP Webservice");
		System.out.println("DemoSoapWsServiceImpl:get Run...");
		return demo;
	}
}
