package Solved_Problem;

import java.util.Scanner;

public class BOJ_2480 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		int result = 0;
		if(a == b) {
			if(a==c) {
				result = 10000+(a*1000);
			}
			else {
				result = 1000+(a*100);
			}
		}
		else if(a==c){
			result = 1000+(a*100);
		}
		else if(b==c) {
			result = 1000+(b*100);
		}
		else {
			result = Math.max(a, Math.max(b, c))*100;
		}
		System.out.println(result);

	}
}
