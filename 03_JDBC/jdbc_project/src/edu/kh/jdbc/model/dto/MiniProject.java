package edu.kh.jdbc.model.dto;

public class MiniProject {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String phoneNumber;
	private String memberAddress;
	private String memberDel;
	private String memberName;
	private String memberSsn;
	
	public MiniProject() {}

	public MiniProject(int memberNo, String memberId, String memberPw, String phoneNumber, String memberAddress,
			String memberDel) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.phoneNumber = phoneNumber;
		this.memberAddress = memberAddress;
		this.memberDel = memberDel;
	}

	public MiniProject(int memberNo, String memberId, String memberPw, String phoneNumber, String memberAddress,
			String memberDel, String memberName, String memberSsn) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.phoneNumber = phoneNumber;
		this.memberAddress = memberAddress;
		this.memberDel = memberDel;
		this.memberName = memberName;
		this.memberSsn = memberSsn;
	}
	

	public MiniProject(String memberId, String memberPw, String phoneNumber, String memberAddress, String memberDel,
			String memberName, String memberSsn) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.phoneNumber = phoneNumber;
		this.memberAddress = memberAddress;
		this.memberDel = memberDel;
		this.memberName = memberName;
		this.memberSsn = memberSsn;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberDel() {
		return memberDel;
	}

	public void setMemberDel(String memberDel) {
		this.memberDel = memberDel;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberSsn() {
		return memberSsn;
	}

	public void setMemberSsn(String memberSsn) {
		this.memberSsn = memberSsn;
	};
	 
	
}
