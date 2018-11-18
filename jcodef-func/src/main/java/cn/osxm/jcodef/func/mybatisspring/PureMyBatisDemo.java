/**
 * @Title: PureMyBatisDemo.java
 * @Package cn.osxm.jcodef.func.mybatisspring
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月18日 上午10:28:30
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.osxm.jcodef.func.mybatisspring.dao.PureMyBatis;
import cn.osxm.jcodef.func.mybatisspring.model.Chart;

/**
 * @ClassName: PureMyBatisDemo
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class PureMyBatisDemo {

	public void pureMyBatisDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"cn/osxm/jcodef/func/mybatisspring/spring-puremybatis.xml");
		PureMyBatis pureMyBatis = (PureMyBatis) context.getBean("pureMyBatis");
//         Chart chart = pureMyBatis.getChartById(1);
//         System.out.println(chart.getName());
		Chart chart = new Chart();
		chart.setName("Second Chart");
		chart.setDescription("This is insert by Pure Mybatis in MyBatis-Spring");
		pureMyBatis.insertChart(chart);
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PureMyBatisDemo pureMyBatisDemo = new PureMyBatisDemo();
		pureMyBatisDemo.pureMyBatisDemo();

	}

}
