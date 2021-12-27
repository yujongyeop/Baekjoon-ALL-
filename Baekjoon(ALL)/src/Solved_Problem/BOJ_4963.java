package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_4963 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] table;
	static boolean[][] visit;
	static int W, H;
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };// ��,��,��,��,��,��,��,��
	static int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };

	static void make_Table() throws IOException {// ����� �Է°� �޴� �Լ�
		table = new int[H][W];
		visit = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < W; j++) {
				table[i][j] = Integer.parseInt(input[j]);
			}
		}
	}

	static int DFS(int x, int y) {
		if (table[x][y] == 0 || visit[x][y])
			return 0;
		int count = 1;
		visit[x][y] = true;
		for (int i = 0; i < 8; i++) {
			if (x + dx[i] < 0 || x + dx[i] >= H || y + dy[i] < 0 || y + dy[i] >= W)//�����¿� �밢���� table �迭 ������ �� ��� ó��
				continue;
			count += DFS(x + dx[i], y + dy[i]);//�����¿�밢���� ���� DFSó��
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String[] input = br.readLine().split(" ");
			W = Integer.parseInt(input[0]);// �ʺ�
			H = Integer.parseInt(input[1]);// ����
			if (W == 0 && H == 0)// 0,0 �Է� �� �ݺ��� ����
				break;
			else
				make_Table();// ����ڰ� �Է� �Լ� ȣ��
			int ans = 0;
			for (int i = 0; i < H; i++) {// (0,0)���� (H-1,W-1)���� Ž��
				for (int j = 0; j < W; j++) {
					if (DFS(i, j) != 0)// (i,j)�� ���ϰ��� 0�� �ƴҶ����� ans���� 1�� ����
						ans++;
				}
			}
			bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
