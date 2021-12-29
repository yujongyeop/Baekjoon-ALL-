package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * ���� �ð�: 21.12.29 14:20
 * �Ϸ� �ð�: 21.12.29 15:18
 */

public class BOJ_1058 {
	static int[][] table;
	static int N;

	static void floyd() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i == j || j == k || i == k)
						continue;
					if (table[i][j] > table[i][k] + table[k][j])// ���� �̰ų� ���� �ƴ� ģ���� ��� �� ��ȭ X
						table[i][j] = table[i][k] + table[k][j];// �ǳʼ� �ƴ� ģ���� ���(2�� �ǳ� �ƴ� ģ�� �Ӹ� �ƴ϶� N�� �ǳ� �ƴ� ģ���� �����)
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		int ans = 0;

		for (int i = 0; i < N; i++) {// ģ�� ���� �Է�
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				if (c == 'Y')// Y�� ��� 1�� ����
					table[i][j] = 1;
				else if (i != j)// i==j�� �ƴϸ� c�� 'Y'�� �ƴ� �� ó��
					table[i][j] = 100000;
			}
		}
		floyd();
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				else if (table[i][j] <= 2)// 2-ģ���ų� �ٷ� �ƴ� ģ���� �� tmp�� �÷���
					tmp++;
			}
			ans = Math.max(ans, tmp);// �ִ밪 ����
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
