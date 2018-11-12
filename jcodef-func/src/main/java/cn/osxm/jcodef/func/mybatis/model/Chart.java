/**
 * @Title: Chart.java
 * @Package cn.osxm.jcodef.func.mybatis.model
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月12日 下午9:32:03
 * @version V1.0
 */

package cn.osxm.jcodef.func.mybatis.model;

/**
 * @ClassName: Chart
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class Chart {
	private int id;

	private String name;

	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
