package dto;

public class Member {
	private static int num;
	private int memberNum;
	private String id;
	private String pw;
	private String name;
	
	public int getMemberNum() {
		return memberNum;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getName() {
		return name;
	}
	
	public Member(String id, String pw, String name) {
		this.memberNum = ++num;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
}
