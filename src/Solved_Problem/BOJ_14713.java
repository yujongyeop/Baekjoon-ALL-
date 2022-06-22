package Solved_Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14713 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<String>[] arr = new Queue[N]; // 큐 배열 초기화
		for (int i = 0; i < N; i++) {// 사용자 입력을 큐 배열에 넣어줌
			arr[i] = new LinkedList<>();
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < input.length; j++)
				arr[i].add(input[j]);
		}

		String[] input = br.readLine().split(" ");// 문장
		Queue<String> sentence = new LinkedList<>();
		for (int i = 0; i < input.length; i++)// 문장을 큐에 넣어줌
			sentence.add(input[i]);

		boolean is_Possible = false;// 문장이 가능한지 체크

		while (!sentence.isEmpty()) {// 큐가 비어있지 않을 때 반복
			is_Possible = false;// 가능 여부를 false로 바꿔줌
			String str = sentence.poll();// 큐의 원소를 뺌
			for (int i = 0; i < N; i++) {
				if (!arr[i].isEmpty() && arr[i].peek().equals(str)) {// arr[i] 큐가 비어있지 않고 str과 같으면
					arr[i].poll();// arr[i]의 원소를 뺌
					is_Possible = true;// 가능 여부를 true로 바꿔줌
					break;
				}
			}
			if (is_Possible != true)// 불가능한 문장일 때
				break;// while문을 강제로 멈춤

		}
		int empty_arr = 0;
		for (int i = 0; i < N; i++)
			if (arr[i].isEmpty())
				empty_arr++;
		if (sentence.isEmpty() && is_Possible == true && empty_arr == N)// 큐가 비어있고 is_Possible이 true, 모든 배열의 큐가 비어있을때
			System.out.println("Possible");
		else
			System.out.print("Impossible");
	}

}
