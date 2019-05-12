/**
 * @Title: Html2pdfDemo.java
 * @Package cn.osxm.jcodef.func.html2pdf
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2019年5月12日 下午8:53:39
 * @version V1.0
 */

package cn.osxm.jcodef.func.html2pdf;
/**
  * @ClassName: Html2pdfDemo
  * @Description: TODO
  * @author osxm:oscarxueming
  */


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.ws.spi.http.HttpHandler;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;

/**
 * @ClassName: Html2pdfDemo
 * @Description: TODO
 * @author oscarchen
 */

public class Html2pdfDemo {

    public static void main(String[] args) {
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        // fontResolver.addFont("/Users/hehe/share/Fonts/simsun.ttc",
        // BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //OutputStream os = new FileOutputStream("/Users/hehe/Desktop/iTextPDF.pdf");
        //String htmlstr = HttpHandler.sendGet("http://localhost:10086/test/iTextPDF.html");// HttpHandler.sendGet只是单纯获得指定网页的html字符串内容
        //renderer.setDocumentFromString(htmlstr);
        //renderer.layout();
        //renderer.createPDF(os);
    }

    public boolean convertHtmlToPdf(String inputFile, String outputFile) throws Exception {

        OutputStream os = new FileOutputStream(outputFile);
        ITextRenderer renderer = new ITextRenderer();
        String url = new File(inputFile).toURI().toURL().toString();
        renderer.setDocument(url);

        // 解决中文支持问题
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont("C:/Windows/Fonts/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // 解决图片的相对路径问题
        renderer.getSharedContext().setBaseURL("file:/D:/");
        renderer.layout();
        renderer.createPDF(os);

        os.flush();
        os.close();
        return true;
    }

}

