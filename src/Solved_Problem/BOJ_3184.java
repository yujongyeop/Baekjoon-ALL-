package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 시작 시간: 21.12.28 14:50
 * 완료 시간: 21.12.28 13:30
 */

public class BOJ_3184 {
	static int[] dx = { 0, 0, -1, 1 };// 상하좌우 배열
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static String[][] table;
	static boolean[][] visit;
	static int num_Sheep, num_Wolf;

	static void DFS(int x, int y) {
		if (visit[x][y] || table[x][y].equals("#"))
			return;
		visit[x][y] = true;
		if (table[x][y].equals("o"))// (x,y)가 o면 양 수 증가
			num_Sheep++;
		else if (table[x][y].equals("v"))// (x,y)가 v면 늑대 수 증가
			num_Wolf++;
		for (int i = 0; i < 4; i++) {// 상하좌우로 이동
			if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M)// (x+dx,y+dy)가 배열 밖으로 벗어나지 않게 설정
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
		for (int i = 0; i < N; i++) {// 사용자 값 입력
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++)
				table[i][j] = str[j];
		}

		int ans_Sheep = 0, ans_Wolf = 0; // 최종으로 살아남은 양과 늑대의 수를 저장하는 변수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				num_Sheep = 0;//반복할 때 마다 초기화 해줌
				num_Wolf = 0;
				DFS(i, j);
				if (num_Sheep > num_Wolf)// 양이 늑대보다 많을 경우
					ans_Sheep += num_Sheep;
				else// 늑대가 양이랑 같거나 더 많을 경우
					ans_Wolf += num_Wolf;
			}
		}
		bw.write(ans_Sheep + " " + ans_Wolf);
		bw.flush();
		bw.close();
		br.close();
	}

}