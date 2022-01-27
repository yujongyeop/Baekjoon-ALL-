package unSolved_Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		String inputString = br.readLine();
		int ans = 0;
		int len = 0;
		int cnt = 0;
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			if (c == ')') {
				while (stack.peek() != '(') {
					stack.pop();
					cnt++;
				}
				stack.pop();
				int num = stack.pop() - '0';
				len = ((cnt + len) * num);
				cnt = 0;
			} else if (c == '(' && len != 0) {
				stack.push(c);
				ans += len;
				len = 0;
			} else {
				stack.push(c);
			}
		}
		if (!stack.isEmpty())
			ans += stack.size();
		if (len > 0)
			ans += len;
		System.out.println(ans);
	}

}
