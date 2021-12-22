package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260 {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	static void DFS(int start) {// ���� �켱 Ž��
		visit[start] = true;
		sb.append(start + " ");
		for (int i = 0; i < list[start].size(); i++) {// start �ȿ� �ִ� ���� ���� ������ Ž��(���� �湮���� �ʾҴٸ� �� ������ ó��)
			int x = list[start].get(i);// start�� �ִ� i��° ��
			if (!visit[x])// i��° ���� �湮���� �ʾ����� �湮
				DFS(x);
		}
	}

	static void BFS(int start) {// �ʺ� �켱 Ž��
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);// start�� ť�� ����
		visit[start] = true;
		while (!que.isEmpty()) {// ť�� ������ ������ �ݺ�
			int x = que.poll();// ���� ���� ���� ���� ��
			sb.append(x + " ");
			for (int i = 0; i < list[x].size(); i++) {// x�� ������ �ִ� ������ ��� Ž��
				int y = list[x].get(i);
				if (!visit[y]) {
					que.offer(y);
					visit[y] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);// N
		int M = Integer.parseInt(input[1]);// M
		int start = Integer.parseInt(input[2]);// ������
		list = new ArrayList[N + 1];// ��� ���� ����

		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();// ArrayList �ʱ�ȭ
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);// ����1
			int y = Integer.parseInt(input[1]);// ����2
			list[x].add(y);// ������ ���⼺�� ���� �� list�� ��� ���� �־���
			list[y].add(x);
		}
		for (int i = 1; i < N + 1; i++)
			Collections.sort(list[i]);// ����(���ĵ��� ������ ���� ���� ������ Ž���� ���� ���ϴ� ��찡 ����)

		visit = new boolean[N + 1];// visit �ʱ�ȭ(����)
		DFS(start);
		sb.append("\n");
		visit = new boolean[N + 1];// visit �ʱ�ȭ(DFS���� ���Ŀ� ���� ���·� �ʱ�ȭ)
		BFS(start);
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}
}
