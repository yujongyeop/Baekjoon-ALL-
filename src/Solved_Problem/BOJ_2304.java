package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * 해결 방식: 막대를 입력 받아 arr배열에 인덱스는 L, Value를 H로 저장함
 * 막대기의 위치와 높이를 입력 받으며 first(첫 막대기 위치),last(마지막 막대기 위치), longest(가장 긴 막대기의 인덱스)를 업데이트 해줌
 * longest를 기준으로 좌우로 나눠서 연산을 해준다.
 * 좌측은 first~longest까지 연산, 우측은 longest+1 ~ last까지 연산한다.
 * 연산은 i값을 증가시키면서 arr[i]의 value가 stack의 top보다 높으면 스택에 넣어준다
 * 그 후 ans에 stack의 top을 더해준다.
 */

public class BOJ_2304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int ans = 0, first = 1001, last = -1, longest = 0;
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int L = Integer.parseInt(input[0]);
			int H = Integer.parseInt(input[1]);
			arr[L] = H;
			if (last < L)
				last = L;
			if (first > L)
				first = L;
			if (H > arr[longest])
				longest = L;
		}
		for (int i = first; i <= longest; i++) {// first~longest까지 연산
			if (arr[i] != 0) {
				if (stack.isEmpty())// 스택이 비어 있을 경우(처음 값이 들어왔을 때)
					stack.push(arr[i]);
				else if (arr[i] > stack.peek())// 스택의 top보다 높이가 높은 경우
					stack.push(arr[i]);
			}
			ans += stack.peek();// 스택의 top만큼 더 해줌
		}
		while (!stack.empty())// 스택 비어줌
			stack.pop();
		for (int i = last; i > longest; i--) {// last~longest+1까지 연산(연산방식은 좌측 연산 방법과 동일)
			if (arr[i] != 0) {
				if (stack.isEmpty())
					stack.push(arr[i]);
				else if (arr[i] > stack.peek())
					stack.push(arr[i]);
			}
			ans += stack.peek();
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
