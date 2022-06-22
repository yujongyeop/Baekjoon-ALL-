package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_11725 {
	static ArrayList<Integer>[] list;
	static int[] arr;
	static boolean[] visit;

	static void DFS(int start, int parent) {// 부모노드를 매개변수로 넣음
		if (visit[start])
			return;
		arr[start] = parent;// 노드 start의 부모를 parent로 저장
		visit[start] = true;
		for (int i = 0; i < list[start].size(); i++) {
			DFS(list[start].get(i), start);// start의 자식 노드들의 parent값을 start로 넣음
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());// N
		list = new ArrayList[N + 1];
		arr = new int[N + 1];// 노드의 부모 노드를 저장할 배열
		visit = new boolean[N + 1];// 방문 여부를 저장할 배열
		String[] input;
		for (int i = 0; i < N + 1; i++)// ArrayList배열 초기화
			list[i] = new ArrayList<Integer>();
		for (int i = 1; i < N; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);// 정점1
			int y = Integer.parseInt(input[1]);// 정점2
			list[x].add(y);// 간선에 반향성이 없어 두 list에 모두 값을 넣어줌
			list[y].add(x);
		}
		DFS(1, 0);
		for (int i = 2; i < N + 1; i++)// 노드 2부터 N까지의 부모노드 출력
			bw.write(arr[i] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}