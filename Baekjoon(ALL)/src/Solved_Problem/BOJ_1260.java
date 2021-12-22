package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260 {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	static void DFS(int start) {// 깊이 우선 탐색
		visit[start] = true;
		sb.append(start + " ");
		for (int i = 0; i < list[start].size(); i++) {// start 안에 있는 값중 작은 값부터 탐색(만약 방문하지 않았다면 그 값부터 처리)
			int x = list[start].get(i);// start에 있는 i번째 값
			if (!visit[x])// i번째 값이 방문하지 않았으면 방문
				DFS(x);
		}
	}

	static void BFS(int start) {// 너비 우선 탐색
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);// start를 큐에 넣음
		visit[start] = true;
		while (!que.isEmpty()) {// 큐가 비여있을 때까지 반복
			int x = que.poll();// 가장 먼저 들어온 값을 뺌
			sb.append(x + " ");
			for (int i = 0; i < list[x].size(); i++) {// x가 가지고 있는 간선을 모두 탐색
				int y = list[x].get(i);
				if (!visit[y]) {
					que.offer(y);
					visit[y] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);// N
		int M = Integer.parseInt(input[1]);// M
		int start = Integer.parseInt(input[2]);// 시작점
		list = new ArrayList[N + 1];// 노드 연결 저장

		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();// ArrayList 초기화
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);// 정점1
			int y = Integer.parseInt(input[1]);// 정점2
			list[x].add(y);// 간선에 반향성이 없어 두 list에 모두 값을 넣어줌
			list[y].add(x);
		}
		for (int i = 1; i < N + 1; i++)
			Collections.sort(list[i]);// 정렬(정렬되지 않으면 가장 낮은 값부터 탐색을 하지 못하는 경우가 생김)

		visit = new boolean[N + 1];// visit 초기화(최초)
		DFS(start);
		sb.append("\n");
		visit = new boolean[N + 1];// visit 초기화(DFS연산 이후에 원래 상태로 초기화)
		BFS(start);
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}
}
