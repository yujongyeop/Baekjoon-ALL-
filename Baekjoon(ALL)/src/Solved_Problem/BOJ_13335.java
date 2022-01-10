package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_13335 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int w = Integer.parseInt(input[1]);
		int L = Integer.parseInt(input[2]);
		input = br.readLine().split(" ");
		int time = 0;
		int brige_Weight = 0;// 다리 위에 있는 트럭 무게
		for (int i = 0; i < n; i++)// 트럭 무게 큐
			que.add(Integer.parseInt(input[i]));
		for (int i = 0; i < w; i++)
			bridge.add(0);// 다리를 0으로 채움
		while (!bridge.isEmpty()) {// 다리가 비어있을 때 까지
			time++;// 시간을 1 증가
			brige_Weight -= bridge.poll();// 다리의 가장 먼저간 무게를 다리 무게에서 빼줌
			if (!que.isEmpty()) {// 들어올 수 있는 트럭이 남아있을 때
				if (que.peek() + brige_Weight <= L) {// 다리 무게 + 맨 앞 트럭의 무게의 합이 최대하중보다 작거나 같을 때
					brige_Weight += que.peek();// 트럭 무게만큼 다리의 무게 증가
					bridge.offer(que.poll());// 다리에 트럭 추가
				} else {// 최대하중 초과 했을 때
					bridge.offer(0);
				}
			}
		}
		bw.write(time + "");
		bw.flush();
		br.close();
		bw.close();
	}

}
