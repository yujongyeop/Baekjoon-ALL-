package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2606 {
	static int ans = 0;
	static ArrayList<Integer>[] list;
	static boolean[] visit;

	static void DFS(int start) {// DFS
		visit[start] = true;
		ans++;
		for (int i = 0; i < list[start].size(); i++) {
			int x = list[start].get(i);
			if (!visit[x])
				DFS(x);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		int N = Integer.parseInt(input);// N
		input = br.readLine();
		int M = Integer.parseInt(input);// M
		int start = 1;// 시작점
		list = new ArrayList[N + 1];// 노드 연결 저장
		visit = new boolean[N + 1];// 방문 확인 배열

		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();// ArrayList 초기화
		for (int i = 0; i < M; i++) {
			String[] user_input = br.readLine().split(" ");
			int x = Integer.parseInt(user_input[0]);// 정점1
			int y = Integer.parseInt(user_input[1]);// 정점2
			list[x].add(y);// 간선에 반향성이 없어 두 list에 모두 값을 넣어줌
			list[y].add(x);
		}
		for (int i = 1; i < N + 1; i++)
			Collections.sort(list[i]);// 정렬(정렬되지 않으면 가장 낮은 값부터 탐색을 하지 못하는 경우가 생김)
		DFS(start);
		bw.write(ans-1 + "");// ans에서 1을 빼는 이유는 최초로 감염된 컴퓨터는 빼줘야하기 때문
		bw.flush();
		bw.close();
		br.close();
	}

}