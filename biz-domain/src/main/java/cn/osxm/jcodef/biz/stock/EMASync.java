/**
 * @Title: EMASync.java
 * @Package cn.osxm.jcodef.biz.stock
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock;

import org.junit.Test;

/**
  * @ClassName: EMASync
  * @Description: TODO
  * @author oscarchen
  */
public class EMASync {
	@Test
	public void getEMA() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://finance.sina.com.cn/realstock/company/sz300036/nc.shtml");
		try {
			CloseableHttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			String rtnStr = EntityUtils.toString(entity, "utf-8");
			System.out.println(rtnStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
