package Solved_Problem;

/*
 * DFS를 (15,15)부터 시작하는 이유는 한방향으로 최대로 이동할 수 있는 횟수는 14칸이기 때문에 중앙에서 시작하면 범위밖으로 벗어나지않음
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1405 {
	static int[] dx = { 0, 0, -1, 1 };// 동서남북 배열
	static int[] dy = { 1, -1, 0, 0 };
	static double[] percentage = new double[4];
	static int N;
	static boolean[][] visit = new boolean[30][30];
	static int[][] map = new int[30][30];
	static double ans = 0.0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// 이동횟수
		for (int i = 0; i < 4; i++)// 동서남북 확률 입력
			percentage[i] = Double.parseDouble(input[i + 1]) * 0.01;
		DFS(15, 15, 1.0);// (15,15)부터 시작 확률은 100%로 시작
		System.out.printf("%.10f", ans);// 오차범위 설정
	}

	static void DFS(int x, int y, double per) {
		if (N == 0) {// 이동할 수 없으면
			ans += per;// 해당 경로로 이동할 확률을 더 해줌
			return;
		}
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {// 동서남북 탐색
			int tmp_x = x + dx[i];
			int tmp_y = y + dy[i];
			if (!visit[tmp_x][tmp_y]) {// (tmp_x, tmp_y)에 방문하지 않았을 때
				N--;// 이동횟수 1회 감소
				DFS(tmp_x, tmp_y, per * percentage[i]);// per에 해당 방향으로 갈 확률을 곱해준다.
				N++;// 이동횟수 1회 증가
				visit[tmp_x][tmp_y] = false;// 방문하지 않은 것으로 처리
			}
		}
	}

}
