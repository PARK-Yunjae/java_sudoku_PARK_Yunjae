package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Rank;

public class RankDAO {
	private static RankDAO instance = new RankDAO();
	private static ArrayList<Rank> rList;

	public RankDAO() {
		rList = new ArrayList<Rank>();
	}

	public static ArrayList<Rank> getrList() {
		return rList;
	}

	public static RankDAO getInstance() {
		return instance;
	}

	// 텍스트 파일 저장용 데이터 만들기
	public static String DataToFile() {
		String data = "";
		if (rList.size() == 0)
			return data;
		for (Rank m : rList) {
			data += m.DataToFile() + "\n";
		}
		data = data.substring(0, data.length() - 1);
		return data;
	}

	// 텍스트파일에서 문자열 받아와서 데이터 넣기
	public static void FileToData(List<String> data) {
		if (data.isEmpty())
			return;
		for (int i = 0; i < data.size(); i += 1) {
			String[] info = data.get(i).split("/");
			rList.add(Rank.CreateMember(info));
		}
	}

	// 스도쿠 클리어 랭크 등록
	public void joinRank(String name, int score, int time, String level) {
		int num = 0;
		if (level.equals("EASY")) {
			num = 1;
		} else if (level.equals("NORMAL")) {
			num = 2;
		} else if (level.equals("HARD")) {
			num = 3;
		}
		rList.add(new Rank(name, score, time+"", num));
	}
	
	// 랭크 리스트 테이블 출력용 보내주기
	public List<Rank> RankList(int level){
		List<Rank> list =  new ArrayList<Rank>();
		System.out.println(rList.size());
		for(int i=0 ; i<rList.size() ; i+=1) {
			if(rList.get(i).getLevel() == level) {
				list.add(rList.get(i));
			}
		}
		return list;
	}
}
