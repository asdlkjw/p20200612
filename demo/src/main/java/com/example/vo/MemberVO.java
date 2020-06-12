package com.example.vo;

public class MemberVO {
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + ", username=" + username + ", phone=" + phone
				+ ", userage=" + userage + ", userdate=" + userdate + "]";
	}
	private String userid = null;
	private String password = null;
	private String username = null;
	private String phone = null;
	private int userage = 0;
	private String userdate = null;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserage() {
		return userage;
	}
	public void setUserage(int userage) {
		this.userage = userage;
	}
	public String getUserdate() {
		return userdate;
	}
	public void setUserdate(String userdate) {
		this.userdate = userdate;
	}
	
	

}
