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
		while (!((num = Integer.parseInt(br.readLine())) == -1)) {//num�� -1�� �ƴҶ����� �ݺ�
			if (num == 0)//0�� ��� ���� �ϳ��� ����
				router.poll();
			else if (router.size() < bufferSize) {//0�� �ƴϰ� router�� ũ�Ⱑ bufferSize���� ������ num�� �־���
				router.offer(num);
			}
		}
		if (router.isEmpty())//����Ʈ�� ������� ���
			System.out.println("empty");
		else {//����Ʈ�� ���Ұ� �ִ� ���
			while (!router.isEmpty())
				System.out.printf(router.poll() + " ");
		}
	}

}
