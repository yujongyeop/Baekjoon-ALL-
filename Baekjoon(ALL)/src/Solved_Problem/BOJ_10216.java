package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10216 {
	static int N;
	static int[][] map;
	static int[] parent;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			input();
			sb.append(calc() + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void input() throws IOException {// 사용자 값 입력
		N = Integer.parseInt(br.readLine());// 초기화
		map = new int[N][3];
		parent = new int[N];
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			map[i][0] = Integer.parseInt(str[0]);// X값
			map[i][1] = Integer.parseInt(str[1]);// Y값
			map[i][2] = Integer.parseInt(str[2]);// 동신영역
			parent[i] = i;
		}
	}

	static int calc() {
		int cnt = N;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int dx = map[i][0] - map[j][0]; // i와 j의 X값 차이
				int dy = map[i][1] - map[j][1]; // i와 j의 Y값 차이
				int dr = map[i][2] + map[j][2]; // i와 j의 통신 가능 거리 합
				// i와 j 사이의 거리(sqrt(dx^2+dy^2))이 dr보다 작거나 같으면 통신이 가능함(피타고라스의 정리)
				if ((dx * dx) + (dy * dy) <= (dr * dr)) {
					if (find(i) != find(j)) {// i와 j의 부모가 같지 않으면 i의 부모를 j로 갱신
						merge(i, j);
						cnt--;// 두 통신탑이 서로 연결되어 있으므로 1 감소
					}
				}
			}
		}
		return cnt;
	}

	static void merge(int i, int j) {
		int x = find(i);
		int y = find(j);
		if (x == y)
			return;
		else
			parent[x] = y;

	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}

}
