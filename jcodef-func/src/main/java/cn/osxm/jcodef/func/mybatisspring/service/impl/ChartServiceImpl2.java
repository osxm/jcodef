/**
 * @Title: ChartServiceImpl2.java
 * @Package cn.osxm.jcodef.func.mybatisspring.service.impl
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月18日 上午10:24:38
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring.service.impl;

import cn.osxm.jcodef.func.mybatisspring.mapper.ChartMapper2;
import cn.osxm.jcodef.func.mybatisspring.model.Chart;
import cn.osxm.jcodef.func.mybatisspring.service.ChartService;

/**
 * @ClassName: ChartServiceImpl2
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class ChartServiceImpl2 implements ChartService {
	private ChartMapper2 chartMapper2;

	public ChartMapper2 getChartMapper2() {
		return chartMapper2;
	}

	public void setChartMapper2(ChartMapper2 chartMapper2) {
		this.chartMapper2 = chartMapper2;
	}

	public Chart getChartById(int id) {
		// TODO Auto-generated method stub
		return chartMapper2.getChartById(id);
	}

	public void insert(Chart chart) {
		// TODO Auto-generated method stub

	}

}
