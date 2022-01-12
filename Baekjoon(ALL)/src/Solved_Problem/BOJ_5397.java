package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		while (N > 0) {// 테스트 케이스 반복문
			String input = br.readLine();// 비밀번호 입력
			for (int j = 0; j < input.length(); j++) {
				char c = input.charAt(j);// 한 글자씩 추출
				if (c == '>') {// > 일 경우
					if (!right.isEmpty())// right 스택이 비어있지 않을 때
						left.push(right.pop());// right 스택의 top을 left 스택에 넣어줌
				} else if (c == '<') {// < 일 경우
					if (!left.isEmpty())// left 스택이 비어있지 않을 때
						right.push(left.pop());// left 스택의 top을 right 스택에 넣어줌
				} else if (c == '-') {// - 일 경우
					if (!left.isEmpty())// left 스택이 비어있지 않을 때
						left.pop();// left 스택의 top을 삭제해줌
				} else {// 문자 입력일 경우
					left.push(c);// left 스택에 넣어줌
				}

			}
			if (!right.isEmpty())// right 스택에 값이 남아 있는 경우 left 스택에 넣어줌
				while (!right.isEmpty())
					left.push(right.pop());
			while (!left.isEmpty())// left 스택을 right 스택에 넣어줌(reverse)
				right.push(left.pop());
			while (!right.isEmpty())// 비밀번호 출력
				sb.append(right.pop());
			sb.append("\n");// 개행
			N--;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
