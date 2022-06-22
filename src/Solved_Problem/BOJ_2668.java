package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2668 {
	static int N, max_Depth;
	static ArrayList<Integer> list = new ArrayList<>();;
	static boolean[] visit;
	static int[] arr;

	static void DFS(int start, int target) {
		if (!visit[arr[start]]) {
			visit[arr[start]] = true;
			DFS(arr[start], target);
			visit[arr[start]] = false;
		}
		if (arr[start] == target)// start와 target이 같아졌을 때(순회가 있을)
			list.add(target);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visit = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++)// 표 입력
			arr[i] = Integer.parseInt(br.readLine());

		for (int i = 1; i < N + 1; i++) {// 1~N까지 DFS반복
			visit[i] = true;
			DFS(i, i);
			visit[i] = false;
		}

		Collections.sort(list);

		sb.append(list.size() + "\n");
		for (int M : list)
			sb.append(M + "\n");
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
