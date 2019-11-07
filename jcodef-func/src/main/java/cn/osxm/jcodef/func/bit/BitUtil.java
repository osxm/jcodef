/**
 * @Title: BitUtil.java
 * @Package cn.osxm.jcodef.func.bit
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月7日
 * @version V1.0
 */
package cn.osxm.jcodef.func.bit;

/**
  * @ClassName: BitUtil
  * @Description: TODO
  * @author oscarchen
  */
public class BitUtil {
	   /**
     * 
      * @Title: byteToBitStr
      * @Description: TODO
      * @param by  8
      * @return    00001000
     */
    public static String byteToBitStr(byte by) {
        StringBuffer sb = new StringBuffer();
        //每一位与 000000001按位与运算。保证每一位是 0或者1
        sb.append((by>>7)&0x1);
        sb.append((by>>6)&0x1);
        sb.append((by>>5)&0x1);
        sb.append((by>>4)&0x1);
        sb.append((by>>3)&0x1);
        sb.append((by>>2)&0x1);
        sb.append((by>>1)&0x1);
        sb.append((by>>0)&0x1);
        return sb.toString();
    }
}
