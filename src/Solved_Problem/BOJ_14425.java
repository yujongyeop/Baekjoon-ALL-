package Solved_Problem;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_14425 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i = 0 ; i < n; i++) {
			wordMap.put(sc.next(), 1);
		}
		int result = 0;
		for(int i = 0 ; i < m ; i++) {
			result+= wordMap.get(sc.next()) != null ? 1:0;
		}
		sc.close();
		System.out.println(result);
	}

}
