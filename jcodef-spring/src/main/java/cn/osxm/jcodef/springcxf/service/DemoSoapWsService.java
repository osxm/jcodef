/**
 * @Title: DemoSoapWsService.java
 * @Package cn.osxm.jcodef.springcxf.service
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018��11��19�� ����7:15:37
 * @version V1.0
 */

package cn.osxm.jcodef.springcxf.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cn.osxm.jcodef.springcxf.model.Demo;

/**
 * @ClassName: DemoSoapWsService
 * @Description: TODO
 * @author osxm:oscarxueming
 */
@WebService
public interface DemoSoapWsService {
	@WebMethod
	public Demo get();
}
