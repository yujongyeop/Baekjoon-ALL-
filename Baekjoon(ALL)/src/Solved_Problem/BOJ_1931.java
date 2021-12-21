	package Solved_Problem;
	
	import java.util.Arrays;
	import java.util.Comparator;
	import java.util.Scanner;
	
	public class BOJ_1931 {
		/*
		 * ����: �׸���, ����
		 * ���� Ǯ��: �⺻������ ����ð��� ���� ������ �����Ѵ�(��, ����ð��� ���ٸ� ���۽ð��� ���� ������ ����)
		 * �̴� �տ� ������ ȸ�ǰ� ������ �� �ٷ� �ڿ� �̵��� ȸ�Ǹ� �����Ͽ� �ִ��� ���� ȸ�Ǹ� �� �� �ִ� ����� ���̴�.
		 */
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int[][] time = new int[N][2];// [N][0]�� ���� �ð�, [N][1]�� ���� �ð�
			for (int i = 0; i < N; i++) {
				time[i][0] = sc.nextInt();
				time[i][1] = sc.nextInt();
			}
			sc.close();
			Arrays.sort(time, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// ����ð��� ���ٸ� ���۽ð��� ���������� ����
					return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
				}	
			});
			int ans = 0, prev_end_time = 0;
			for (int i = 0; i < N; i++) {
				if (prev_end_time <= time[i][0]) {// ���� ȸ���� ����ð����� �ð��� ũ�ų� ���� ��
					prev_end_time = time[i][1];
					ans++;
				}
			}
			System.out.println(ans);
		}
	
	}
