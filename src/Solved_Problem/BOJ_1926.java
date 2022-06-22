package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1926 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] table;
	static boolean[][] visit;
	static int N, M;
	static int max_Size = 0, size;

	static void DFS(int x, int y) {
		visit[x][y] = true;
		size++;
		for (int i = 0; i < 4; i++) {// 상하좌우 탐색
			int tmp_x = x + dx[i];
			int tmp_y = y + dy[i];
			if (tmp_x >= 0 && tmp_x < N && tmp_y >= 0 && tmp_y < M) {// 0<=x+dx,y+dy<=N-1 설정
				if (!visit[tmp_x][tmp_y])// 방문하지 않았으며 비의 양과 같거나 높은 지역일 때
					DFS(tmp_x, tmp_y);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N,M
		M = Integer.parseInt(input[1]);

		table = new int[N][M];// 초기화
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {// 도화지 정보 입력
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				table[i][j] = Integer.parseInt(input[j]);
				if (table[i][j] == 0)// 색칠되어 있지 않은 부분은 모두 방문 처리
					visit[i][j] = true;
			}
		}

		int pic_Num = 0;
		for (int i = 0; i < N; i++) {// (0,0)~(N-1,M-1)까지 모두 DFS를 돌림
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {// 방문하지 않은 거에 대해서만 처리
					size = 0;
					pic_Num++;// 그림개수 늘려줌
					DFS(i, j);
					max_Size = Math.max(max_Size, size);// 가장 넓은 그림 넓이 업데이트
				}
			}
		}
		bw.write(pic_Num + "\n" + max_Size);
		bw.flush();
		bw.close();
		br.close();
	}

}
