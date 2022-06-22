package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_15900 {
	static int N, ans;
	static ArrayList<Integer>[] list;

	static void DFS(int node, int parent, int depth) {
		for (int i = 0; i < list[node].size(); i++) {
			if (list[node].get(i) != parent)// 부모 노드가 아닐 경우
				DFS(list[node].get(i), node, depth + 1);
		}
		if (list[node].size() == 1)// 리프노드 일 경우
			ans += depth;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());// N(트리의 개수)

		list = new ArrayList[N + 1];// 초기화
		ans = 0;// 모든 리프노드의 깊이의 합
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {// 트리 입력
			String[] input = br.readLine().split(" ");
			list[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
			list[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
		}

		DFS(1, 0, 0);// 루트노드의 깊이는 0
		bw.write((ans % 2) == 0 ? "No" : "Yes");// 모든 리프노드의 깊이 합이 짝수면 No 홀수면 Yes
		bw.flush();
		br.close();
		bw.close();
	}

}
