package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		int last_Value = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			char c = input.charAt(0);// 첫 글자
			if (c == 'p') {
				if (input.charAt(1) == 'u') {// push일 때
					last_Value = Integer.parseInt(input.substring(5));
					que.add(last_Value);
				} else// pop일때
					sb.append((que.isEmpty() ? "-1\n" : (que.poll() + "\n")));
			} else if (c == 's')// size일 때
				sb.append(que.size() + "\n");
			else if (c == 'e')// empty일때
				sb.append((que.isEmpty() ? "1" : "0") + "\n");
			else if (c == 'f')// front일때
				sb.append((que.isEmpty() ? "-1" : que.peek()) + "\n");
			else if (c == 'b') {// back일때
				if (!que.isEmpty())
					sb.append(last_Value + "\n");
				else
					sb.append("-1\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
