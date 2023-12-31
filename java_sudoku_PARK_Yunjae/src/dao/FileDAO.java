package dao;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDAO {
	private static FileDAO instance = new FileDAO();
	private String txtPath = "src/files/";
	private Charset charSet = StandardCharsets.UTF_8;
	
	public FileDAO() {
		init();
	}
	
	public static FileDAO getInstance() {
		return instance;
	}
	
	// 텍스트 파일이 없으면 만들기
	private static void createFile(String txtName) {
		Path path = Paths.get("src/files/" + txtName);
		try {
			Files.createFile(path);
		} catch (IOException e) {
			// System.out.println("파일이 이미 있음");
		}
	}

	// 메인 실행할떄 컨트롤러 안에서 불러오면 파일 로드함
	private void init() { 

		createFile("member.txt");
		createFile("rank.txt");

		try {
			List<String> bData = FileLoad("member.txt");
			MemberDAO.FileToData(bData);
			List<String> mData = FileLoad("rank.txt");
			RankDAO.FileToData(mData);
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	public void AutoSave() {
		try {
			FileSave("rank.txt", RankDAO.DataToFile());
			FileSave("member.txt", MemberDAO.DataToFile());
			System.out.println("저장완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 이걸로 파일 전체 불러올 수 있음
	private List<String> FileLoad(String txtName) throws IOException {
		return Files.readAllLines(Paths.get(txtPath + txtName));
	}
	// 한줄 저장은 좋은 것인가?
	public void FileSave(String txtName, String data) throws IOException {
		Files.writeString(Paths.get(txtPath + txtName), data, charSet);
	}
}
