package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			que.add(i);
		while (que.size() != 1) {
			sb.append(que.poll() + " ");
			que.add(que.poll());
		}
		sb.append(que.poll());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}