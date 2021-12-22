package Solved_Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16173 {
	static int N;
	static int[][] map;

	static void DFS(int x, int y) {
		if (x >= N || y >= N)// x,y�� ������ ��� ���
			return;
		int val = map[x][y];// ������ �� �ִ� ĭ��
		if (val == 0)// val�� 0�̸� ���� ����(�ð��ʰ�)
			return;
		else if (val == -1) {// ã������
			System.out.println("HaruHaru");
			System.exit(0);
		} else {
			DFS(x + val, y);// X���� ������Ŵ
			DFS(x, y + val);// Y���� ������Ŵ
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {// ����� ���� map�� ����
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		br.close();
		DFS(0, 0);
		System.out.println("Hing");// ���� ã�� �� ���� ��
	}

}
