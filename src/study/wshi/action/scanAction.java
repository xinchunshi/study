/**
 * 
 */
package study.wshi.action;

import javax.activation.DataSource;

import com.opensymphony.xwork2.ActionSupport;

import study.wshi.bean.WordsBean;
import study.wshi.dao.DBDao;
import study.wshi.tools.FormatTools;
import study.wshi.tools.WebConn;


/**
 * @author wincent.shi
 *
 */
public class scanAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
//    	  DataSource datasource = this.getDataSource(request);
//    	  Connection conn = datasource.getConnection();
    	System.out.println("执行Action");
    	getWord("直");
        return SUCCESS;
    }
    private void getWord(String word) {
    	System.out.println(word);
    	String url="https://hanyu.baidu.com/zici/s?wd="+word;
    	System.out.println(url);
    	String content=WebConn.getWebContentByUrl(url,"GB2312");
//    	System.out.println(content);
    	WordsBean wordsbean=FormatTools.findInHtmlWord(content);
    	wordsbean.setWord(word);
    	wordsbean.setUid(14);
    	DBDao.saveWords(wordsbean);
    	DBDao.saveWordstone(wordsbean);
    }
    //新增自定义方法
    public String login() {
        return SUCCESS;
    }
}
