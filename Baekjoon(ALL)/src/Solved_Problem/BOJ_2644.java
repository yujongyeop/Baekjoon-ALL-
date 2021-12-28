package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2644 {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int ans = 0;

	static void DFS(int now, int end, int num) {// DFS�� ��������� num(�̼�)�� ������
		if (visit[now])
			return;
		if (now == end)// N1�� N2�� ������ ��
			ans = num;
		visit[now] = true;
		for (int i = 0; i < list[now].size(); i++) {
			DFS(list[now].get(i), end, num + 1);// now�� �ڽ��� start�� �ϰ�, num(�̼�)�� 1 ����
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();
		visit = new boolean[N + 1];

		String[] input = br.readLine().split(" ");
		int N1 = Integer.parseInt(input[0]);// N1, N2�� �̼��� ����ҷ��� �ϴ� �� ����� ��ȣ�̴�.
		int N2 = Integer.parseInt(input[1]);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);// ����1
			int y = Integer.parseInt(input[1]);// ����2
			list[x].add(y);// ������ ���⼺�� ���� �� list�� ��� ���� �־���
			list[y].add(x);
		}
		for (int i = 1; i < N + 1; i++)
			Collections.sort(list[i]);

		DFS(N1, N2, 0);// Ž���� N1���� ����

		if (ans != 0)// N1�� N2�� �� Ʈ���� �ִ� ���
			bw.write(ans + "");
		else
			bw.write("-1");
		bw.flush();
		bw.close();
		br.close();
	}

}
