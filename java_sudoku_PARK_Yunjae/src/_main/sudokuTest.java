package _main;

import java.util.Random;

public class sudokuTest {
	public static void main(String[] args) {
//		int[][] map = new int[9][9];
		Random rd = new Random();

		// 00 01 02 03 04 05 06 07 08
		// 10 11 12 13 14 15 16 17 18
		// 20 21 22 23 24 25 26 27 28

		// 30 31 32 33 34 35 36 37 38
		// 40 41 42 43 44 45 46 47 48
		// 50 51 52 53 54 55 56 57 58

		// 60 61 62 63 64 65 66 67 68
		// 70 71 72 73 74 75 76 77 78
		// 80 81 82 83 84 85 86 87 88

		// 블럭당 3*3으로 돌고 그걸 9번 반복한다
//		while (true) {
//			int n = 0;
//			int m = 0;
//			for (int i = 0; i < 9; i += 1) {
//				// 3번째 까지 하면 y 값을 늘리고 x 값을 초기화 한다
//				if (m == 9) {
//					m = 0;
//					n += 3;
//				}
//
//				int num = 1;
//				// 순서대로 넣기
//				for (int y = n; y < n + 3; y += 1) {
//					for (int x = m; x < m + 3; x += 1) {
//						map[y][x] = num++;
//					}
//				}
//				// 셔플
//				for (int k = 0; k < 100; k += 1) {
//					int a = rd.nextInt(3) + n;
//					int b = rd.nextInt(3) + m;
//					int num2 = map[n][m];
//					map[n][m] = map[a][b];
//					map[a][b] = num2;
//				}
//				m += 3;
//			}
//
//			// 규칙 검사 - 각각 소규모 3*3 블럭 안에서 1~9를 굴렸기 때문에
//			// 가로 세로만 검사하자
//			// 1-9의 합은 45 각각의 합이 전부 45 라면 되지 않을까
//			int sum = 44;
//			int numGaro = 0;
//			int numSero = 0;
//			int answer = 0;
//			for (int i = 0; i < 9; i += 1) {
//				for (int k = 0; k < 9; k += 1) {
//					numGaro += map[i][k];
//					numSero += map[k][i];
//				}
//				System.out.println(numGaro);
//				System.out.println(numSero);
//				if (numGaro == sum && numSero == sum) {
//					answer += 1;
//				}else {
//					break;
//				}
//				numGaro = 0;
//				numSero = 0;
//			}
//			// 가로 세로 전부 45가 나오면 멈춰본다
//			if (answer == 9) {
//				break;
//			}
//			for (int i = 0; i < 9; i += 1) {
//				for (int k = 0; k < 9; k += 1) {
//					System.out.print(map[i][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//
//		
		// 전제가 잘못 되었다 숫자가 겹치지 않는 규칙을 만든 후 거기다 랜덤 숫자를 넣어보다
		int[] num = new int[9];
		// 숫자 순서대로 넣고
		for(int i=0 ; i<9 ; i+=1) {
			num[i] = i+1;
		}
		// 셔플
		for(int i=0 ; i < 100 ; i+=1) {
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
		
		int[][] map = { {a6 ,a4 ,a7 ,a1 ,a8 ,a2 ,a9 ,a5 ,a3 },
						{a1 ,a8 ,a2 ,a9 ,a5 ,a3 ,a6 ,a4 ,a7 },
						{a9 ,a5 ,a3 ,a6 ,a4 ,a7 ,a1 ,a8 ,a2}, 
						{a4 ,a7 ,a6 ,a8 ,a2 ,a1 ,a5 ,a3 ,a9 },
						{a8 ,a2 ,a1 ,a5 ,a3 ,a9 ,a4 ,a7 ,a6 },
						{a5 ,a3 ,a9 ,a4 ,a7 ,a6 ,a8 ,a2 ,a1 },
						{a2 ,a1 ,a8 ,a3 ,a9 ,a5 ,a7 ,a6 ,a4 },
						{a3 ,a9 ,a5 ,a7 ,a6 ,a4 ,a2 ,a1 ,a8 },
						{a7 ,a6 ,a4 ,a2 ,a1 ,a8 ,a3 ,a9 ,a5 }};
				
		for(int i=0 ; i<9 ; i+=1) {
			for(int k=0 ; k<9 ; k+=1) {
				System.out.print(map[i][k] +" ");
			}
			System.out.println();
		}
	}
}
