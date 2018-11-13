/**
 * @Title: ChartService.java
 * @Package cn.osxm.jcodef.func.mybatisspring.service.impl
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月14日 上午6:11:53
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring.service.impl;

import cn.osxm.jcodef.func.mybatisspring.mapper.ChartMapper;
import cn.osxm.jcodef.func.mybatisspring.model.Chart;
import cn.osxm.jcodef.func.mybatisspring.service.ChartService;

/**
 * @ClassName: ChartService
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class ChartServiceImpl implements ChartService {

	private ChartMapper chartMapper;

	public void setChartMapper(ChartMapper chartMapper) {
		this.chartMapper = chartMapper;
	}

	public Chart getChartById(int id) {
		return chartMapper.getChartById(id);
	}

}
