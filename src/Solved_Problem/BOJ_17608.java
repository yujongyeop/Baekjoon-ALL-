package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_17608 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++)// 사용자 입룍 스택에 저장
			stack.push(Integer.parseInt(br.readLine()));
		int ans = 1;// 가장 오른쪽에 있는 막대기는 무조건 보임으로 1로 설정
		int max = stack.pop();// 가장 오른쪽에 있는 막대를 최대값으로 설정
		while (!stack.isEmpty()) {// 스택이 비어있을 때까지
			if (stack.peek() > max) {// 스택의 top이 max보다 클(보이는) 경우
				max = stack.pop();// max값 갱신
				ans++;// ans에 1을 더해줌
			} else// 보이지 않는 막대기의 경우
				stack.pop();
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
