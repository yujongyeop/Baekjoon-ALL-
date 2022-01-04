package unSolved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11123 {
	static int[] dx = { 0, 0, -1, 1 };// 상,하,좌,우
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][] visit;
	static int N, M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T != 0) {
			user_input();
			T--;
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static void user_input() throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == '#')
					map[i][j] = 1;
				else
					visit[i][j] = true;
			}
		}
		case_Ans();
	}

	static void case_Ans() throws IOException {
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {
					DFS(i, j);
					ans++;
				}
			}
		}
		bw.write(ans + "\n");
	}

	static void DFS(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {// 상하좌우 탐색
			int tmp_x = x + dx[i];
			int tmp_y = y + dy[i];
			if (tmp_x >= 0 && tmp_x < N && tmp_y >= 0 && tmp_y < M) {// 배열 범위 밖으로 벗어나지 못하게
				if (!visit[tmp_x][tmp_y])// 방문하지 않았을 때
					DFS(tmp_x, tmp_y);
			}
		}
	}

}
