package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1012 {
	static int M, N, K;
	static int[][] table;
	static boolean[][] visit;
	static int[] dx = { 0, 0, -1, 1 };// 상하좌우 이동 시 사용
	static int[] dy = { 1, -1, 0, 0 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void make_Table() throws IOException {// 사용자 입력값 받는 함수
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N(X값)
		M = Integer.parseInt(input[1]);// M(Y값)
		K = Integer.parseInt(input[2]);// K(배추개수)
		table = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			input = br.readLine().split(" ");
			table[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;// (x,y)를 1로 설정;
		}

	}

	static int DFS(int x, int y) {
		if (visit[x][y] || table[x][y] == 0)//방문했거나, (x,y)가 0인 경우
			return 0;
		int count = 1;
		visit[x][y] = true;// (x,y)방문 처리
		for (int i = 0; i < 4; i++) {// 상하좌우 탐색
			if (x + dx[i] < 0 || x + dx[i] >= N || y + dy[i] < 0 || y + dy[i] >= M)
				continue;
			count += DFS(x + dx[i], y + dy[i]);// 상하좌우 이동 가능 시 DFS호줄
		}
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop_Num = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < loop_Num; i++) {
			ans = 0;
			make_Table();
			for (int j = 0; j < N; j++) {// (0,0)부터 (N-1,M-1)까지 모두 탐색
				for (int k = 0; k < M; k++) {
					if (DFS(j, k) != 0)// (j,k)가 한개이상의 배추와 연결되었을 때
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