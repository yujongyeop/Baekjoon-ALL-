package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input != 0)// 입력이 0이 아니면 스택에 넣어줌
				stack.push(input);
			else// 입력이 0일 경우 스택에서 가장 최근에 들어온 값을 뺴줌
				stack.pop();
		}
		int ans = 0;
		for (int M : stack)// 스택 안에 있는 수를 모두 더해줌
			ans += M;
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
