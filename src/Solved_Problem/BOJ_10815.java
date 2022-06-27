package Solved_Problem;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_10815 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> ownHashMap = new HashMap<Integer, Integer>();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++)
			ownHashMap.put(sc.nextInt(), 1);

		int m = sc.nextInt();
		int isReal[] = new int[m];
		for (int i = 0; i < m; i++)
			isReal[i] = sc.nextInt();

		int result[] = new int[m];
		for (int i = 0; i < m; i++)
			result[i] = ownHashMap.get(isReal[i]) != null ? ownHashMap.get(isReal[i]) : 0;

		for (int num : result)
			System.out.print(num + " ");

	}

}
