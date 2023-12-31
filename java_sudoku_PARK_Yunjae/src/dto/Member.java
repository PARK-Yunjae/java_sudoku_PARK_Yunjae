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

	public static void setNum(int num) {
		Member.num = num;
	}

	public Member(String id, String pw, String name) {
		this.memberNum = ++num;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	private Member(String number, String id, String pw, String name) {
		this.memberNum = Integer.parseInt(number);
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public static Member CreateMember(String[] info) {
		if (info == null || info.length == 0)
			return null;

		return new Member(info[0], info[1], info[2], info[3]);
	}

	public String DataToFile() {
		return "%d/%s/%s/%s".formatted(memberNum, id, pw, name);
	}
}
