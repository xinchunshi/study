/**
 * 
 */
package study.wshi.bean;

/**
 * @author wincent.shi
 *
 */
public class WordsBean {
private String word;
public String getWord() {
	return word;
}
public void setWord(String word) {
	this.word = word;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
private int id;
private int uid;
private String gifurl;
public String getGifurl() {
	return gifurl;
}
public void setGifurl(String gifurl) {
	this.gifurl = gifurl;
}
public String getMp3url() {
	return mp3url;
}
public void setMp3url(String mp3url) {
	this.mp3url = mp3url;
}
private String mp3url;
public String getPingyin() {
	return pingyin;
}
public void setPingyin(String pingyin) {
	this.pingyin = pingyin;
}
public String getBushou() {
	return Bushou;
}
public void setBushou(String bushou) {
	Bushou = bushou;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public String[] getWordstone() {
	return wordstone;
}
public void setWordstone(String[] wordstone) {
	this.wordstone = wordstone;
}
private String pingyin;
private String Bushou;
private int total;
private String[] wordstone;
}
