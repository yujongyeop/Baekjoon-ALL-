package Solved_Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_15828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> router = new LinkedList<>();
		int bufferSize = Integer.parseInt(br.readLine());
		int num = 0;
		while (!((num = Integer.parseInt(br.readLine())) == -1)) {//num이 -1이 아닐때까지 반복
			if (num == 0)//0일 경우 원소 하나를 빼줌
				router.poll();
			else if (router.size() < bufferSize) {//0이 아니고 router의 크기가 bufferSize보다 작으면 num을 넣어줌
				router.offer(num);
			}
		}
		if (router.isEmpty())//리스트가 비어있을 경우
			System.out.println("empty");
		else {//리스트에 원소가 있는 경우
			while (!router.isEmpty())
				System.out.printf(router.poll() + " ");
		}
	}

}
