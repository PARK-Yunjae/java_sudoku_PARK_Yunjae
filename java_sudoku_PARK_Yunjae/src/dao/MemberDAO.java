package dao;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.Member;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private static ArrayList<Member> mList;
	private String pwPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,20}$";

	public MemberDAO() {
		mList = new ArrayList<Member>();
	}

	public static ArrayList<Member> getmList() {
		return mList;
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	// 아이디 일치 검사
	public int idValue(String id) {
		for (int i = 0; i < mList.size(); i += 1) {
			if (mList.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	// 비밀번호 일치 검사
	public int pwValue(String pw) {
		for (int i = 0; i < mList.size(); i += 1) {
			if (mList.get(i).getPw().equals(pw)) {
				return i;
			}
		}
		return -1;
	}

	// 비밀번호 패턴 맞는지 검사
	public boolean pwPattern(String pw) {
		Pattern p = Pattern.compile(pwPattern);
		Matcher m = p.matcher(pw);
		if (!m.matches()) {
			return true;
		}
		return false;
	}

	// 회원 가입
	public void joinMember(String id, String pw, String name) {
		mList.add(new Member(id, pw, name));
	}
	
	public void printMember() {
		mList.stream().forEach(System.out::println);
	}
}
