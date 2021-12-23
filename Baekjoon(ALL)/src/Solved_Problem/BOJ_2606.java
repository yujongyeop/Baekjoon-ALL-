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
		int start = 1;// ������
		list = new ArrayList[N + 1];// ��� ���� ����
		visit = new boolean[N + 1];// �湮 Ȯ�� �迭

		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();// ArrayList �ʱ�ȭ
		for (int i = 0; i < M; i++) {
			String[] user_input = br.readLine().split(" ");
			int x = Integer.parseInt(user_input[0]);// ����1
			int y = Integer.parseInt(user_input[1]);// ����2
			list[x].add(y);// ������ ���⼺�� ���� �� list�� ��� ���� �־���
			list[y].add(x);
		}
		for (int i = 1; i < N + 1; i++)
			Collections.sort(list[i]);// ����(���ĵ��� ������ ���� ���� ������ Ž���� ���� ���ϴ� ��찡 ����)
		DFS(start);
		bw.write(ans-1 + "");// ans���� 1�� ���� ������ ���ʷ� ������ ��ǻ�ʹ� ������ϱ� ����
		bw.flush();
		bw.close();
		br.close();
	}

}