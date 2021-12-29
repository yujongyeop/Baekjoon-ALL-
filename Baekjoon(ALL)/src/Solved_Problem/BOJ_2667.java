package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {
	static int[] dx = { 0, 0, -1, 1 };// �����¿� �迭
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	static int count = 0;

	static void DFS(int x, int y) {
		if (visit[x][y])
			return;
		visit[x][y] = true;
		count++;//ó�� �湮�� ������ ���� ���� ��Ŵ
		for (int i = 0; i < 4; i++) {// �����¿� Ž��
			if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N)// 0<=x+dx,y+dy<=N-1 ����
				DFS(x + dx[i], y + dy[i]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {// ����ڰ� �Է� �޴� �Լ�
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 0)// �Է��� 0�� ��� �湮ó��
					visit[i][j] = true;
			}
		}

		for (int i = 0; i < N; i++) {// (0,0)���� (N-1,N-1)���� Ž��
			for (int j = 0; j < N; j++) {
				count = 0;// �ʱ�ȭ
				DFS(i, j);
				if (count > 0)// count�� 0���� ū ��� list�� �߰�
					list.add(count);
			}
		}
		Collections.sort(list);// ������������ ����
		sb.append(list.size() + "\n");// list�� ���� ���
		for (int m : list)// list�� ���ҵ� ���
			sb.append(m + "\n");
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}

}
