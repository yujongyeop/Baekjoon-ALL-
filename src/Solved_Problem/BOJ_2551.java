package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2551 {
	static boolean[][] visit = new boolean[201][201];
	static boolean[] ans = new boolean[201];
	static int A, B, C;

	static void DFS(int va, int vb, int vc) {
		if (visit[va][vb])
			return;
		if (va == 0)// A물통이 비어있을 때
			ans[vc] = true;// C물통의 물의양을 저장
		visit[va][vb] = true;

		// A -> B
		if (va + vb > B)// A물통의 물과 B물통의 물의 햡이 B물통보다 클 경우(즉,A물통에 물을 부었는데 A물통에 물이 남아있는 경우)
			DFS((va + vb) - B, B, vc);
		else// A물통과 B물통 물을 B물통에 담을 수 있을 때
			DFS(0, va + vb, vc);
		// B -> A
		if (va + vb > A)
			DFS(A, (va + vb) - A, vc);
		else
			DFS(vb + va, 0, vc);
		// C -> A
		if (vc + va > A)
			DFS(A, vb, (vc + va) - A);
		else
			DFS(vc + va, vb, 0);
		// C -> B
		if (vc + vb > B)
			DFS(va, B, (vc + vb) - B);
		else
			DFS(va, vc + vb, 0);
		// B -> c
		DFS(va, 0, vb + vc);
		// A -> C
		DFS(0, vb, va + vc);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		A = Integer.parseInt(input[0]);// A,B,C
		B = Integer.parseInt(input[1]);
		C = Integer.parseInt(input[2]);
		DFS(0, 0, C);// 초기상태
		for (int i = 0; i < 201; i++)
			if (ans[i])
				sb.append(i + " ");
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
