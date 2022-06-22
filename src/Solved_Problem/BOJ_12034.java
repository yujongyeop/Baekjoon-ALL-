package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12034 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Queue<Integer> que = new LinkedList<>();
	static LinkedList<Integer> list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i < T + 1; i++) {
			input();// 사용자 값 입력
			sb.append("Case #" + i + ": ");
			calc();// 계산 함수 호출
			Collections.sort(list);// list 오름차순으로 정렬
			for (int M : list)// list에 있는 값들을 sb에 저장함
				sb.append(M + " ");
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	static void calc() {// 계산 부분
		while (!que.isEmpty()) {// 큐가 비어있지 않을 동안
			int max_Price = 0;// 가장 비싼 금액
			for (int j = 0; j < que.size() - 1; j++)
				que.add(que.poll());
			max_Price = (int) (que.poll() * 0.75);// 마지막 큐를 max_Price에 저장(Poll)하고 0.75를 곱해줌
			boolean isPolled = false;// 할인된 가격과 같은 가격이 여러개일 경우를 위해 사용(중복값이 que에서 빠지는 걸 방지하기 위함)
			for (int i = 0; i < que.size(); i++) {
				if (max_Price == que.peek() && !isPolled) {// 할인된 가격일 경우(isPolled는 중복값 제거를 위해 사용)
					list.add(que.poll());// list에 넣어줌
					isPolled = true;// isPolled를 true로 바꿔 같은 값이 빠지는 걸 방지
					i--;// 큐에서 하나가 빠졌지 때문에 i를 1빼줌
				} else// 값이 아닐 경우 다시 넣어줌
					que.add(que.poll());
			}
		}
	}

	static void input() throws NumberFormatException, IOException {// 사용자 값 입력
		list = new LinkedList<>();// list 초기화
		N = Integer.parseInt(br.readLine());// 물건의 개수
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < N * 2; i++)// que에 가격 정보를 넣어줌
			que.add(Integer.parseInt(str[i]));
	}

}