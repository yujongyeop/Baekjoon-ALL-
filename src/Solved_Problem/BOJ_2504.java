package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String input = br.readLine();
		br.close();
		long result = 0;
		int tmp = 1;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(') {// ( 입력 시
				stack.push(c);
				tmp *= 2;// tmp에 2를 곱함
			} else if (c == '[') {// [ 입력 시
				stack.push(c);
				tmp *= 3;// tmp에 3을 곱함
			} else if (c == ')') {// ) 입력 시
				if (stack.isEmpty() || stack.peek() != '(') {// )일 때 성립되지 않는 경우
					result = 0;
					break;
				} else {
					if (input.charAt(i - 1) == '(')// // i-1과 i가 ()인 경우에 더 해줌
						result += tmp;
					stack.pop();// (괄호를 스택에서 뺌
					tmp /= 2;// tmp값을 2로 나눔
				}
			} else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {// )일 때 성립되지 않는 경우
					result = 0;
					break;
				} else {
					if (input.charAt(i - 1) == '[')// i-1과 i가 []인 경우에 더 해줌
						result += tmp;
					stack.pop();// [괄호를 스택에서 뺌
					tmp /= 3;// tmp값을 3으로 나눔
				}
			}
		}
		if (!stack.isEmpty())
			result = 0;
		bw.write(result + "");
		bw.flush();
		bw.close();
	}

}
