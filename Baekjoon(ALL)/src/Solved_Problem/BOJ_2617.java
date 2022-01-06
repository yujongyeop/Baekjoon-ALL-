package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_2617 {
	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N(정점 개수)
		M = Integer.parseInt(input[1]);// M(무게 관계 입력수,간선 개수)
		int half = (N + 1) / 2;// 정점 개수의 반

		arr = new int[N + 1][2];// 초기화
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {// 무게 관계 저장
			input = br.readLine().split(" ");
			list[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
		}

		for (int i = 1; i < N + 1; i++) {// 1~N까지 DFS반복
			visit = new boolean[N + 1];
			DFS(i, i);
		}
		int ans = 0;
		for (int i = 1; i < N + 1; i++) {
			// 자신보다 가벼운 정점의 개수가 반보다 많거나 자신보다 무거운 정점의 개수가 반보다 적으면 절대 중간이 될 수 없다.
			if (arr[i][0] >= half || arr[i][1] >= half)
				ans++;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

	static void DFS(int current, int start) {// start에 대한 깊이 우선 탐색
		visit[current] = true;
		for (int next : list[current]) {
			if (!visit[next]) {
				// 자신보다 가벼운 노드들이 호출되 때마다 arr[start]][0]을 1씩 증가시킴;
				arr[start][0]++;// 자신보다 가벼운 것
				arr[next][1]++;// 자신보다 무거운것
				DFS(next, start);
			}
		}
	}

}
