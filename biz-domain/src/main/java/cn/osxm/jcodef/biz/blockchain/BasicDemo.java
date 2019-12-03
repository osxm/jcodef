/**
 * @Title: BasicDemo.java
 * @Package cn.osxm.jcodef.biz.blockchain
 * @Description: TODO
 * @author oscarchen
 * @date 2019年12月3日
 * @version V1.0
 */
package cn.osxm.jcodef.biz.blockchain;

/**
 * @ClassName: BasicDemo
 * @Description: TODO
 * @author oscarchen
 */
public class BasicDemo {
	public static boolean isHashValid(String hash, int difficulty) {
		String prefix = repeat("0", difficulty);
		return hash.startsWith(prefix);
	}

	private static String repeat(String str, int repeat) {
		final StringBuilder buf = new StringBuilder();
		for (int i = 0; i < repeat; i++) {
			buf.append(str);
		}
		return buf.toString();
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
