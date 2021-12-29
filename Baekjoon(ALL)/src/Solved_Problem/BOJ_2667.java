package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {
	static int[] dx = { 0, 0, -1, 1 };// 상하좌우 배열
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	static int count = 0;

	static void DFS(int x, int y) {
		if (visit[x][y])
			return;
		visit[x][y] = true;
		count++;//처음 방문할 때마다 수를 증가 시킴
		for (int i = 0; i < 4; i++) {// 상하좌우 탐색
			if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N)// 0<=x+dx,y+dy<=N-1 설정
				DFS(x + dx[i], y + dy[i]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {// 사용자값 입력 받는 함수
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 0)// 입력이 0일 경우 방문처리
					visit[i][j] = true;
			}
		}

		for (int i = 0; i < N; i++) {// (0,0)부터 (N-1,N-1)까지 탐색
			for (int j = 0; j < N; j++) {
				count = 0;// 초기화
				DFS(i, j);
				if (count > 0)// count가 0보다 큰 경우 list에 추가
					list.add(count);
			}
		}
		Collections.sort(list);// 오름차순으로 정렬
		sb.append(list.size() + "\n");// list의 개수 출력
		for (int m : list)// list의 원소들 출력
			sb.append(m + "\n");
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}

}
