/**
 * @Title: StockUionPKID.java
 * @Package cn.osxm.jcodef.biz.stock.model
 * @Description: TODO
 * @author oscarchen
 * @date 2020年3月28日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.stock.model;

/**
 * @ClassName: StockUionPKID
 * @Description: TODO
 * @author oscarchen
 */
public class StockUionPKID implements java.io.Serializable {
	/**
	 * @Fields serialVersionUID : TODO
	 */

	private static final long serialVersionUID = 1L;
	private String id;
	private String sdate;

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StockUionPKID) {
			StockUionPKID pk = (StockUionPKID) obj;
			if (this.id.equals(pk.id) && this.sdate.equals(pk.sdate)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
