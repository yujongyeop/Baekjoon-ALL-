package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_120605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<>();// 스택 초기화;
		int T = Integer.parseInt(br.readLine());// 테스트 케이스 개수
		int n = 1;// 테스트 케이스 실행 횟수
		while (n <= T) {// T번 반복할 때 까지
			String[] input = br.readLine().split(" ");// 문장 입력
			for (int i = 0; i < input.length; i++)// 단어 단위로 스택에 넣어줌
				stack.push(input[i]);
			sb.append("Case #" + n + ": ");
			while (!stack.isEmpty())// 스택이 비어있을 때까지 sb에 추가해줌
				sb.append(stack.pop() + " ");
			sb.append("\n");// 개행
			n++;// 실행 횟수 증가
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}