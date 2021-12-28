package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_2210 {
	static int[] dx = { 0, 0, -1, 1 };// �����¿� �迭
	static int[] dy = { 1, -1, 0, 0 };
	static int[] arr = new int[6];// 6���� ���� ��� �迭
	static ArrayList<Integer> list = new ArrayList<>();
	static int[][] table = new int[5][5];
	static boolean[] visit;

	static void DFS(int x, int y, int depth) {
		if (depth == 6) {// ���̰� 6�� ���� ��
			int num = 0;
			for (int i = 0; i < 6; i++)// arr�迭�� �ִ� ���� int������ ��ȯ
				num += (arr[i] * (int) Math.pow(10, 5 - i));
			if (!list.contains(num)) {// list�� num�� �������� ���� ��� �߰� ����
				list.add(num);
			}
			return;
		}
		arr[depth] = table[x][y];// (x,y)�� �ִ� ���� �迭�� depth ��ġ�� �־���
		for (int i = 0; i < 4; i++) {// �����¿� Ž��
			if (x + dx[i] >= 0 && x + dx[i] < 5 && y + dy[i] >= 0 && y + dy[i] < 5)
				DFS(x + dx[i], y + dy[i], depth + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 5; i++) {// ������ �Է� �޾ƿ��� �κ�
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 5; j++)
				table[i][j] = Integer.parseInt(input[j]);
		}

		for (int i = 0; i < 5; i++) {// �������� (0,0)���� (4,4)���� ��� Ž��
			for (int j = 0; j < 5; j++)
				DFS(i, j, 0);
		}
		int ans = list.size();// list�� ������ ������
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
