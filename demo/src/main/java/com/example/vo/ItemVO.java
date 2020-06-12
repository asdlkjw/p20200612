package com.example.vo;

public class ItemVO {
	
	
	@Override
	public String toString() {
		return "ItemVO [it_no=" + it_no + ", it_na=" + it_na + ", it_exp=" + it_exp + ", it_price=" + it_price
				+ ", it_itno=" + it_itno + ", it_date=" + it_date + "]";
	}
	
	private int it_no = 0;
	private String it_na = null;
	private String it_exp = null;
	private int it_price = 0;
	private int it_itno = 0;
	private String it_date = null;
	
	
	public int getIt_no() {
		return it_no;
	}
	public void setIt_no(int it_no) {
		this.it_no = it_no;
	}
	public String getIt_na() {
		return it_na;
	}
	public void setIt_na(String it_na) {
		this.it_na = it_na;
	}
	public String getIt_exp() {
		return it_exp;
	}
	public void setIt_exp(String it_exp) {
		this.it_exp = it_exp;
	}
	public int getIt_price() {
		return it_price;
	}
	public void setIt_price(int it_price) {
		this.it_price = it_price;
	}
	public int getIt_itno() {
		return it_itno;
	}
	public void setIt_itno(int it_itno) {
		this.it_itno = it_itno;
	}
	public String getIt_date() {
		return it_date;
	}
	public void setIt_date(String it_date) {
		this.it_date = it_date;
	}

	
}
