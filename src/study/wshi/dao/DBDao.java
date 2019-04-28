/**
 * 
 */
package study.wshi.dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import study.wshi.bean.WordsBean;
import study.wshi.conf.IAppDBQuery;
import study.wshi.tools.WebConn;

/**
 * @author wincent.shi
 *
 */
public class DBDao {

	public static void saveWords(WordsBean wordsbean) {
		// TODO Auto-generated method stub
		Connection conn=null;
		String dbinfo="jdbc:mysql://localhost:3306/study?user=wshi&password=Sxc_kel1&useUnicode=true&characterEncoding=UTF8&useOldAliasMetadataBehavior=true&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();// 动态加载mysql驱动 
			conn = DriverManager.getConnection(dbinfo); 
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(IAppDBQuery.saveWords);
				//insert into words(uid,word,bushou,bihua,order_pic,read_mp3) values(?,?,?,?,?,?);
				pstmt.setInt(1, wordsbean.getUid());
				pstmt.setString(2,wordsbean.getWord());
				pstmt.setString(3,wordsbean.getBushou());
				pstmt.setInt(4,wordsbean.getTotal());
				InputStream  gifin=WebConn.getWebBlobByUrl(wordsbean.getGifurl());
				pstmt.setBlob(5, gifin);
				InputStream  mp3in=WebConn.getWebBlobByUrl(wordsbean.getMp3url());
				pstmt.setBlob(6, mp3in);
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
				gifin.close();
				mp3in.close();
			} catch (SQLException e) {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
//			e.printStackTrace();
	} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void saveWordstone(WordsBean wordsbean) {
		// TODO Auto-generated method stub
		
	}

}
