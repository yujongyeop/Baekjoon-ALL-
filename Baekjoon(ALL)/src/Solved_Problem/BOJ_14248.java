package Solved_Problem;
/*
 * ���� �ð�: 21.12.30 13:52
 * ���� �ð�: 21.12.30 14:09
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_14248 {
	static int[] arr;
	static boolean[] visit;
	static int N;
	static int ans = 0;

	static void DFS(int start) {
		if (visit[start])
			return;
		visit[start] = true;
		ans++;// ó�� �湮�� ������ ����
		int dx = start + arr[start];
		if (dx < N)// �������� �̵�
			DFS(dx);
		dx = start - arr[start];
		if (dx >= 0)// �������� �̵�
			DFS(dx);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visit = new boolean[N];
		String[] input = br.readLine().split(" ");// �� ����
		for (int i = 0; i < N; i++) // �� ���� ���� �Է�
			arr[i] = Integer.parseInt(input[i]);
		int start = Integer.parseInt(br.readLine()) - 1;// ������ġ(-1�� ���ִ� ������ �迭�� ����� �� -1 �Ǳ� ����)
		DFS(start);// start���� DFS ����
		bw.write(ans + " ");
		bw.flush();
		br.close();
		bw.close();
	}

}
