/**
 * @Title: ChartAnoServiceImpl.java
 * @Package cn.osxm.jcodef.func.mybatisspring.service.impl
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月18日 上午10:16:19
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring.service.impl;

import cn.osxm.jcodef.func.mybatisspring.mapper.ChartAnoMapper;
import cn.osxm.jcodef.func.mybatisspring.model.Chart;
import cn.osxm.jcodef.func.mybatisspring.service.ChartService;

/**
 * @ClassName: ChartAnoServiceImpl
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class ChartAnoServiceImpl implements ChartService {
	private ChartAnoMapper chartAnoMapper;

	public ChartAnoMapper getChartAnoMapper() {
		return chartAnoMapper;
	}

	public void setChartAnoMapper(ChartAnoMapper chartAnoMapper) {
		this.chartAnoMapper = chartAnoMapper;
	}

	public Chart getChartById(int id) {
		// TODO Auto-generated method stub
		return chartAnoMapper.getChartById(id);
	}

	public void insert(Chart chart) {
		// TODO Auto-generated method stub

	}

}
