package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		while (!input.equals(".")) {
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);// input의 i번째 문자
				if (c == '(' || c == '[')// 여는 괄호들은 스택에 넣어줌
					stack.push(c);
				else if (c == ')') {// 닫는 소괄호일 때
					if (stack.isEmpty()) {// 스택이 비어 있을 때
						stack.push(c);// 닫는 소괄호를 스택에 넣어줌
						break;// for문 탈출
					} else if (stack.peek() != '(')// 스택의 top이 여는 소괄호가 아닐 때
						break;// for문 탈출
					stack.pop();// 스택의 탑이 여는 소괄호일 경우 pop해줌
				} else if (c == ']') {// 닫는 대괄호일 때
					if (stack.isEmpty()) {// 스택이 비어 있을 때
						stack.push(c);// 닫는 대괄호를 스택에 넣어줌
						break;// for문 탈출
					} else if (stack.peek() != '[')// 스택의 top이 여는 대괄호가 아닐 때
						break;// for문 탈출
					stack.pop();// 스택의 탑이 여는 대괄호일 경우 pop해줌
				}
			}
			if (stack.isEmpty())// 스택이 비어있을 때
				sb.append("yes\n");
			else// 스택이 비어 있지 않을 때
				sb.append("no\n");
			input = br.readLine();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}