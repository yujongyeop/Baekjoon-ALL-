package Solved_Problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931 {
	/*
	 * 유형: 그리디, 정렬 문제 풀이: 기본적으로 종료시간이 빠른 순으로 정렬한다(단, 종료시간이 같다면 시작시간이 빠른 순으로 정렬) 이는
	 * 앞에 선택한 회의가 끝났을 때 바로 뒤에 이따른 회의를 선택하여 최대한 많은 회의를 할 수 있는 경우의 수이다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] time = new int[N][2];// [N][0]은 시작 시간, [N][1]은 종료 시간
		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 종료시간이 같다면 시작시간이 빠른순으로 정렬
				return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});
		int ans = 0, prev_end_time = 0;
		for (int i = 0; i < N; i++) {
			if (prev_end_time <= time[i][0]) {// 이전 회의의 종료시간보다 시간이 크거나 같을 때
				prev_end_time = time[i][1];
				ans++;
			}
		}
		System.out.println(ans);
	}
}