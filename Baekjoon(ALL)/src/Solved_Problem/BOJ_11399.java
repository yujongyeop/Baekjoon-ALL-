package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_11399 {
	/*
	 * �Է¹��� ���� ������������ ����(�⺻ ���̺귯�� ���)�� �� �� �ð��� ���� ���� temp�� �����ϰ� ans�� temp�� �����ش�.
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(input[i]);
		Arrays.sort(arr);
		int ans = 0, temp = 0;
		for (int M : arr) {
			temp += M;
			ans += temp;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
