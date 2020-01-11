/**
 * @Title: MyApplet.java
 * @Package cn.osxm.jcodef.applet
 * @Description: TODO
 * @author oscarchen
 * @date 2020年1月11日
 * @version V1.0
 */
package cn.osxm.jcodef.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @ClassName: MyApplet
 * @Description: TODO
 * @author oscarchen
 */
public class MyApplet extends Applet {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.drawString(System.getenv("OS"), 5, 35);
	}
}
