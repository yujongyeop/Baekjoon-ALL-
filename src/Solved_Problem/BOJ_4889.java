package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_4889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int ans;
		int t = 1;
		String input = br.readLine();
		while (input.charAt(0) != '-') {// -가 입력되기 전까지 반복
			ans = 0;
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c == '}' && !stack.isEmpty() && stack.peek() == '{')// 안정적인 문자열일 경우
					stack.pop();
				else// 안정적이지 못한 경우
					stack.push(c);
			}
			while (!stack.isEmpty()) {// 스택이 비어있을때까지
				char tmp = stack.pop();// top값 하나를 먼저 빼줌
				if (tmp == stack.peek()) {// tmp와 top이 같은 경우(ex. }} or {{인 경우)
					stack.pop();
					ans++;// 하나만 바꿔주면 되므로 1을 증가
				} else {// tmp와 top이 다른 경우(ex. }{인 경우)
					stack.pop();
					ans += 2;// 두 개 다 바꿔줘야 하므로 2를 증가
				}
			}
			sb.append(t + ". " + ans + "\n");// 최소 연산 수 출력
			t++;
			input = br.readLine();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
