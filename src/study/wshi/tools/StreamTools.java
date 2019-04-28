/**
 * 
 */
package study.wshi.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wincent.shi
 *
 */
public class StreamTools {
	//把输入流的内容转换成字符串
    public static String readStream(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while( (len = is.read(buffer))!=-1){
                baos.write(buffer, 0, len);
            }
            is.close();
            String temptext = new String(baos.toByteArray());
            if(temptext.contains("charset=gb2312")){//解析meta标签
                return new String(baos.toByteArray(),"gb2312");
            }else{
                return new String(baos.toByteArray(),"utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
