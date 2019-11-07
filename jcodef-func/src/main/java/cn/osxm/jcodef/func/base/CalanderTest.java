/**
 * @Title: CalanderTest.java
 * @Package cn.osxm.jcodef.func.base
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月7日
 * @version V1.0
 */
package cn.osxm.jcodef.func.base;

import java.util.Calendar;

/**
  * @ClassName: CalanderTest
  * @Description: TODO
  * @author oscarchen
  */
public class CalanderTest {
    /**
     * @Title: main
     * @Description: TODO
     * @param args
     */

   public static void main(String[] args) {
       // TODO Auto-generated method stub
       Calendar date = Calendar.getInstance();
      System.out.println(String.valueOf(date.get(Calendar.YEAR)));
   }

}
