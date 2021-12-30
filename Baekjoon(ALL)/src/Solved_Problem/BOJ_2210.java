package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_2210 {
	static int[] dx = { 0, 0, -1, 1 };// 상하좌우 배열
	static int[] dy = { 1, -1, 0, 0 };
	static int[] arr = new int[6];// 6개의 숫자 담는 배열
	static ArrayList<Integer> list = new ArrayList<>();
	static int[][] table = new int[5][5];
	static boolean[] visit;

	static void DFS(int x, int y, int depth) {
		if (depth == 6) {// 길이가 6이 됐을 때
			int num = 0;
			for (int i = 0; i < 6; i++)// arr배열에 있는 수를 int형으로 변환
				num += (arr[i] * (int) Math.pow(10, 5 - i));
			if (!list.contains(num)) {// list에 num이 존재하지 않을 경우 추가 해줌
				list.add(num);
			}
			return;
		}
		arr[depth] = table[x][y];// (x,y)에 있는 수를 배열에 depth 위치에 넣어줌
		for (int i = 0; i < 4; i++) {// 상하좌우 탐색
			if (x + dx[i] >= 0 && x + dx[i] < 5 && y + dy[i] >= 0 && y + dy[i] < 5)
				DFS(x + dx[i], y + dy[i], depth + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 5; i++) {// 숫자판 입력 받아오는 부분
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 5; j++)
				table[i][j] = Integer.parseInt(input[j]);
		}

		for (int i = 0; i < 5; i++) {// 시작점을 (0,0)부터 (4,4)까지 모두 탐색
			for (int j = 0; j < 5; j++)
				DFS(i, j, 0);
		}
		int ans = list.size();// list의 개수가 정답임
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}