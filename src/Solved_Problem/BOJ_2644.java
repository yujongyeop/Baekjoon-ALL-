package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2644 {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int ans = 0;

	static void DFS(int now, int end, int num) {// DFS가 깊어질수록 num(촌수)도 높아짐
		if (visit[now])
			return;
		if (now == end)// N1과 N2가 만났을 때
			ans = num;
		visit[now] = true;
		for (int i = 0; i < list[now].size(); i++) {
			DFS(list[now].get(i), end, num + 1);// now의 자식을 start로 하고, num(촌수)를 1 더함
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();
		visit = new boolean[N + 1];

		String[] input = br.readLine().split(" ");
		int N1 = Integer.parseInt(input[0]);// N1, N2는 촌수를 계산할려고 하는 두 사람의 번호이다.
		int N2 = Integer.parseInt(input[1]);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);// 정점1
			int y = Integer.parseInt(input[1]);// 정점2
			list[x].add(y);// 간선에 반향성이 없어 두 list에 모두 값을 넣어줌
			list[y].add(x);
		}
		for (int i = 1; i < N + 1; i++)
			Collections.sort(list[i]);

		DFS(N1, N2, 0);// 탐색을 N1부터 시작

		if (ans != 0)// N1과 N2가 한 트리에 있는 경우
			bw.write(ans + "");
		else
			bw.write("-1");
		bw.flush();
		bw.close();
		br.close();
	}

}