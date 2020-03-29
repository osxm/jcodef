/**
 * @Title: StockList.java
 * @Package cn.osxm.jcodef.biz.stock.model
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.model;

/**
 * @ClassName: StockList
 * @Description: TODO
 * @author oscarchen
 */
public class StockList {
	private String id;
	private String name;
	private String market;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}
}
