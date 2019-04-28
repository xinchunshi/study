/**
 * 
 */
package study.wshi.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author wincent.shi
 *
 */
public class adminRightAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        System.out.println("执行Action");
        
        return SUCCESS;
    }
    
    //新增自定义方法
    public String login() {
        return SUCCESS;
    }
}