/**
 * @Title: ClientPasswordCallback.java
 * @Package cn.osxm.jcodef.springcxf.client
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2018年11月19日 下午10:49:04
 * @version V1.0
 */

package cn.osxm.jcodef.springcxf.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

/**
  * @ClassName: ClientPasswordCallback
  * @Description: TODO
  * @author osxm:oscarxueming
  */

public class ClientPasswordCallback implements CallbackHandler {

    public void handle(Callback[] callbacks) throws IOException,  
            UnsupportedCallbackException {  
        for(int i=0;i<callbacks.length;i++){  
            WSPasswordCallback ps=(WSPasswordCallback) callbacks[i];  
            ps.setPassword("111111");  
            ps.setIdentifier("osxm");  
        }  
    }
}
