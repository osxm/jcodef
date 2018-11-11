package cn.osxm.jcodef.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController2 implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelView = new ModelAndView(); 
		modelView.addObject("name", "HelloWorldController2");
		modelView.setViewName("/WEB-INF/view/helloWorld.jsp");
		return modelView;
	}

}
