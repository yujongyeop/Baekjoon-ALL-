package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Node {// 연결된 간선과 두 노드간 거리를 저장
	int v, len;

	Node(int v, int len) {// 생성자
		this.v = v;
		this.len = len;
	}

}

public class BOJ_15971 {
	static int N, L, R;
	static ArrayList<Node>[] list;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// 방의 개수(노드)
		L = Integer.parseInt(input[1]);// 로봇1의 위치
		R = Integer.parseInt(input[2]);// 로봇2의 위치

		list = new ArrayList[N + 1];// 초기화
		visit = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {// 트리 입력
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);// 노드1
			int destiny = Integer.parseInt(input[1]);// 노드2
			int len = Integer.parseInt(input[2]);// 길이
			list[start].add(new Node(destiny, len));// list에 간선 정보를 넣어줌
			list[destiny].add(new Node(start, len));
		}
		br.close();
		DFS(L, 0, 0, R);// 로봇1이 로봇2를 만날때까 탐색
	}

	static void DFS(int current, int len, int max_Len, int destiny) throws IOException {
		visit[current] = true;// 방문 처리
		if (current == destiny) {// 로봇1과 로봇2가 만났을 경우
			bw.write(len - max_Len + "");// 지나온 경로의 총합 - 가장 긴 경로의 길이를 빼줌
			bw.flush();
			bw.close();
			System.exit(0);
		}
		for (Node next : list[current]) {
			if (!visit[next.v])// next를 방문하지 않았을 때
				// 지나온 경로(len)에 next의 len값을 더 해줌, 가장 긴 경로의 길이(max_Len)과 next의 len과 최대값을 갱신
				DFS(next.v, len + next.len, Math.max(max_Len, next.len), destiny);
		}
	}

}
