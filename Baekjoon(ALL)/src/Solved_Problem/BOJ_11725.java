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

	static void DFS(int start, int parent) {// �θ��带 �Ű������� ����
		if (visit[start])
			return;
		arr[start] = parent;// ��� start�� �θ� parent�� ����
		visit[start] = true;
		for (int i = 0; i < list[start].size(); i++) {
			DFS(list[start].get(i), start);// start�� �ڽ� ������ parent���� start�� ����
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());// N
		list = new ArrayList[N + 1];
		arr = new int[N + 1];// ����� �θ� ��带 ������ �迭
		visit = new boolean[N + 1];// �湮 ���θ� ������ �迭
		String[] input;
		for (int i = 0; i < N + 1; i++)// ArrayList�迭 �ʱ�ȭ
			list[i] = new ArrayList<Integer>();
		for (int i = 1; i < N; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);// ����1
			int y = Integer.parseInt(input[1]);// ����2
			list[x].add(y);// ������ ���⼺�� ���� �� list�� ��� ���� �־���
			list[y].add(x);
		}
		DFS(1, 0);
		for (int i = 2; i < N + 1; i++)// ��� 2���� N������ �θ��� ���
			bw.write(arr[i] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
