/**
 * @Title: HelloWorldController3.java
 * @Package cn.osxm.dashx.teach.controller
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月10日 下午1:16:26
 * @version V1.0
 */

package cn.osxm.jcodef.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @ClassName: HelloWorldController3
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class HelloWorldController4 implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelView = new ModelAndView(); 
		modelView.addObject("name", "HelloWorldController4");
		modelView.setViewName("/WEB-INF/view/helloWorld.jsp");
		return modelView;
	}

}
