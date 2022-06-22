package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_14716 {
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };// 상,하,좌,우,↖,↗,↙,↘
	static int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int N, M;
	static int[][] map;
	static boolean[][] visit;

	static void DFS(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 8; i++) {
			int tmp_x = x + dx[i];
			int tmp_y = y + dy[i];
			if (tmp_x >= 0 && tmp_x < N && tmp_y >= 0 && tmp_y < M)// x+dx,y+dy가 범위 내에 있을 때
				if (!visit[tmp_x][tmp_y])
					DFS(x + dx[i], y + dy[i]);// 상하좌우대각선에 대한 DFS처리
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N, M
		M = Integer.parseInt(input[1]);

		map = new int[N][M];// 초기화
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {// 현수막 정보 입력
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				visit[i][j] = map[i][j] == 0 ? true : false;// 글자가 아닌 부분은 방문 처리
			}
		}

		int ans = 0;// 글자 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {// 방문하지 않았을 때
					DFS(i, j);
					ans++;// 글자개수 1개 증가
				}
			}
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
