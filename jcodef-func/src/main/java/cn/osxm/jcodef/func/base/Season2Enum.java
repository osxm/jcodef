/**
 * @Title: Season2Enum.java
 * @Package cn.osxm.jcodef.func.base
 * @Description: TODO
 * @author oscarchen
 * @date 2020年7月9日
 * @version V1.0
 */
package cn.osxm.jcodef.func.base;

/**
  * @ClassName: Season2Enum
  * @Description: TODO
  * @author oscarchen
  */
public enum Season2Enum {
	 SPRING("Spring"), SUMMER("Summer"), AUTUMN("Autumn"), WINTER("Winter");

    private String value;

    Season2Enum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
