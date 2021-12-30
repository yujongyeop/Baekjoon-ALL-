package Solved_Problem;
/*
 * 시작 시간: 21.12.30 13:52
 * 종료 시간: 21.12.30 14:09
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_14248 {
	static int[] arr;
	static boolean[] visit;
	static int N;
	static int ans = 0;

	static void DFS(int start) {
		if (visit[start])
			return;
		visit[start] = true;
		ans++;// 처음 방문할 때마다 증가
		int dx = start + arr[start];
		if (dx < N)// 우측으로 이동
			DFS(dx);
		dx = start - arr[start];
		if (dx >= 0)// 좌측으로 이동
			DFS(dx);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visit = new boolean[N];
		String[] input = br.readLine().split(" ");// 돌 개수
		for (int i = 0; i < N; i++) // 돌 위에 숫자 입력
			arr[i] = Integer.parseInt(input[i]);
		int start = Integer.parseInt(br.readLine()) - 1;// 현재위치(-1을 해주는 이유는 배열에 저장될 때 -1 되기 때문)
		DFS(start);// start에서 DFS 실행
		bw.write(ans + " ");
		bw.flush();
		br.close();
		bw.close();
	}

}