package com.ssafy.test.dto;
public class MemberDto {

	private String userid;
	private String username;
	private String userpwd;
	private String email;
	private String phone;
	private int usertype;
	private String joindate;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public MemberDto(String userid, String username, String userpwd, String email, String phone, int usertype,
		String joindate) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.email = email;
		this.phone = phone;
		this.usertype = usertype;
		this.joindate = joindate;
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}



	@Override
	public String toString() {
		return "MemberDto [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", email=" + email
				+ ", phone=" + phone + ", usertype=" + usertype + ", joindate=" + joindate + "]";
	}
	
	
}
