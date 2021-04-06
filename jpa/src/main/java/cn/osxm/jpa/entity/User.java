/**
 * @Title: User.java
 * @Package cn.osxm.jcodef.jpa.entity
 * @Description: TODO
 * @author oscarchen
 * @date 2021å¹?4æœ?1æ—?
 * @version V1.0
 */
package cn.osxm.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName: User
 * @Description: TODO
 * @author oscarchen
 */
@Entity
public class User {

	@Id
	private String id;

	private String name;

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
	
	public String toString() {
		return this.id+","+this.name;
	}

}
