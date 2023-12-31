package dao;

import java.util.ArrayList;
import java.util.List;
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

	// 텍스트 파일 저장용 데이터 만들기
	public static String DataToFile() {
		String data = "";
		if (mList.size() == 0)
			return data;
		for (Member m : mList) {
			if (m.getMemberNum() != 1000) {
				data += m.DataToFile() + "\n";
			}
		}
		data = data.substring(0, data.length() - 1);
		return data;
	}

	// 텍스트파일에서 문자열 받아와서 데이터 넣기
	public static void FileToData(List<String> data) {
		if (data.isEmpty())
			return;

		int maxMemberNum = 0;
		for (int i = 0; i < data.size(); i += 1) {
			String[] info = data.get(i).split("/");
			if (!info[0].equals("1000")) {
				mList.add(Member.CreateMember(info));
				if (maxMemberNum < Integer.parseInt(info[0])) {
					maxMemberNum = Integer.parseInt(info[0]);
				}
			}
		}
		Member.setNum(maxMemberNum);
	}

}
