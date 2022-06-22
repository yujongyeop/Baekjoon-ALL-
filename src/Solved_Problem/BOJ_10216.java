package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10216 {
	static int N;
	static int[][] map;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			input();
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (!visit[j]) {
					DFS(j);
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void input() throws IOException {// 사용자 값 입력
		N = Integer.parseInt(br.readLine());// 초기화
		map = new int[N][3];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			map[i][0] = Integer.parseInt(str[0]);// X값
			map[i][1] = Integer.parseInt(str[1]);// Y값
			map[i][2] = Integer.parseInt(str[2]);// 동신영역
		}
	}

	static void DFS(int current) {// current와 나머지 위치에 대한 연산
		visit[current] = true;
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {// i를 방문하지 않았을 때
				int dx = map[current][0] - map[i][0]; // current와 j의 X값 차이
				int dy = map[current][1] - map[i][1]; // current와 j의 Y값 차이
				int dr = map[current][2] + map[i][2]; // current와 j의 통신 가능 거리 합
				// current와 j 사이의 거리(sqrt(dx^2+dy^2))이 dr보다 작거나 같으면 통신이 가능함(피타고라스의 정리)
				if ((dx * dx) + (dy * dy) <= (dr * dr))// 범위내에 있을 때
					DFS(i);
			}
		}
	}

}
