package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10026 {
	static int[] dx = { 0, 0, -1, 1 };// 상,하,좌,우
	static int[] dy = { 1, -1, 0, 0 };
	static int N;
	static int[][] map;
	static boolean[][] visit;

	static void DFS(int x, int y, int key) {
		visit[x][y] = true;
		if (map[x][y] == 1)// 녹색일 경우 빨간색으로 변경
			map[x][y] = 0;
		for (int i = 0; i < 4; i++) {// 상하좌우 탐색
			int tmp_x = x + dx[i];
			int tmp_y = y + dy[i];
			if (tmp_x >= 0 && tmp_x < N && tmp_y >= 0 && tmp_y < N) {// 배열 범위 밖으로 벗어나지 못하게
				if (!visit[tmp_x][tmp_y] && map[tmp_x][tmp_y] == key)// 방문하지 않았을 때
					DFS(tmp_x, tmp_y, key);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = input.charAt(j);
				if (c == 'R')
					map[i][j] = 0;
				else if (c == 'G')
					map[i][j] = 1;
				else
					map[i][j] = 2;
			}
		}
		int normal = 0;// 정상인 일때
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					DFS(i, j, map[i][j]);// DFS를 수행하면서 G를 R로 변경한다.(색맹처리를 위해)
					normal++;
				}
			}
		}

		int color_Blind = 0;// 색맹일때
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					DFS(i, j, map[i][j]);
					color_Blind++;
				}
			}
		}
		bw.write(normal + " " + color_Blind);
		bw.flush();
		bw.close();
		br.close();
	}

}
