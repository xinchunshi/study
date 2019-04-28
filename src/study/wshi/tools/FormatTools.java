/**
 * 
 */
package study.wshi.tools;

import study.wshi.bean.WordsBean;

/**
 * @author wincent.shi
 *
 */
public class FormatTools {

	public static WordsBean findInHtmlWord(String content) {
		// TODO Auto-generated method stub
		WordsBean wordsbean=new WordsBean();
//		wordsbean.setGifurl(findHtmlByID(content,"","","",""));
		wordsbean.setGifurl(findHtmlByID(content,"<div class=\"bishun-outer\">","</div>","data-src=\"","\""));
		wordsbean.setMp3url(findHtmlByID(content,"<ul id=\"header-list\">","</ul>","<a herf=\"#\" url=\"","\""));
		wordsbean.setBushou(findHtmlByID(content,"<li id=\"radical\">","</li>","<span>","</span>"));
		wordsbean.setTotal(Integer.parseInt(findHtmlByID(content,"<li id=\"stroke_count\">","</li>","<span>","</span>")));
		wordsbean.setPingyin(findHtmlByID(content,"<li id=\"tone_py\">","</li>","<b>","</b>"));
		wordsbean.setWordstone(findListHtmlByID(content,"<div class=\"related_idiom\">","</div>","ptype=term\">","</a>"));
//		String ulStart="<ul id=\"header-list\">";
//		String ulend="</ul>";
//		String temp=content.substring(content.indexOf(ulStart));
//		temp=temp.substring(0,temp.indexOf(ulend));
//		System.out.println(temp);
//		wordsbean.setMp3url(temp.substring(temp.indexOf("http://"), temp.indexOf("\" class=\"mp3-play\"")));
//		wordsbean.setBushou(findHtmlByID(temp,"<li id=\"radical\">","</li>"));
//		wordsbean.setTotal(Integer.parseInt(findHtmlByID(temp,"<li id=\"stroke_count\">","</li>")));
//		wordsbean.setPingyin(temp.substring(temp.indexOf("<b>"+3), temp.indexOf("</b>")));
		return wordsbean;
	}

	private static String findHtmlByID(String content,String idStart,String idEnd,String conStart,String conEnd) {
		// TODO Auto-generated method stub
		String temp=content.substring(content.indexOf(idStart));
		temp=temp.substring(0, temp.indexOf(idEnd));
		String result=temp.substring(temp.indexOf(conStart)+conStart.length());
		result=result.substring(0,result.indexOf(conEnd));	
		return result;
	}
	private static String[] findListHtmlByID(String content,String idStart,String idEnd,String conStart,String conEnd) {
		// TODO Auto-generated method stub
		String temp=content.substring(content.indexOf(idStart));
		temp=temp.substring(0, temp.indexOf(idEnd));
		String result= "";
		while (temp.indexOf(conStart)>0) {
			temp=temp.substring(temp.indexOf(conStart)+conStart.length());
			result=result+temp.substring(0,temp.indexOf(conEnd))+",";
		}
		if(result.endsWith(","))
			result=result.substring(0,-1);
		return result.split(",");
	}

}
