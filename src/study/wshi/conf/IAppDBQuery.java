/**
 * 
 */
package study.wshi.conf;

/**
 * @author wincent.shi
 *
 */
public interface IAppDBQuery {
	public static final String saveWords = "insert into words(uid,word,bushou,bihua,order_pic,read_mp3) values(?,?,?,?,?,?)";
}
