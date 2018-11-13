/**
 * @Title: ChartMapper.java
 * @Package cn.osxm.jcodef.func.mybatis.mapper
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月12日 下午9:30:51
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring.mapper;

import cn.osxm.jcodef.func.mybatisspring.model.Chart;

/**
  * @ClassName: ChartMapper
  * @Description: TODO
  * @author osxm:oscarxueming
  */

public interface ChartMapper {
	Chart getChartById(int id);
	
	void insertChart(Chart chart);
}
