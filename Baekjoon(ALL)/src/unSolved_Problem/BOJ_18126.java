package unSolved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_18126 {
	static class node {
		int v;
		int len;

		node(int v, int len) {
			this.v = v;
			this.len = len;
		}
	}

	static long ans = 0;
	static ArrayList<node>[] list;
	static boolean[] visit;

	static void DFS(int start, long sum) {
		if (visit[start])
			return;
		ans = ans < sum ? sum : ans;
		visit[start] = true;
		for (int i = 0; i < list[start].size(); i++) {
			DFS(list[start].get(i).v, sum + list[start].get(i).len);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();
		for (int i = 1; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int len = Integer.parseInt(input[2]);
			list[A].add(new node(B, len));
			list[B].add(new node(A, len));
		}
		DFS(1, 0);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
