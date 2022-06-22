package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 처음 풀이를 시작했을때는 DFS를 통해 풀었으나 계속 시간초과가 일어나서 BFS로 변경하여서 풀었음
 */
public class BOJ_1325 {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int[] ans;
	static int N, M;
	static int count = 0;

	static void BFS(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);// start를 큐에 넣어줌
		visit[start] = true;// 방문 처리
		while (!que.isEmpty()) {// 큐가 비어있을 때까지 반복
			int front = que.poll();// 가장 위에 원소를 꺼냄
			for (int v : list[front])// front와 연결된 정점에 대해 탐색
				if (!visit[v]) {// v에 방문하지 않았을 때
					visit[v] = true;// 방문처리함
					que.add(v);// 큐에 넣어줌
					ans[v]++;// v번째 값을 더해줌
				}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N,M
		M = Integer.parseInt(input[1]);

		list = new ArrayList[N + 1];// 초기화
		ans = new int[N + 1];

		for (int i = 0; i < N + 1; i++)// list 초기화
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {// 컴퓨터 신뢰관계를 입력 받음
			input = br.readLine().split(" ");
			list[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
		}

		for (int i = 1; i < N + 1; i++) {// 1~N까지 BFS실행
			visit = new boolean[N + 1];// 방문 배열을 계속 초기화 해줌
			BFS(i);
		}

		int max_Connect = 0;// ans배열에 있는 최대값 저장
		for (int M : ans)
			max_Connect = max_Connect < M ? M : max_Connect;

		for (int i = 1; i < N + 1; i++) {
			if (ans[i] == max_Connect)// 최대값과 같다면 출력
				sb.append(i + " ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
