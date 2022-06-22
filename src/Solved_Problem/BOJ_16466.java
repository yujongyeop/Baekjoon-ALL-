package Solved_Problem;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16466 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		sc.close();
		Arrays.sort(arr);// 정렬
		int ans = 1;
		for (int i = 0; i < N; i++) {
			if (ans != arr[i])// 값이 같지 않으면 그 수가 최소값이다
				break;
			else {
				for (int j = i + 1; j < N; j++)// 중복값 제거
					if (arr[i] != arr[j])// 중복값이 없을 떼
						break;
					else// 중복값일때
						i = j;
			}
			ans++;
		}
		System.out.println(ans);
	}

}
