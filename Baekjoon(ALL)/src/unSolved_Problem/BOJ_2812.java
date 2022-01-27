package unSolved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_2812 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] uinput = br.readLine().split(" ");
		int N = Integer.parseInt(uinput[0]);//숫자의 길이
		int K = Integer.parseInt(uinput[1]);// 삭제해야할 숫자의 개수
		String input = br.readLine();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {// 숫자의 길이만큼 반복
			int num = input.charAt(i)-'0';// i번째 숫자
			while (!stack.isEmpty() && stack.peek() < num && K>0) {//스택의 top이 num보다 작으며 K가 0보다 클때까지 반복
				stack.pop();//top을 제거
				K--;//K를 1줄여줌
			}
			stack.push(num);//num을 스택에 넣어줌
		}
		while (K > 0) {// 삭제 해야할 숫자가 남아 있을 때
			stack.pop();//top을 삭제
			K--;//K를 1씩 감소
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) 
			sb.append(stack.pop());// sb에 stack의 원소를 넣어줌
		sb.reverse();// sb를 뒤집어줌
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
