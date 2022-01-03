package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1303 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int num_Soldier;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N,M
		M = Integer.parseInt(input[1]);

		map = new int[M][N];// 배열 초기화
		visit = new boolean[M][N];

		for (int i = 0; i < M; i++) {// 아군, 적군 좌표 입력
			String soldier = br.readLine();
			for (int j = 0; j < N; j++) {
				int num = soldier.charAt(j) == 'W' ? 0 : 1;// 아군이면 0, 적군이면 1로 저장
				map[i][j] = num;
			}
		}

		int ans_W = 0, ans_B = 0;// 아군과 적군 병사 위력
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {// 방문하지 않았을 때
					num_Soldier = 0;
					DFS(i, j, map[i][j]);
					if (map[i][j] == 0)// 아군 일때
						ans_W += (int) Math.pow(num_Soldier, 2);
					else// 적군 일때
						ans_B += (int) Math.pow(num_Soldier, 2);
				}
			}
		}

		bw.write(ans_W + " " + ans_B);
		bw.flush();
		bw.close();
		br.close();
	}

	static void DFS(int x, int y, int who) {
		visit[x][y] = true;
		num_Soldier++;
		for (int i = 0; i < 4; i++) {// 상하좌우 탐색
			int tmp_x = x + dx[i];
			int tmp_y = y + dy[i];
			if (tmp_x >= 0 && tmp_x < M && tmp_y >= 0 && tmp_y < N) {// 배열 범위 밖으로 벗어나지 못하게
				if (!visit[tmp_x][tmp_y] && map[tmp_x][tmp_y] == who)// 방문하지 않았으며 who와 같을 때
					DFS(tmp_x, tmp_y, who);
			}
		}
	}

}
