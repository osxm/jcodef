/**
 * @Title: PureMyBatis.java
 * @Package cn.osxm.jcodef.func.mybatisspring.dao
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月18日 上午8:51:25
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.osxm.jcodef.func.mybatisspring.mapper.ChartMapper;
import cn.osxm.jcodef.func.mybatisspring.model.Chart;

/**
 * @ClassName: PureMyBatis
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class PureMyBatis implements ChartMapper {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public Chart getChartById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return (Chart) session.selectOne("cn.osxm.jcodef.func.mybatisspring.mapper.ChartMapper.getChartById", id);
		} finally {
			session.close();
		}
	}

	public void insertChart(Chart chart) {
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			session.insert("cn.osxm.jcodef.func.mybatisspring.mapper.ChartMapper.insertChart", chart);
			// session.selectOne("cn.osxm.jcodef.func.mybatisspring.mapper.ChartMapper.insertChart",
			// chart);
		} finally {
			session.close();
		}
	}

}
