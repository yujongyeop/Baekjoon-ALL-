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
		if (visit[start])// �̹� �湮������
			return 0;
		int count = 1;
		visit[start] = true;
		for (int i = 0; i < list[start].size(); i++) {//start�� ����� ��� �湮
			count+=DFS(list[start].get(i));
		}
		return count;// count(����� ��� ����) ����
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
		for (int i = 1; i <= N; i++) {// �������� 1~N���� ��� �ݺ�
			if (DFS(i) != 0)
				ans++;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}

}
