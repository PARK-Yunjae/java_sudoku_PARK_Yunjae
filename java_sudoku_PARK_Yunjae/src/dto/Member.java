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
	
	public Member() {}
	
	public Member(String id, String pw, String name) {
		this.memberNum = ++num;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	private Member(String memberNum, String id, String pw, String name) {
		this.memberNum = Integer.parseInt(memberNum);
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	private static Member CreateMemeber(String[] info) {
		if(info == null || info.length == 0) {
			return null;
		}
		
		return new Member(info[0], info[1], info[2], info[3]);
	}
}
