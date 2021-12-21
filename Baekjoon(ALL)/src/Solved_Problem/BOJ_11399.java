package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_11399 {
	/*
	 * 입력받은 값을 오름차순으로 정렬(기본 라이브러리 사용)한 후 각 시간을 더한 값을 temp에 저장하고 ans에 temp를 더해준다.
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
