package Solved_Problem;

/*
 * ���� �ð�: 21.12.30 11:10
 * ���� �ð�: 21.12.30.11:40
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_21736 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visit;
	static int ans = 0;
	static int N, M;

	static void DFS(int x, int y) {
		if (visit[x][y] || map[x][y] == 'X')// �̹� �湮���� �� Ȥ�� ���̶� ������ ��
			return;
		visit[x][y] = true;
		char c = map[x][y];
		if (c == 'P')
			ans++;
		for (int i = 0; i < 4; i++) {//�����¿� Ž��
			if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M)// 0<=x+dx,y+dy<=N-1 ����
				DFS(x + dx[i], y + dy[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new char[N][M];
		visit = new boolean[N][M];
		int my_x = 0, my_y = 0;// �������� ��ġ ����

		for (int i = 0; i < N; i++) {// ���� ����
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = input.charAt(j);
				if (c == 'I') {// �������� ��ġ ����
					my_x = i;
					my_y = j;
					map[i][j] = 'O';
				} else {// �������� ��ġ�� �ƴ� ������
					map[i][j] = c;
				}
			}
		}

		DFS(my_x, my_y);// �������� ��ġ���� ����

		if (ans != 0)// ans�� 0���� ũ�� ans�� �ƴϸ� TT�� ���
			bw.write(ans + "");
		else
			bw.write("TT");
		bw.flush();
		bw.close();
		br.close();
	}

}
