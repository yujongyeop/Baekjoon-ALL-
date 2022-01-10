package unSolved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1966 {
	static class Node {// 인덱스번호와 중요도를 저장하는 자료 형식
		int idx;
		int priority;

		Node(int num, int priority) {// 생성자
			this.idx = num;
			this.priority = priority;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Queue<Node> que;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());// 테스트 케이스 수 입력
		while (T != 0) {// 테스트 케이스 수 만큼 반복
			que = new LinkedList<>();// 큐 초기화
			input();// 사용자 입력
			sb.append(calc() + "\n");// 연산 함수 반환 값을 sb에 저장
			T--;// 케이스트 케이스 개수 감소
		}
		bw.write(sb.toString());// 출력
		bw.flush();
		bw.close();
		br.close();
	}

	static int calc() {
		int cnt = 0;// 인쇄 횟수
		while (true) {
			Node target = que.peek();// 가장 앞에 있는 노드
			int max_Priority = 0;// 우선순위가 가장 높은 우선순위 저장
			for (int i = 0; i < que.size(); i++) {
				max_Priority = Math.max(max_Priority, que.peek().priority);// 우선순위 최대값 갱신
				que.add(que.poll());// 큐에서 빼서 다시 넣어줌
			}
			if (target.priority >= max_Priority) {// 타겟이 우선순위가 가장 높은 경우
				que.poll();// 인쇄함
				cnt++;// 인쇄 횟수에 1을 더함
				if (target.idx == M)// 타겟이 M일 경우
					return cnt;// cnt 반환
			} else// 타겟보다 높은 우선 순위가 있는 경우
				que.add(que.poll());// 인쇄하지 않음
		}
	}

	static void input() throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 문서의 개수
		M = Integer.parseInt(input[1]); // 몇 번째로 인쇄되는 지 궁금한 문서 번호
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++)// 노드룰(문서번호와 우선순위) 큐에 삽입
			que.add(new Node(i, Integer.parseInt(input[i])));
	}

}