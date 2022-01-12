package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_2841 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);// 음의 개수
		@SuppressWarnings("unchecked")
		Stack<Integer>[] stack = new Stack[7];
		for (int i = 0; i < 7; i++) {// 스택 초기화
			stack[i] = new Stack<Integer>();
			stack[i].push(0);// 빈 상태를 피하기 위해 0을 넣어줌
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");// 사용자 입력
			int line = Integer.parseInt(input[0]);// 라인
			int fret = Integer.parseInt(input[1]);// 프렛
			while (stack[line].peek() > fret) {// 라인의 peek가 프렛보다 클 경우
				stack[line].pop();// 라인의 top을 삭제
				ans++;// 횟수 증가
			}
			if (stack[line].peek() != fret) {// 라인의 peek가 프렛과 같지 않으면
				stack[line].push(fret);// 프렛을 라인의 top에 넣어줌
				ans++;// 횟수 증가
			}
		}
		bw.write(ans + "");
		bw.flush();
		br.close();
		bw.close();
	}

}
