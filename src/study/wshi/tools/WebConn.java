/**
 * 
 */
package study.wshi.tools;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author wincent.shi
 *
 */
public class WebConn {
	public static String getWebContentByUrl(String st_url,String code) {
		// TODO Auto-generated method stub
//		saveLog.printlog(st_url);
//		saveLog.printlog(st_url);
		String result="";
		try {
			URL  url = new URL(st_url);
			
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			String strProxy="10.237.80.137";
//			String strPort="8080";
//			Properties systemProperties = System.getProperties();
//			systemProperties.setProperty("http.proxyHost",strProxy);
//			systemProperties.setProperty("http.proxyPort",strPort); 
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			connectionData = url.openConnection();
//			connectionData.setConnectTimeout(5000);
//			br = new BufferedReader(new InputStreamReader(
//			connectionData.getInputStream(), code));
//			sb = new StringBuilder();
//			String line = null;
//			while ((line = br.readLine()) != null)
//				sb.append(line); 
//			result = sb.toString(); 		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");//声明请求方式 默认get
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; U; Android 2.3.3; zh-cn; sdk Build/GRI34) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MicroMessenger/6.0.0.57_r870003.501 NetType/internet");
            int status = conn.getResponseCode();
//            System.out.println(status);
            if(status ==200){
                InputStream is = conn.getInputStream();
                result = StreamTools.readStream(is);
//                System.out.print(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//		conn.setRequestProperty("content-type", "text/html;charset=utf-8");
//		conn.setConnectTimeout(10000);
//		InputStream is = conn.getInputStream();
//		BufferedReader in = new BufferedReader(new InputStreamReader(is));
//		StringBuffer text = new StringBuffer();
//		String line = null;
//		while ((line = in.readLine()) != null) {
//			text.append(line);
//		}
//		if (is != null) {
//			is.close();
//		}
//		if (conn != null) {
//			conn.disconnect();
//		}
//		result=text.toString();
//		result=new String("UTF-8","ISO-8859-1");  
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("webConn.getWebContentByUrl has errors, please check you intenet network");
//		} 
		return result;
	}
	public static InputStream  getWebBlobByUrl(String st_url) {
		// TODO Auto-generated method stub
//		saveLog.printlog(st_url);
//		saveLog.printlog(st_url);
		InputStream is=null;
		try {
			URL  url = new URL(st_url);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");//声明请求方式 默认get
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; U; Android 2.3.3; zh-cn; sdk Build/GRI34) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MicroMessenger/6.0.0.57_r870003.501 NetType/internet");
            int status = conn.getResponseCode();
//            System.out.println(status);
            if(status ==200){
                is = conn.getInputStream();
//                System.out.print(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return is;
	}
}
