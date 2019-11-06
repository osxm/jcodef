/**
 * @Title: BinaryShiftTests.java
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
  * @ClassName: BinaryShiftTests
  * @Description: TODO
  * @author oscarchen
  */
public class BinaryShiftTests {
	 //@Test
    public void shift() {
        int i = 8; //00001000
        //右移一位相当于除以2
        int result = i>>1;
        Assert.assertTrue(result==4);
        
        //左移一位相当于乘以2
        result = i<<1;
        Assert.assertTrue(result==16);     
    }
    
    //@Test
    public void rightShift() {
        byte mybyte=8;//00001000
        int result = mybyte>>1;        
        String bitStr = String.format("%08d", Integer.valueOf(Integer.toBinaryString(result)));
        Assert.assertTrue(result==4);
        Assert.assertTrue(bitStr.equals("00000100"));
        
        
        mybyte=-8;//10001000 = -8    
        result = mybyte>>1;   
        Assert.assertTrue(result==-4);

    }
    
    @Test
    public void unsignedRightShift() {
        byte mybyte=8;
        int  result = mybyte>>>1;        
        Assert.assertTrue(result==4);       
        
        mybyte=-8;//10001000 = -8    
        result = mybyte>>>1;   
        byte newbyte = (byte)result;////注意， 这里会当成int,也就是32比特位，值是2147483644
        Assert.assertTrue(newbyte==-4);

    }
}
