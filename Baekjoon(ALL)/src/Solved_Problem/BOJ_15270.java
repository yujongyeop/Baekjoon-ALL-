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
		if (ans < depth)// depth�� ans���� Ŀ�� ������ ans ����
			ans = depth;
		if (x == N)
			return;
		if (!visit[x])// x�� �湮���� �ʾ��� ��
			for (int i = x + 1; i <= N; i++) {
				if (!visit[i] && list[x].contains(i)) {// i�� �湮���� �ʾҰ� x�� i�� ����Ǿ� ���� ��
					visit[x] = true;
					visit[i] = true;
					DFS(x + 1, depth + 2);// 2�� ������Ű�� x+1�� ���� dfs ����(¦�� ã�� ���)
					visit[x] = false;
					visit[i] = false;
				}
			}
		DFS(x + 1, depth);// ¦�� ���� ���
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N
		M = Integer.parseInt(input[1]);// M
		list = new ArrayList[N + 1];// ��� ���� ����
		visit = new boolean[N + 1];// �湮 Ȯ�� �迭

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
		for (int i = 1; i <= N; i++)// ���� ��带 1���� N���� ������
			DFS(i, 0);
		if (ans < N)// ans�� N���� ���� ���� 1�� �� ����(ȥ�� �κ� ���� �ߴ� 1�� �߰�)
			bw.write(ans + 1 + "");
		else// ��ΰ� ¦�� �̷�� ���� �ߴ� ���
			bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}

}
