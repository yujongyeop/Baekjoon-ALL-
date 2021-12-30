package Solved_Problem;

/*
 * 시작 시간: 21.12.30 11:10
 * 종료 시간: 21.12.30.11:40
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_21736 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visit;
	static int ans = 0;
	static int N, M;

	static void DFS(int x, int y) {
		if (visit[x][y] || map[x][y] == 'X')// 이미 방문했을 때 혹은 벽이랑 만났을 때
			return;
		visit[x][y] = true;
		char c = map[x][y];
		if (c == 'P')
			ans++;
		for (int i = 0; i < 4; i++) {//상하좌우 탐색
			if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M)// 0<=x+dx,y+dy<=N-1 설정
				DFS(x + dx[i], y + dy[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new char[N][M];
		visit = new boolean[N][M];
		int my_x = 0, my_y = 0;// 도연이의 위치 변수

		for (int i = 0; i < N; i++) {// 지도 저장
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = input.charAt(j);
				if (c == 'I') {// 도연이의 위치 저장
					my_x = i;
					my_y = j;
					map[i][j] = 'O';
				} else {// 도연이의 위치가 아닌 나머지
					map[i][j] = c;
				}
			}
		}

		DFS(my_x, my_y);// 도연이의 위치부터 시작

		if (ans != 0)// ans가 0보다 크면 ans를 아니면 TT를 출력
			bw.write(ans + "");
		else
			bw.write("TT");
		bw.flush();
		bw.close();
		br.close();
	}

}
