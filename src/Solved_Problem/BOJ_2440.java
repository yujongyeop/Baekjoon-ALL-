package Solved_Problem;

import java.util.Scanner;

public class BOJ_2440 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = N; i > 0; i--) {
			for (int j = i; j > 0; j--)
				System.out.printf("*");
			System.out.println();
		}
	}

}
