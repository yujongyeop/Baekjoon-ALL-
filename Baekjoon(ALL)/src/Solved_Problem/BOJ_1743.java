package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1743 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, K;
	static int[][] map;
	static boolean[][] visit;
	static int trash = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N, M, K
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		map = new int[N + 1][M + 1];// 배열 초기화
		visit = new boolean[N + 1][M + 1];

		for (int i = 0; i < K; i++) {// 음식물 좌표 입력 및 배열에 반영(음식물이 있는 위치는 1로 저장)
			input = br.readLine().split(" ");
			map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
		}
		int ans = 0;
		for (int i = 0; i < N + 1; i++) {// (0,0)~(N,M)까지 DFS 실행
			for (int j = 0; j < M + 1; j++) {
				if (!visit[i][j] && map[i][j] != 0) {// 방문하지 않았으며 0이 아닌 경우 실행
					trash = 0;// 쓰레기양 0으로 초기화
					DFS(i, j);
					ans = Math.max(ans, trash);// 최대값 갱신
				}
			}
		}
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}

	static void DFS(int x, int y) {
		if (map[x][y] == 0 || visit[x][y])
			return;
		visit[x][y] = true;
		trash++;
		for (int i = 0; i < 4; i++) {// 상하좌우 탐색
			int tmp_x = x + dx[i];
			int tmp_y = y + dy[i];
			if (tmp_x >= 0 && tmp_x < N + 1 && tmp_y >= 0 && tmp_y < M + 1) {// 배열 범위 밖으로 벗어나지 못하게
				if (!visit[tmp_x][tmp_y] && map[tmp_x][tmp_y] != 0)// 방문하지 않았으며 0이 아닐때
					DFS(tmp_x, tmp_y);
			}
		}
	}

}
