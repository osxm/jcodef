/**
 * @Title: MybatisDemo.java
 * @Package cn.osxm.jcodef.func.mybatis
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月12日 下午9:28:46
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatis;
/**
  * @ClassName: MybatisDemo
  * @Description: TODO
  * @author osxm:oscarxueming
  */

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.osxm.jcodef.func.mybatis.mapper.ChartMapper;
import cn.osxm.jcodef.func.mybatis.model.Chart;

/**
 * @ClassName: MybatisDemo
 * @Description: TODO
 * @author oscarchen
 */

public class MybatisDemo {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @throws IOException
	 * @throws Exception
	 */

	public void demo() throws IOException {
		// 1.创建SqlSessionFactory
		String resource = "cn/osxm/jcodef/func/mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2.打开Session
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// 3.1 使用session直接进行查询
			Chart chart = (Chart) session.selectOne("cn.osxm.jcodef.func.mybatis.mapper.ChartMapper.getChartById", 1);
			System.out.println(chart.getName());

			// 3.2 使用映射接口查询
			ChartMapper chartMapper = session.getMapper(ChartMapper.class);
			chart = chartMapper.getChartById(1);
			System.out.println(chart.getName());
		} finally {
			session.close();
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MybatisDemo mybatisDemo = new MybatisDemo();
		mybatisDemo.demo();

	}

}
