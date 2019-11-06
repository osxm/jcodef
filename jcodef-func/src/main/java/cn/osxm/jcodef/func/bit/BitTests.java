/**
 * @Title: BitTests.java
 * @Package cn.osxm.jcodef.func.bit
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月6日
 * @version V1.0
 */
package cn.osxm.jcodef.func.bit;

import org.junit.Assert;
import org.junit.Test;

/**
  * @ClassName: BitTests
  * @Description: TODO
  * @author oscarchen
  */
public class BitTests {
	   //@Test
    public void byteToBitStr() {
        byte by = 8; //00001000
        //String bitStr = BitUtil.byteToBitStr(by);
       // Assert.assertTrue(bitStr.equals("00001000"));
    }
    
    @Test 
    public void longToString() {
        int i = 1;
        String str = Long.toString(i,16);
        Assert.assertTrue(str.equals("1"));
        
        i = 20;
        str = Long.toString(i,16);
        Assert.assertTrue(str.equals("14"));//1*16+4 = 20
        
        i=200;
        str = Long.toString(i,16);
        Assert.assertTrue(str.equals("c8"));//12*16+8 = 20
        System.out.println(str);
    }
}
