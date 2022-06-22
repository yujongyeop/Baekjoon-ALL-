package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_3986 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		/*
		 * 좋은 단어가 아닐 경우 (EX)BABBBA) 연산 후 스택에는 BABA로 남아있음
		 * 즉, 좋은 단어가 아닐 경우에는 연산 종료 후 스택은 빈
		 * 상태가 아님
		 */
		while (N > 0) {
			Stack<Character> stack = new Stack<>();
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				char c = input.charAt(j);
				if (stack.isEmpty()) {// 스택이 비어 있으면 넣어줌
					stack.push(c);
				} else if (stack.peek() == c) {// 스택의 탑과 c가 같으면 pop을 해줌
					stack.pop();
				} else {// 아닐 경우 스택에 추가
					stack.push(c);
				}
			}
			if (stack.isEmpty())// 스택이 비어 있을 때(좋은 단어일 때)
				ans++;
			N--;
		}
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}

}
