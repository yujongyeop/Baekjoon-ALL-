package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_15270 {
	static int N, M, ans = 0;
	static ArrayList<Integer>[] list;
	static boolean[] visit;

	static void DFS(int x, int depth) {
		if (ans < depth)// depth가 ans보다 커질 때마다 ans 갱신
			ans = depth;
		if (x == N)
			return;
		if (!visit[x])// x를 방문하지 않았을 때
			for (int i = x + 1; i <= N; i++) {
				if (!visit[i] && list[x].contains(i)) {// i를 방문하지 않았고 x와 i가 연결되어 있을 때
					visit[x] = true;
					visit[i] = true;
					DFS(x + 1, depth + 2);// 2명 증가시키고 x+1에 대한 dfs 실행(짝을 찾은 경우)
					visit[x] = false;
					visit[i] = false;
				}
			}
		DFS(x + 1, depth);// 짝이 없는 경우
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
		for (int i = 1; i < N + 1; i++)
			Collections.sort(list[i]);// 정렬(정렬되지 않으면 가장 낮은 값부터 탐색을 하지 못하는 경우가 생김)
		for (int i = 1; i <= N; i++)// 시작 노드를 1부터 N까지 연산함
			DFS(i, 0);
		if (ans < N)// ans가 N보다 작은 경우는 1을 더 해줌(혼자 로봇 춤을 추는 1명 추가)
			bw.write(ans + 1 + "");
		else// 모두가 짝을 이루어 춤을 추는 경우
			bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}

}
