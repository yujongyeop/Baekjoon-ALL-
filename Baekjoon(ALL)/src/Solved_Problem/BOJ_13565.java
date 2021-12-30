package Solved_Problem;
/*
 * 시작 시간: 21.12.29 9:55
 * 완료 시간: 21.12.29 10:30
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13565 {
	static int[] dx = { 0, 0, -1, 1 };// 상하좌우 배열
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static int[][] table;
	static boolean[][] visit;

	static void DFS(int x, int y) {
		if (visit[x][y] || table[x][y] == 1)// 이미 방문했거나, 검은색이면 종료
			return;
		if (x == 0) {// x가 0(바깥쪽)이면 끝에 도달한 경우임
			System.out.println("YES");
			System.exit(0);
		}
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M)// (x+dx,y+dy)가 배열 밖으로 벗어나지 않게 설정
				DFS(x + dx[i], y + dy[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N
		M = Integer.parseInt(input[1]);// M
		table = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {// 격자 입력
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				table[i][j] = str.charAt(j) - '0';
		}
		br.close();
		for (int i = 0; i < M; i++)// (N-1,0) 부터 (N-1,M-1)까지 탐색
			DFS(N - 1, i);

		System.out.println("NO");// 해당 문장이 실행될 경우는 DFS를 통해 바깥쪽 면부터 안쪽면까지 전류가 통하는 경우를 찾지 못했을 때 실행
	}

}