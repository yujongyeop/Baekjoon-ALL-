package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_11724 {
	static int N, M, ans = 0;
	static ArrayList<Integer>[] list;
	static boolean[] visit;

	static int DFS(int start) {
		if (visit[start])// 이미 방문했을때
			return 0;
		int count = 1;
		visit[start] = true;
		for (int i = 0; i < list[start].size(); i++) {//start와 연결된 노드 방문
			count+=DFS(list[start].get(i));
		}
		return count;// count(연결된 노드 개수) 리턴
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N
		M = Integer.parseInt(input[1]);// M
		list = new ArrayList[N + 1];// 노드 연결 저장
		visit = new boolean[N + 1];// 방문 확인 배열
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();// ArrayList 초기화
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);// 정점1
			int y = Integer.parseInt(input[1]);// 정점2
			list[x].add(y);// 간선에 반향성이 없어 두 list에 모두 값을 넣어줌
			list[y].add(x);
		}
		for (int i = 1; i <= N; i++) {// 시작점을 1~N까지 모두 반복
			if (DFS(i) != 0)
				ans++;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}

}
