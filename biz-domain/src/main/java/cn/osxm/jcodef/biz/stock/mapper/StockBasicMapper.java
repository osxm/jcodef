/**
 * @Title: StockBasicMapper.java
 * @Package cn.osxm.jcodef.biz.stock.mapper
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.mapper;

/**
  * @ClassName: StockBasicMapper
  * @Description: TODO
  * @author oscarchen
  */
public interface StockBasicMapper {
	public List<StockBasic> findStrockBasics();
	public List<StockBasic> findStrockBasicsByMarket(String market);
}
