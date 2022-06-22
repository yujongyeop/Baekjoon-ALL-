package Solved_Problem;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1271 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		입력 값의 범위 때문에 BigInteger 사용
		BigInteger m = sc.nextBigInteger();
		BigInteger n = sc.nextBigInteger();
		/*
		 * divideAndRemainder 사용 
		 * m.divideAndRemainder(n)은 m/n과 같은 효과 Return값: 배열(몫, 나머지)
		 */
		BigInteger[] result = m.divideAndRemainder(n);
		System.out.println(result[0]);
		System.out.println(result[1]);
		sc.close();
	}

}
