/**
 * @Title: ChartAnoMapper.java
 * @Package cn.osxm.jcodef.func.mybatisspring.mapper
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月18日 上午10:14:17
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring.mapper;

import org.apache.ibatis.annotations.Select;

import cn.osxm.jcodef.func.mybatisspring.model.Chart;

/**
 * @ClassName: ChartAnoMapper
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public interface ChartAnoMapper {
	@Select("select * from base_chart where id=#{id}")
	Chart getChartById(int id);
}
