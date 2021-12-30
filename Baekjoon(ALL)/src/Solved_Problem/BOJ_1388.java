package Solved_Problem;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1388 {
	static int N, M, ans;
	static String[] map;
	static boolean[][] visit;

	static void DFS(int x, int y) {// (0,0)~(N-1,M-1)까지 탐색
		if (x >= N)// x가 N보다 커지면 모든 DFS를 종료
			return;
		else if (!visit[x][y]) {// (x,y)방문을 하지 않았을 때
			visit[x][y] = true;// (x,y)를 방문 처리
			char c = map[x].charAt(y);// (x,y)의 문자값 저장
			if (c == '-') {// c가 '-'일 때
				while (y + 1 < M && map[x].charAt(y + 1) == c) {// y+1이 M보다 작으면서 c거 (x,y+1)과 같을 때('-'가 연속 될 때)
					y++;// y값 증가(y값을 사용하는 이유는 연산을 줄이기 위해서이다.(dy를 쓸 경우 유의미하지는 할 만큼은 아니지만 재귀가 깊어짐)
					visit[x][y] = true;// (x,y)를 방문 처리
				}
				ans++;
			} else {// c가 '|'일 때
				int dx = x + 1;// c가 '|'일 경우 사용할 x값(x변수를 사용하지 않는 이유는 x를 바꾸게되면 15번 째 줄에도 영향을 줌)
				while (dx < N && map[dx].charAt(y) == c) {// dx가 N보다 작으면서 c가 (dx,y)와 같을 때('|'가 연속될 때)
					visit[dx][y] = true;// (dx,y)를 방문 처리
					dx++;
				}
				ans++;
			}
		}
		if (y == M - 1)// y가 M-1가 같으면 해당 행은 모두 탐색한 것으로 다음줄로 변경
			DFS(x + 1, 0);
		else
			DFS(x, y + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);// N
		M = Integer.parseInt(input[1]);// M
		map = new String[N];// 바닥 모양
		visit = new boolean[N][M];// 방문 여부 저장 배열
		ans = 0; // 정답

		for (int i = 0; i < N; i++)// 사용자 값 입력
			map[i] = br.readLine();
		DFS(0, 0);// DFS호출
		bw.write(ans + "");// 정답 출력
		bw.flush();
		br.close();
		bw.close();
	}
}