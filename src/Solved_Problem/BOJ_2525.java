package Solved_Problem;

import java.util.Scanner;

public class BOJ_2525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		a += c / 60;
		b += c % 60;
		//60분 이상이면 한시간을 더 해줌
		if (b >= 60) {
			a++;
			b-=60;
		}
		//24시간 이상이면 24를 빼줌
		if(a>=24) {
			a-=24;
		}
		System.out.println(a + " " + b);
		sc.close();
	}

}
