/**
 * @Title: ServerPasswordCallback.java
 * @Package cn.osxm.jcodef.springcxf.security
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月19日 上午7:10:48
 * @version V1.0
 */

package cn.osxm.jcodef.springcxf.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

/**
 * @ClassName: ServerPasswordCallback
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class ServerPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
			if (pc.getIdentifier().equals("osxm")) {
				pc.setPassword("111111");
				return;
			}
		}
	}

}
