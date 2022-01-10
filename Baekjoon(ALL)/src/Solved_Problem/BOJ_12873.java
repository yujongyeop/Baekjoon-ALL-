package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12873 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> que = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());// 총 인원
		long tmp = 0;
		for (int i = 1; i < N + 1; i++)
			que.add(i);
		for (int i = 1; i < N; i++) {
			tmp = (long) Math.pow(i, 3) % que.size();// i의 세제곱을 que의 크기로 나눈 나머지 값
			if (tmp == 0)// 나머지가 없는 경우 tmp의 위치를 que 마지막 원소로 설정
				tmp = que.size();
			for (int j = 0; j < tmp - 1; j++)// tmp 번째 원소를 맨 앞으로 보냄
				que.add(que.poll());
			que.poll();// 원소 삭제
		}
		bw.write(que.poll() + "");// 기념품을 받는 사람 출력
		bw.flush();
		bw.close();
		br.close();
	}

}
