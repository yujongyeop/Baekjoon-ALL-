package Solved_Problem;
/*
 * 시작 시간: 21.12.31 9:30
 * 종료 시간: 21.12.31 10:12
 * 수정: line 29 불필요한 연산 삭제(21.12.31 10:51)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2468 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;
	static int[][] arr;
	static boolean[][] visit;
	static int max = 0, h_max = 0;

	static void DFS(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {// 상하좌우 탐색
			int tmp_x = x + dx[i];
			int tmp_y = y + dy[i];
			if (tmp_x >= 0 && tmp_x < N && tmp_y >= 0 && tmp_y < N) {// 0<=x+dx,y+dy<=N-1 설정
				if (!visit[tmp_x][tmp_y] && arr[tmp_x][tmp_y] >= h_max)// 방문하지 않았으며 비의 양과 같거나 높은 지역일 때
					DFS(tmp_x, tmp_y);
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				h_max = h_max < arr[i][j] ? arr[i][j] : h_max;// 입력값 중 가장 높은 수를 저장
			}
		}
		while (h_max != 0) {// 최대 비의 양이 0이 아닐때까지 반복
			int count = 0;// 안전구역의 개수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j] && arr[i][j] >= h_max) {// 방문하지 않았고 값이 최대 비의 양과 같거나 높으면 DFS 실행
						DFS(i, j);
						count++;// 안전구역의 개수 증가
					}
				}
			}
			ans = ans < count ? count : ans;// ans가 안전 구역의 개수 보다 작다면 값을 갱신
			for (int i = 0; i < N; i++)// visit배열을 모두 false 변경
				for (int j = 0; j < N; j++)
					visit[i][j] = false;
			h_max--;// 비의 양을 1씩 줄임
		}
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}

}
