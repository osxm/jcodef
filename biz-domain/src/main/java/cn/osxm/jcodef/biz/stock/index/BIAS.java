/**
 * @Title: BIAS.java
 * @Package cn.osxm.jcodef.biz.stock
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.index;

/**
 * @ClassName: BIAS
 * @Description: TODO
 * @author oscarchen
 */
public class BIAS {

	private String stockId;

	private StockMyBaticService service;

	public BIAS(String stockId, StockMyBaticService service) {
		this.stockId = stockId;
		this.service = service;
	}

	/**
	 * 
	 * @Title: getBIASMap
	 * @Description: TODO
	 * @return {bias1: ,bias2: , bias3} 6 12 24
	 */
	public float getBIAS(int idays, boolean closeSession) {
		float f = 0;
		// StockMyBaticService service = new StockMyBaticService();
		List<StockDetail> list = null;
		try {
			list = service.getStockDetailList(stockId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		f = getBIASByDays(idays, list);
		return f;
	}

	private float getBIASByDays(int idays, List<StockDetail> list) {
		float f = 0;
		float curDayClose = 0;
		if (list != null) {
			curDayClose = list.get(0).getClose();
		}
		MA ma = new MA(stockId);
		float maValue = ma.getMA(idays);
		f = (curDayClose - maValue) / maValue * 100;
		return f;
	}
}