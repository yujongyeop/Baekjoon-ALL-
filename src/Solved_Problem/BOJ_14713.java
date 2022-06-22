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
		Queue<String>[] arr = new Queue[N]; // ť �迭 �ʱ�ȭ
		for (int i = 0; i < N; i++) {// ����� �Է��� ť �迭�� �־���
			arr[i] = new LinkedList<>();
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < input.length; j++)
				arr[i].add(input[j]);
		}

		String[] input = br.readLine().split(" ");// ����
		Queue<String> sentence = new LinkedList<>();
		for (int i = 0; i < input.length; i++)// ������ ť�� �־���
			sentence.add(input[i]);

		boolean is_Possible = false;// ������ �������� üũ

		while (!sentence.isEmpty()) {// ť�� ������� ���� �� �ݺ�
			is_Possible = false;// ���� ���θ� false�� �ٲ���
			String str = sentence.poll();// ť�� ���Ҹ� ��
			for (int i = 0; i < N; i++) {
				if (!arr[i].isEmpty() && arr[i].peek().equals(str)) {// arr[i] ť�� ������� �ʰ� str�� ������
					arr[i].poll();// arr[i]�� ���Ҹ� ��
					is_Possible = true;// ���� ���θ� true�� �ٲ���
					break;
				}
			}
			if (is_Possible != true)// �Ұ����� ������ ��
				break;// while���� ������ ����

		}
		int empty_arr = 0;
		for (int i = 0; i < N; i++)
			if (arr[i].isEmpty())
				empty_arr++;
		if (sentence.isEmpty() && is_Possible == true && empty_arr == N)// ť�� ����ְ� is_Possible�� true, ��� �迭�� ť�� ���������
			System.out.println("Possible");
		else
			System.out.print("Impossible");
	}

}
