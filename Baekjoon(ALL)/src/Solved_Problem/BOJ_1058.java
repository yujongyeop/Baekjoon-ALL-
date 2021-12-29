package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 시작 시간: 21.12.29 14:20
 * 완료 시간: 21.12.29 15:18
 */

public class BOJ_1058 {
	static int[][] table;
	static int N;

	static void floyd() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i == j || j == k || i == k)
						continue;
					if (table[i][j] > table[i][k] + table[k][j])// 본인 이거나 직접 아는 친구일 경우 값 변화 X
						table[i][j] = table[i][k] + table[k][j];// 건너서 아는 친구일 경우(2번 건너 아는 친구 뿐만 아니라 N번 건너 아는 친구고 계산함)
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		int ans = 0;

		for (int i = 0; i < N; i++) {// 친구 관계 입력
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				if (c == 'Y')// Y일 경우 1로 저장
					table[i][j] = 1;
				else if (i != j)// i==j가 아니면 c가 'Y'가 아닐 때 처리
					table[i][j] = 100000;
			}
		}
		floyd();
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				else if (table[i][j] <= 2)// 2-친구거나 바로 아는 친구일 때 tmp를 늘려줌
					tmp++;
			}
			ans = Math.max(ans, tmp);// 최대값 갱신
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
