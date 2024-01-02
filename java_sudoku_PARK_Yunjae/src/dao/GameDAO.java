package dao;

import java.util.Random;

import javax.swing.JLabel;

public class GameDAO {
	private static GameDAO instance = new GameDAO();
	private static int[][] answer = new int[9][9];
	private static int[][] sudokuMap = new int[9][9];
	private static int[][] problem;
	private Random rd = new Random();

	public static GameDAO getInstance() {
		return instance;
	}

	public static int[][] getAnswer() {
		return answer;
	}

	public static int[][] getProblem() {
		return problem;
	}

	// 스도쿠 맵을 만들어보자
	// 1. 같은 행 또는 열에 같은 숫자가 두번 이상 나오면 안된다
	// 2. 스도쿠 배열은 9등분(3*3 크기의 부분 배열 9개)했을때 같은 영역 안에 숫자가 겹치면 안된다
	// 인터넷 뒤져서 보고싶다. 하지만 내것으로도 만들고 싶다
	public void AnswerMap() {
		int[] num = new int[9];
		// 숫자 순서대로 넣고
		for (int i = 0; i < 9; i += 1) {
			num[i] = i + 1;
		}
		// 셔플
		for (int i = 0; i < 100; i += 1) {
			int a = rd.nextInt(9);
			int num2 = num[a];
			num[a] = num[0];
			num[0] = num2;
		}
		// 셔플한 숫자를 순서대로 넣고
		int a1 = num[0];
		int a2 = num[1];
		int a3 = num[2];
		int a4 = num[3];
		int a5 = num[4];
		int a6 = num[5];
		int a7 = num[6];
		int a8 = num[7];
		int a9 = num[8];

		int[][] map = { { a6, a4, a7, a1, a8, a2, a9, a5, a3 }, { a1, a8, a2, a9, a5, a3, a6, a4, a7 },
				{ a9, a5, a3, a6, a4, a7, a1, a8, a2 }, { a4, a7, a6, a8, a2, a1, a5, a3, a9 },
				{ a8, a2, a1, a5, a3, a9, a4, a7, a6 }, { a5, a3, a9, a4, a7, a6, a8, a2, a1 },
				{ a2, a1, a8, a3, a9, a5, a7, a6, a4 }, { a3, a9, a5, a7, a6, a4, a2, a1, a8 },
				{ a7, a6, a4, a2, a1, a8, a3, a9, a5 } };
		problem = map;

		// 일단 복사
		for (int i = 0; i < 9; i += 1) {
			for (int k = 0; k < 9; k += 1) {
				answer[i][k] = problem[i][k];
				System.out.print(answer[i][k] + " ");
			}
			System.out.println();
		}
		
	}

	// 난이도를 입력하면 거기에 맞는 문제 출시
	public void LevelMap(int level) {
		for (int i = 0; i < 30 + (level * 5); i += 1) {
			int x = rd.nextInt(9);
			int y = rd.nextInt(9);

			if (answer[y][x] != 0) {
				answer[y][x] = 0;
			} else {
				i--;
			}
		}

	}

	// 맵 이식
	public void SelectMap(JLabel[][] map) {
		for (int y = 0; y < 9; y += 1) {
			for (int x = 0; x < 9; x += 1) {
				if (answer[y][x] != 0) {
					map[y][x].setText(answer[y][x] + "");
					sudokuMap[y][x] = answer[y][x];
				}else {
					map[y][x].setText("");
					sudokuMap[y][x] = 0;
				}
			}
		}
	}
	
	// 게임 승리
	public boolean SudokuWin() {
		for(int i=0 ; i<9 ; i+=1) {
			for(int k=0 ; k<9 ; k+=1) {
				if(answer[i][k] != problem[i][k]) {
					return false;
				}
			}
		}
		return true;
	}
	
	// 게임 시작시 있던 값인가 
	public boolean CannotChange(String xy) {
		String[] info = xy.split("/");
		int y = Integer.parseInt(info[0]);
		int x = Integer.parseInt(info[1]);
		
		if(sudokuMap[y][x] != 0) {
			return false;
		}
		return true;
	}
	
	// 정답인가
	public boolean answerNum(String xy, int num) {
		String[] info = xy.split("/");
		int y = Integer.parseInt(info[0]);
		int x = Integer.parseInt(info[1]);
		answer[y][x] = num;
		if(problem[y][x] != num) {
			return false;
		}
		return true;
	}
}
