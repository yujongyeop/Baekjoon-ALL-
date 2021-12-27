package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1012 {
	static int M, N, K;
	static int[][] table;
	static boolean[][] visit;
	static int[] dx = { 0, 0, -1, 1 };// �����¿� �̵� �� ���
	static int[] dy = { 1, -1, 0, 0 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void make_Table() throws IOException {// ����� �Է°� �޴� �Լ�
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N(X��)
		M = Integer.parseInt(input[1]);// M(Y��)
		K = Integer.parseInt(input[2]);// K(���߰���)
		table = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			input = br.readLine().split(" ");
			table[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;// (x,y)�� 1�� ����;
		}

	}

	static int DFS(int x, int y) {
		if (visit[x][y] || table[x][y] == 0)//�湮�߰ų�, (x,y)�� 0�� ���
			return 0;
		int count = 1;
		visit[x][y] = true;// (x,y)�湮 ó��
		for (int i = 0; i < 4; i++) {// �����¿� Ž��
			if (x + dx[i] < 0 || x + dx[i] >= N || y + dy[i] < 0 || y + dy[i] >= M)
				continue;
			count += DFS(x + dx[i], y + dy[i]);// �����¿� �̵� ���� �� DFSȣ��
		}
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop_Num = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < loop_Num; i++) {
			ans = 0;
			make_Table();
			for (int j = 0; j < N; j++) {// (0,0)���� (N-1,M-1)���� ��� Ž��
				for (int k = 0; k < M; k++) {
					if (DFS(j, k) != 0)// (j,k)�� �Ѱ��̻��� ���߿� ����Ǿ��� ��
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
