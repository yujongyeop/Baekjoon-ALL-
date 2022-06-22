package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1011 {
	static int distance;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T != 0) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			distance = y - x;
			sb.append(calc(distance) + "\n");
			T--;
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	static int calc(int d) {
		double N = Math.round(Math.sqrt(d));// 거리의 제곱근을 구함
		if ((N * N) >= distance)// 제곱했을 때 D보다 작거나 같을 때
			return (int) (N * 2) - 1;
		else
			return (int) N * 2;
	}

}
