/**
 * @Title: SpringMybatisTransDemo.java
 * @Package cn.osxm.jcodef.func.mybatisspring
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月20日 上午5:30:44
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.osxm.jcodef.func.mybatisspring.model.Chart;
import cn.osxm.jcodef.func.mybatisspring.service.ChartService;

/**
 * @ClassName: SpringMybatisTransDemo
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class SpringMybatisTransDemo {
	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis-transaction.xml");
		ChartService chartService = (ChartService) context.getBean("chartService");

		Chart chart = chartService.getChartById(12);
		chart.setDescription("Dashx Char Test 2223");
		//int iResult = chartService.update(chart);
		//System.out.println(iResult);
	}
}
