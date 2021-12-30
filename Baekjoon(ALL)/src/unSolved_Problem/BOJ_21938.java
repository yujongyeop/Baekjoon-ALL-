package unSolved_Problem;

/*
 * 시작 시간: 21.12.30 14:20
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_21938 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, T;
	static double[][] display;
	static boolean[][] visit;

	static void DFS(int x, int y) {
		if (visit[x][y] || display[x][y] == 0)
			return;
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M)// 0<=x+dx,y+dy<=N-1 설정
				DFS(x + dx[i], y + dy[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 세로
		int M = Integer.parseInt(st.nextToken());// 가로
		display = new double[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {// 화면값 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				double sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())
						+ Integer.parseInt(st.nextToken());
				display[i][j] = sum / 3;
			}
		}
		T = Integer.parseInt(br.readLine());// 경계값

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (display[i][j] < T)// display[i][j]가 T보다 작을 경우
					display[i][j] = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (display[i][j] > 0 && !visit[i][j]) {
					DFS(i, j);
					ans++;
				}
			}
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
