/**
 * @Title: ByteTests.java
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
  * @ClassName: ByteTests
  * @Description: TODO
  * @author oscarchen
  */
public class ByteTests {
	   @Test
	    public void intToByte() {
	        // -128 到 127 
	        int i = 1;
	        byte b = (byte)i;
	        Assert.assertTrue(b==1);
	        
	        i = -1 ;
	        b = (byte)i;
	        Assert.assertTrue(b==-1);
	        
	        //超过127
	        i = 128 ;
	        b = (byte)i;
	        Assert.assertTrue(b==-128);
	        
	        i = 129 ;
	        b = (byte)i;
	        Assert.assertTrue(b==-127);
	        
	        i = 256 ;
	        b = (byte)i;
	        Assert.assertTrue(b==0);
	    }
}
