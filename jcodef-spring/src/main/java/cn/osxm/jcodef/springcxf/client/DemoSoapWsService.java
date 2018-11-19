/**
 * @Title: DemoSoapWsService.java
 * @Package cn.osxm.jcodef.springcxf.client
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月19日 下午10:54:21
 * @version V1.0
 */

package cn.osxm.jcodef.springcxf.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cn.osxm.jcodef.springcxf.model.Demo;

/**
 * @ClassName: DemoSoapWsService
 * @Description: TODO
 * @author osxm:oscarxueming
 */

@WebService(targetNamespace = "http://service.springcxf.jcodef.osxm.cn/")
public interface DemoSoapWsService {
	
	@WebMethod(operationName = "get")
	public Demo get();
}
