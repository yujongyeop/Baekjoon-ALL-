package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_4963 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] table;
	static boolean[][] visit;
	static int W, H;
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };// 상,하,좌,우,↖,↗,↙,↘
	static int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };

	static void make_Table() throws IOException {// 사용자 입력값 받는 함수
		table = new int[H][W];
		visit = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < W; j++) {
				table[i][j] = Integer.parseInt(input[j]);
			}
		}
	}

	static int DFS(int x, int y) {
		if (table[x][y] == 0 || visit[x][y])
			return 0;
		int count = 1;
		visit[x][y] = true;
		for (int i = 0; i < 8; i++) {
			if (x + dx[i] < 0 || x + dx[i] >= H || y + dy[i] < 0 || y + dy[i] >= W)//상하좌우 대각선이 table 배열 밖으로 갈 경우 처리
				continue;
			count += DFS(x + dx[i], y + dy[i]);//상하좌우대각선에 대한 DFS처리
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String[] input = br.readLine().split(" ");
			W = Integer.parseInt(input[0]);// 너비
			H = Integer.parseInt(input[1]);// 높이
			if (W == 0 && H == 0)// 0,0 입력 시 반복문 종료
				break;
			else
				make_Table();// 사용자값 입력 함수 호출
			int ans = 0;
			for (int i = 0; i < H; i++) {// (0,0)부터 (H-1,W-1)까지 탐색
				for (int j = 0; j < W; j++) {
					if (DFS(i, j) != 0)// (i,j)의 리턴값이 0이 아닐때마다 ans변수 1씩 증가
						ans++;
				}
			}
			bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
