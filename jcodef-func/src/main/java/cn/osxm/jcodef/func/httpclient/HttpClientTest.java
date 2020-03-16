/**
 * @Title: HttpClientTest.java
 * @Package cn.osxm.jcodef.func.httpclient
 * @Description: TODO
 * @author oscarchen
 * @date 2020年2月19日
 * @version V1.0
 */
package cn.osxm.jcodef.func.httpclient;

/**
  * @ClassName: HttpClientTest
  * @Description: TODO
  * @author oscarchen
  */
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * @ClassName: HttpClientDemo
 * @Description: TODO
 * @author oscarchen
 */

public class HttpClientTest {

    @Test
    public void getHttps() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // HttpGet httpGet = new HttpGet("https://portal.sun.com/portal/dt");
        //https://www.oracle.com/partners/index.html
        HttpGet httpGet = new HttpGet("https://www.baidu.com/");
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity,"UTF-8"));
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }
    }
}
