/**
 * @Title: DemoRestWsService.java
 * @Package cn.osxm.jcodef.springcxf.service
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018��11��20�� ����4:31:53
 * @version V1.0
 */

package cn.osxm.jcodef.springcxf.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cn.osxm.jcodef.springcxf.model.Demo;

/**
 * @ClassName: DemoRestWsService
 * @Description: TODO
 * @author osxm:oscarxueming
 */
@WebService
public interface DemoRestWsService {
	
	@WebMethod
	public Demo get();
}
