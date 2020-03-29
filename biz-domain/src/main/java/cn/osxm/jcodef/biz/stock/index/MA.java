/**
 * @Title: MA.java
 * @Package cn.osxm.jcodef.biz.stock.index
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.index;

/**
 * @ClassName: MA
 * @Description: TODO
 * @author oscarchen
 */
public class MA {
	private String stockId;
	private StockDataService stockService;

	public MA(String stockId) {
		this.stockId = stockId;
		stockService = new StockDataService();
	}

	// 5,10,30,60,120,240
	public float getMA(int iDays) {
		float fvalue = 0;
		StockMyBaticService service = new StockMyBaticService();
		try {

			List<StockDetail> list = service.getStockDetailList(stockId);
			fvalue = getMA(iDays, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fvalue;
	}

	public float getMA(int iDays, List<StockDetail> list) {
		float fvalue = 0;
		try {
			float total = 0;
			if (list != null && list.size() > 0 && list.size() > iDays) {
				for (int i = 0; i < iDays; i++) {
					StockDetail stock = list.get(i);
					total += Float.valueOf(stock.getClose());
				}
			}
			fvalue = total / iDays;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fvalue;
	}
}
