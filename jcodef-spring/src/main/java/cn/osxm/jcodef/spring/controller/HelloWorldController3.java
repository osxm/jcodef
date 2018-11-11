/**
 * @Title: HelloWorldController3.java
 * @Package cn.osxm.dashx.teach.controller
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月10日 下午1:16:26
 * @version V1.0
 */

package cn.osxm.jcodef.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

/**
 * @ClassName: HelloWorldController3
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class HelloWorldController3 implements HttpRequestHandler {

	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", "HelloWorldController3");
		request.getRequestDispatcher("/WEB-INF/view/helloWorld.jsp").forward(request, response);

		//response.setCharacterEncoding("utf-8");
		//response.setContentType("application/json;charset=utf-8");
		//response.getWriter().write("json字符串");
	}

}
