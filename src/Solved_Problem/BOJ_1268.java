package Solved_Problem;

import java.util.Scanner;

public class BOJ_1268 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[][] = new int[num][5];

//		사용자 입력
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();

//		서로 같은 반일 경우 경우 result에 1로 바꿈
		int result[][] = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 5; j++) {
				int n = arr[i][j];
				for (int k = 0; k < num; k++) {
					if (arr[k][j] == n && k != i) {
						result[i][k] = 1;
					}
				}
			}
		}
		
//		res: 결과(모두 다른 반일때 1을 출력)
		int res = 1;
//		cnt: res번째 학생과 같은 반인 학생의 수
		int cnt = 0;
//		result 배열에서 i행에 값이 1인 원소의 개수를 카운팅함
		for (int i = 0; i < num; i++) {
			int temp = 0;
			for (int j = 0; j < num; j++) {
				if (result[i][j] == 1)
					temp++;
			}
			if (temp > cnt) {
				res = i + 1;
				cnt = temp;
			}
		}
//		결과출력
		System.out.println(res);

	}
}
