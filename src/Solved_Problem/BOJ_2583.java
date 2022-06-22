package Solved_Problem;

/*
 * 시작 시간: 21.12.31 10:35
 * 종료 시간: 21.12.31 11:13
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2583 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, K;
	static int[][] arr, square;
	static boolean[][] visit;
	static int count = 0;
	static ArrayList<Integer> list = new ArrayList<>();

	static void DFS(int x, int y) {
		count++;// 새로 방문할 때마다 count 값 증가(넓이 구하기)
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {// 상하좌우 탐색
			int tmp_x = x + dx[i];
			int tmp_y = y + dy[i];
			if (tmp_x >= 0 && tmp_x < N && tmp_y >= 0 && tmp_y < M) {// (tmp_x,tmp_y)가 범위를 벗어나지 않을 때
				if (!visit[tmp_x][tmp_y]) // 방문하지 않았을 때
					DFS(tmp_x, tmp_y);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");// N,M,K 입력
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		arr = new int[N][M];// 배열 초기화
		visit = new boolean[N][M];
		square = new int[K][4];

		for (int i = 0; i < K; i++) {// 사각형 위치 입력
			input = br.readLine().split(" ");
			for (int j = 0; j < 4; j++)
				square[i][j] = Integer.parseInt(input[j]);
		}

		for (int i = 0; i < K; i++) {
			for (int j = square[i][1]; j < square[i][3]; j++) {
				for (int k = square[i][0]; k < square[i][2]; k++)
					visit[j][k] = true;
			}
		}

		for (int i = 0; i < N; i++) {// (0,0)부터 (N-1,M-1)까지 탐색
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {// 방문하지 않았을 때 실행
					count = 0;// 넓이 초기화
					DFS(i, j);
					list.add(count);// 넓이를 list에 추가 해줌
				}
			}
		}

		Collections.sort(list);// 오름차순 정렬

		sb.append(list.size() + "\n");// 출력 부분
		for (int M : list)
			sb.append(M + " ");
		bw.write(String.valueOf(sb));
		bw.flush();
		br.close();
		bw.close();

	}

}