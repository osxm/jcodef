/**
 * @Title: MapperLoadDemo.java
 * @Package cn.osxm.jcodef.func.mybatisspring
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月18日 上午10:27:12
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.osxm.jcodef.func.mybatisspring.model.Chart;
import cn.osxm.jcodef.func.mybatisspring.service.ChartService;

/**
 * @ClassName: MapperLoadDemo
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class MapperLoadDemo {
	public void mapFacXmlAndJavaInSameFolder() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"cn/osxm/jcodef/func/mybatisspring/spring-mapperfactorybean.xml");
		ChartService chartService = (ChartService) context.getBean("chartService");
		Chart chart = chartService.getChartById(1);
		System.out.println(chart.getName());
	}

	public void mapScanXml() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"cn/osxm/jcodef/func/mybatisspring/spring-mapperscan.xml");
		ChartService chartService = (ChartService) context.getBean("chartService");
		Chart chart = chartService.getChartById(1);
		System.out.println(chart.getName());
	}

	public void mapLoadByAnnotation() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"cn/osxm/jcodef/func/mybatisspring/spring-mapperannotation.xml");
		ChartService chartService = (ChartService) context.getBean("chartService");
		Chart chart = chartService.getChartById(1);
		System.out.println(chart.getName());
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		MapperLoadDemo mapperLoadDemo = new MapperLoadDemo();
		// mapperLoadDemo.mapFacXmlAndJavaInSameFolder();
		mapperLoadDemo.mapScanXml();
		mapperLoadDemo.mapLoadByAnnotation();

	}

}
