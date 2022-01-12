package kr.green.green.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {
	private int bd_num;
	private String bd_title;
	private String bd_contents;
	private Date bd_reg_date;
	private Date bd_up_date;
	private String bd_type;
	private String bd_me_id;
	private int bd_ori_num;
	private String bd_del;
	private Date bd_del_date;
	public int getBd_num() {
		return bd_num;
	}
	public void setBd_num(int bd_num) {
		this.bd_num = bd_num;
	}
	public String getBd_title() {
		return bd_title;
	}
	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}
	public String getBd_contents() {
		return bd_contents;
	}
	public void setBd_contents(String bd_contents) {
		this.bd_contents = bd_contents;
	}
	
	//이거는 getBd_reg_date().toString()이 호출되어서 지저분하게 나옴
	//ex. 	Fri Jan 07 09:43:39 KST 2022
	public Date getBd_reg_date() {
		return bd_reg_date;
	}
	//Date를 String으로
	public String getBd_reg_date_str() {
		//Date->String으로 형변환
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(bd_reg_date);
	}
	public void setBd_reg_date(Date bd_reg_date) {
		this.bd_reg_date = bd_reg_date;
	}
	public Date getBd_up_date() {
		return bd_up_date;
	}
	public void setBd_up_date(Date bd_up_date) {
		this.bd_up_date = bd_up_date;
	}
	public String getBd_type() {
		return bd_type;
	}
	public void setBd_type(String bd_type) {
		this.bd_type = bd_type;
	}
	public String getBd_me_id() {
		return bd_me_id;
	}
	public void setBd_me_id(String bd_me_id) {
		this.bd_me_id = bd_me_id;
	}
	public int getBd_ori_num() {
		return bd_ori_num;
	}
	public void setBd_ori_num(int bd_ori_num) {
		this.bd_ori_num = bd_ori_num;
	}
	public String getBd_del() {
		return bd_del;
	}
	public void setBd_del(String bd_del) {
		this.bd_del = bd_del;
	}
	public Date getBd_del_date() {
		return bd_del_date;
	}
	public void setBd_del_date(Date bd_del_date) {
		this.bd_del_date = bd_del_date;
	}
	@Override
	public String toString() {
		return "BoardVO [bd_num=" + bd_num + ", bd_title=" + bd_title + ", bd_contents=" + bd_contents
				+ ", bd_reg_date=" + bd_reg_date + ", bd_up_date=" + bd_up_date + ", bd_type=" + bd_type + ", bd_me_id="
				+ bd_me_id + ", bd_ori_num=" + bd_ori_num + ", bd_del=" + bd_del + ", bd_del_date=" + bd_del_date + "]";
	}
	
	
}
