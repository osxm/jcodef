/**
 * @Title: MybatisSpringDemo.java
 * @Package cn.osxm.jcodef.func.mybatisspring
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月14日 上午5:58:50
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.osxm.jcodef.func.mybatisspring.model.Chart;
import cn.osxm.jcodef.func.mybatisspring.service.ChartService;

/**
  * @ClassName: MybatisSpringDemo
  * @Description: TODO
  * @author osxm:oscarxueming
  */

public class MybatisSpringDemo {

	/**
	  * @Title: main
	  * @Description: TODO
	  * @param args
	  */

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/osxm/jcodef/func/mybatisspring/spring-mybatis.xml");	
		ChartService chartService = (ChartService) context.getBean("chartService");
		Chart chart = chartService.getChartById(1);
		System.out.println(chart.getName());
	}

}
