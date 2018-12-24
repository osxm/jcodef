/**
 * @Title: User.java
 * @Package cn.osxm.jcodef.func.spring
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年12月24日 下午10:29:34
 * @version V1.0
 */

package cn.osxm.jcodef.func.spring;
/**
  * @ClassName: User
  * @Description: TODO
  * @author osxm:oscarxueming
  */

public class User {
	private String name;

    private String age;

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
