package Solved_Problem;

import java.util.Scanner;

public class BOJ_11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] coin = new int[N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}
		sc.close();
		for (int i = N - 1; i >= 0; i--) {
			ans += M / coin[i];
			M %= coin[i];
		}
		System.out.println(ans);
	}

}
