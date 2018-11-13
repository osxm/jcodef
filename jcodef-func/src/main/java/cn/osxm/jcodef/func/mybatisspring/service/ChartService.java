/**
 * @Title: ChartServiceI.java
 * @Package cn.osxm.jcodef.func.mybatisspring.service
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月14日 上午6:11:34
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatisspring.service;

import cn.osxm.jcodef.func.mybatisspring.model.Chart;

/**
  * @ClassName: ChartServiceI
  * @Description: TODO
  * @author osxm:oscarxueming
  */

public interface ChartService {

	public Chart getChartById(int id);
	
	public void insert(Chart chart);
}
