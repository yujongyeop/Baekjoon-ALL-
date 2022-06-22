package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_12789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> input_Stack = new Stack<>();
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());// N
		int flag = 1;// 나갈 수 있는 수
		String[] input = br.readLine().split(" ");// 모든 학생들의 번호표
		for (int i = N - 1; i >= 0; i--)
			input_Stack.push(Integer.parseInt(input[i]));// 번호표를 input_Stack에 넣어줌
		stack.push(input_Stack.pop());// stack에 번호표 하나를 넣어줌
		while (!stack.isEmpty()) {// stack이 비어 있을 때까지
			if (stack.peek() == flag) {// stack의 가장 최근에 들어온 값이 flag인 경우
				stack.pop();// stack에서 제거
				flag++;// flag 1증가
				if (!input_Stack.isEmpty()) {// input_Stack이 비어있지 않을 때
					if (!stack.isEmpty() && stack.peek() != flag)// 스택이 비어있지 않고 스택의 top이 flag가 아닐때
						stack.push(input_Stack.pop());// input_Stack의 원소 하나를 빼서 stack 넣어줌
					else if (stack.isEmpty())// 스택이 비어있을 때
						stack.push(input_Stack.pop());// input_Stack의 원소 하나를 빼서 stack 넣어줌
				}
			} else if (!input_Stack.isEmpty()) {// 스택의 top이 flag가 아니면서 input_Stack이 비어있지 않을 때
				stack.push(input_Stack.pop());// input_Stack의 원소 하나를 빼서 stack 넣어줌
			} else// 순서가 성립하지 않는 경우
				break;
		}
		if (stack.isEmpty())// 스택이 비어있을 때
			bw.write("Nice");
		else
			bw.write("Sad");
		bw.flush();
		bw.close();
		br.close();
	}

}
