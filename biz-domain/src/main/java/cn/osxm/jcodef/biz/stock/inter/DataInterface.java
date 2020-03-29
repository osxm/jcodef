/**
 * @Title: DataInterface.java
 * @Package cn.osxm.jcodef.biz.stock.inter
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.inter;

/**
 * @ClassName: DataInterface
 * @Description: TODO
 * @author oscarchen
 */
public class DataInterface {
	// public List<User>

	/**
	 * 
	 * @Title: getStockPriceList
	 * @Description: TODO
	 * @param stockId
	 * @param endDate
	 * @return
	 */
	public List<Stock> getStockPriceList(String stockId) {
		List<Stock> list = null;
		String jsonArryStr = getSingleHistroyStr(stockId);
		if (jsonArryStr != null && jsonArryStr.trim().length() > 0) {
			JSONArray rtnArray = JSONArray.fromObject(jsonArryStr);
			if (rtnArray != null && rtnArray.size() > 0) {
				list = new ArrayList<Stock>();
				String day = "";
				float volumeCount = 0;
				for (int i = 0; i < rtnArray.size(); i++) {
					JSONObject jsObj = rtnArray.getJSONObject(i);
					String dayTime = jsObj.getString("day");
					float open = (float) jsObj.getDouble("open");
					float high = (float) jsObj.getDouble("high");
					float low = (float) jsObj.getDouble("low");
					float close = (float) jsObj.getDouble("close");
					float volume = (float) jsObj.getDouble("volume");

					String dayTemp = dayTime.substring(0, 10);
					String timeTemp = dayTime.substring(11);
					if (i == 0) {
						day = dayTemp;
						volumeCount += volume;
					} else {
						if (day.equals(dayTemp)) {
							volumeCount += volume;
							if (timeTemp.equals("15:00:00")) {
								Stock stock = new Stock();
								stock.getUionPKID().setId(stockId);
								stock.getUionPKID().setSdate(day);
								stock.setOpen(open);
								stock.setHigh(high);
								stock.setLow(low);
								stock.setClose(close);
								stock.setVolume(volumeCount);
								list.add(stock);
							}
						} else {
							day = dayTemp;
							volumeCount = 0;
							volumeCount += volume;

						}
					}

				}
			}
		}
		return list;
	}

	/**
	 * 
	 * @Title: getStockPriceList
	 * @Description: TODO
	 * @param stockId
	 * @param endDate
	 * @return
	 */
	public List<StockDetail> getStockDetailList(String stockId) {
		List<StockDetail> list = null;
		String jsonArryStr = getSingleHistroyStr(stockId);
		if (jsonArryStr != null && jsonArryStr.trim().length() > 0) {
			JSONArray rtnArray = JSONArray.fromObject(jsonArryStr);
			if (rtnArray != null && rtnArray.size() > 0) {
				list = new ArrayList<StockDetail>();
				String day = "";
				float volumeCount = 0;
				for (int i = 0; i < rtnArray.size(); i++) {
					JSONObject jsObj = rtnArray.getJSONObject(i);
					String dayTime = jsObj.getString("day");
					float open = (float) jsObj.getDouble("open");
					float high = (float) jsObj.getDouble("high");
					float low = (float) jsObj.getDouble("low");
					float close = (float) jsObj.getDouble("close");
					float volume = (float) jsObj.getDouble("volume");

					String dayTemp = dayTime.substring(0, 10);
					String timeTemp = dayTime.substring(11);
					if (i == 0) {
						day = dayTemp;
						volumeCount += volume;
					} else {
						if (day.equals(dayTemp)) {
							volumeCount += volume;
							if (timeTemp.equals("15:00:00")) {
								StockDetail stockDetail = new StockDetail();
								stockDetail.getUionPKID().setId(stockId);
								stockDetail.getUionPKID().setSdate(day);
								stockDetail.setOpen(open);
								stockDetail.setHigh(high);
								stockDetail.setLow(low);
								stockDetail.setClose(close);
								stockDetail.setVolume(volumeCount);
								list.add(stockDetail);
							}
						} else {
							day = dayTemp;
							volumeCount = 0;
							volumeCount += volume;

						}
					}

				}
			}
		}
		return list;
	}

	/**
	 * [{day:"2018-07-09
	 * 15:00:00",open:"3.390",high:"3.430",low:"3.380",close:"3.420",volume:"142388458"}]
	 * 
	 * @Title: getSingleHistroy
	 * @Description: TODO
	 * @param stockId
	 * @return
	 */
	public String getSingleHistroyStr(String stockId) {
		String rtnStr = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String url = getHistoryDataUrl(stockId);
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(get);
			// int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			rtnStr = EntityUtils.toString(entity, "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// System.out.println("getSingleData:"+rtnStr);
		return rtnStr;
	}

	public StockDetail getSingleCurrentDay(String stockId) {
		StockDetail stock = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String url = getCurDataUrl(stockId);
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = simpleDateFormat.format(new Date());
		try {
			response = httpClient.execute(get);
			// int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			String rtnStr = EntityUtils.toString(entity, "utf-8"); // var
																	// hq_str_sz000725="京东方Ａ,3.420,3.420,3.420,3.460,3.400,3.410,3.420,227630257,780430212.430,6448796,3.410,9337900,3.400,var
																	// hq_str_sz000725="京东方Ａ,3.420,3.420,3.420,3.460,3.400,3.410,3.420,227630257,780430212.430,6448796,3.410,9337900,3.400“
			String[] rtnStrArry = rtnStr.split("=\"");
			if (rtnStrArry != null && rtnStrArry.length > 1) {
				String[] dataArray = rtnStrArry[1].split(",");
				if (dataArray.length > 7) {
					String close = dataArray[3];
					String high = dataArray[4];
					String low = dataArray[5];
					String volumn = dataArray[8];

					stock = new StockDetail();
					stock.getUionPKID().setId(stockId);
					stock.getUionPKID().setSdate(sdate);
					stock.setClose(Float.valueOf(close));
					stock.setHigh(Float.valueOf(high));
					stock.setLow(Float.valueOf(low));
					stock.setVolume(Float.valueOf(volumn));
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// System.out.println("getSingleData:"+rtnStr);
		return stock;
	}

	/**
	 * 
	 * @Title: getHistoryDataUrl
	 * @Description: TODO
	 * @param stockId sz000839
	 * @param endDate 2018-07-04
	 * @return
	 */
	private String getHistoryDataUrl(String stockId) {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(
				"http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=");
		strBuf.append(stockId);
		strBuf.append("&scale=60&ma=no&datalen=1023");
		return strBuf.toString();
	}

	// http://hq.sinajs.cn/list=sz000666
	private String getCurDataUrl(String stockId) {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("http://hq.sinajs.cn/list=");
		strBuf.append(stockId);
		return strBuf.toString();
	}
}
