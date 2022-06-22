package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {
	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 0, 0, -1, 1 };// 상하좌우 배열
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		BFS(0, 0);
		bw.write(map[N - 1][M - 1] + "");
		bw.flush();
		bw.close();
		br.close();

	}

	static void BFS(int pos_x, int pos_y) {
		visit[pos_x][pos_y] = true;
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(pos_x, pos_y));
		while (!que.isEmpty()) {
			int x = que.peek().x;
			int y = que.peek().y;
			que.poll();
			for (int i = 0; i < 4; i++) {// 상하좌우 탐색
				int tmp_x = x + dx[i];
				int tmp_y = y + dy[i];
				if (tmp_x >= 0 && tmp_x < N && tmp_y >= 0 && tmp_y < M) {
					if (!visit[tmp_x][tmp_y] && map[tmp_x][tmp_y] == 1) {
						map[tmp_x][tmp_y] = map[x][y] + 1;
						visit[tmp_x][tmp_y] = true;
						que.add(new Node(tmp_x, tmp_y));
					}
				}
			}
		}
	}

}
