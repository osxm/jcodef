/**
 * @Title: StockDetail.java
 * @Package cn.osxm.jcodef.biz.stock.model
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.model;

/**
 * @ClassName: StockDetail
 * @Description: TODO
 * @author oscarchen
 */
public class StockDetail {
	// ID and key
	StockUionPKID uionPKID = new StockUionPKID();

	private String sname;

	private float open;

	private float close;

	private float high;

	private float low;

	private float volume;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public StockUionPKID getUionPKID() {
		return uionPKID;
	}

	public void setUionPKID(StockUionPKID uionPKID) {
		this.uionPKID = uionPKID;
	}

	public float getOpen() {
		return open;
	}

	public void setOpen(float open) {
		this.open = open;
	}

	public float getClose() {
		return close;
	}

	public void setClose(float close) {
		this.close = close;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getLow() {
		return low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

}
