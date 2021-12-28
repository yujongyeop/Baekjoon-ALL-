package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * ���� �ð�: 21.12.28 14:50
 * �Ϸ� �ð�: 21.12.28 13:30
 */

public class BOJ_3184 {
	static int[] dx = { 0, 0, -1, 1 };// �����¿� �迭
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static String[][] table;
	static boolean[][] visit;
	static int num_Sheep, num_Wolf;

	static void DFS(int x, int y) {
		if (visit[x][y] || table[x][y].equals("#"))
			return;
		visit[x][y] = true;
		if (table[x][y].equals("o"))// (x,y)�� o�� �� �� ����
			num_Sheep++;
		else if (table[x][y].equals("v"))// (x,y)�� v�� ���� �� ����
			num_Wolf++;
		for (int i = 0; i < 4; i++) {// �����¿�� �̵�
			if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M)// (x+dx,y+dy)�� �迭 ������ ����� �ʰ� ����
				DFS(x + dx[i], y + dy[i]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		table = new String[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {// ����� �� �Է�
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++)
				table[i][j] = str[j];
		}
		
		int ans_Sheep = 0, ans_Wolf = 0; // �������� ��Ƴ��� ��� ������ ���� �����ϴ� ����
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				num_Sheep = 0;//�ݺ��� �� ���� �ʱ�ȭ ����
				num_Wolf = 0;
				DFS(i, j);
				if (num_Sheep > num_Wolf)// ���� ���뺸�� ���� ���
					ans_Sheep += num_Sheep;
				else// ���밡 ���̶� ���ų� �� ���� ���
					ans_Wolf += num_Wolf;
			}
		}
		bw.write(ans_Sheep + " " + ans_Wolf);
		bw.flush();
		bw.close();
		br.close();
	}

}
