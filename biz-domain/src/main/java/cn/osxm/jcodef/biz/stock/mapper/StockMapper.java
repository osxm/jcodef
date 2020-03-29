/**
 * @Title: StockMapper.java
 * @Package cn.osxm.jcodef.biz.stock.mapper
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.mapper;

/**
  * @ClassName: StockMapper
  * @Description: TODO
  * @author oscarchen
  */
public interface StockMapper {
	public List<Stock> findStrockDatas(String fullId);
}
