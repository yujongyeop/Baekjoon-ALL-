package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1003 {
	static int[] DP = new int[41];

	static int fibonacci(int num) {
		if (num < 2)
			return DP[num];
		if (DP[num] != 0) {
			return DP[num];
		} else {
			return DP[num] = fibonacci(num - 1) + fibonacci(num - 2);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		DP[0] = 0;
		DP[1] = 1;
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input < 1) {
				sb.append(1 + " " + 0 + "\n");
				continue;
			}
			sb.append(fibonacci(input - 1) + " " + fibonacci(input) + "\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}

}