package Solved_Problem;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1388 {
	static int N, M, ans;
	static String[] map;
	static boolean[][] visit;

	static void DFS(int x, int y) {// (0,0)~(N-1,M-1)���� Ž��
		if (x >= N)// x�� N���� Ŀ���� ��� DFS�� ����
			return;
		else if (!visit[x][y]) {// (x,y)�湮�� ���� �ʾ��� ��
			visit[x][y] = true;// (x,y)�� �湮 ó��
			char c = map[x].charAt(y);// (x,y)�� ���ڰ� ����
			if (c == '-') {// c�� '-'�� ��
				while (y + 1 < M && map[x].charAt(y + 1) == c) {// y+1�� M���� �����鼭 c�� (x,y+1)�� ���� ��('-'�� ���� �� ��)
					y++;// y�� ����(y���� ����ϴ� ������ ������ ���̱� ���ؼ��̴�.(dy�� �� ��� ���ǹ������� �� ��ŭ�� �ƴ����� ��Ͱ� �����)
					visit[x][y] = true;// (x,y)�� �湮 ó��
				}
				ans++;
			} else {// c�� '|'�� ��
				int dx = x + 1;// c�� '|'�� ��� ����� x��(x������ ������� �ʴ� ������ x�� �ٲٰԵǸ� 15�� ° �ٿ��� ������ ��)
				while (dx < N && map[dx].charAt(y) == c) {// dx�� N���� �����鼭 c�� (dx,y)�� ���� ��('|'�� ���ӵ� ��)
					visit[dx][y] = true;// (dx,y)�� �湮 ó��
					dx++;
				}
				ans++;
			}
		}
		if (y == M - 1)// y�� M-1�� ������ �ش� ���� ��� Ž���� ������ �����ٷ� ����
			DFS(x + 1, 0);
		else
			DFS(x, y + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N
		M = Integer.parseInt(input[1]);// M
		map = new String[N];// �ٴ� ���
		visit = new boolean[N][M];// �湮 ���� ���� �迭
		ans = 0; // ����

		for (int i = 0; i < N; i++)// ����� �� �Է�
			map[i] = br.readLine();
		DFS(0, 0);// DFSȣ��
		bw.write(ans + "");// ���� ���
		bw.flush();
		br.close();
		bw.close();
	}
}
