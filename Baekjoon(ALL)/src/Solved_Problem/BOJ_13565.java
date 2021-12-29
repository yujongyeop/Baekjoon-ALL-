package Solved_Problem;
/*
 * ���� �ð�: 21.12.29 9:55
 * �Ϸ� �ð�: 21.12.29 10:30
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13565 {
	static int[] dx = { 0, 0, -1, 1 };// �����¿� �迭
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static int[][] table;
	static boolean[][] visit;

	static void DFS(int x, int y) {
		if (visit[x][y] || table[x][y] == 1)// �̹� �湮�߰ų�, �������̸� ����
			return;
		if (x == 0) {// x�� 0(�ٱ���)�̸� ���� ������ �����
			System.out.println("YES");
			System.exit(0);
		}
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M)// (x+dx,y+dy)�� �迭 ������ ����� �ʰ� ����
				DFS(x + dx[i], y + dy[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N
		M = Integer.parseInt(input[1]);// M
		table = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {// ���� �Է�
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				table[i][j] = str.charAt(j) - '0';
		}
		br.close();
		for (int i = 0; i < M; i++)// (N-1,0) ���� (N-1,M-1)���� Ž��
			DFS(N - 1, i);

		System.out.println("NO");// �ش� ������ ����� ���� DFS�� ���� �ٱ��� ����� ���ʸ���� ������ ���ϴ� ��츦 ã�� ������ �� ����
	}

}
