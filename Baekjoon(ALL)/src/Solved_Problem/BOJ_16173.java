package Solved_Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16173 {
	static int N;
	static int[][] map;

	static void DFS(int x, int y) {
		if (x >= N || y >= N)// x,y가 범위를 벗어날 경우
			return;
		int val = map[x][y];// 움직일 수 있는 칸수
		if (val == 0)// val이 0이면 무한 루프(시간초과)
			return;
		else if (val == -1) {// 찾았을때
			System.out.println("HaruHaru");
			System.exit(0);
		} else {
			DFS(x + val, y);// X값을 증가시킴
			DFS(x, y + val);// Y값을 증가시킴
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {// 사용자 값을 map에 저장
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		br.close();
		DFS(0, 0);
		System.out.println("Hing");// 값을 찾을 수 없을 때
	}

}