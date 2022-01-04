package Solved_Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_1068 {
	static int N;
	static ArrayList<Integer>[] list;
	static int del_Node, ans, root;

	static void DFS(int num) {
		for (int i = 0; i < list[num].size(); i++) {
			int tmp = list[num].get(i);
			if (tmp != del_Node)// 삭제할 노드가 아닐 때
				DFS(list[num].get(i));
			else {// 삭제할 노드 일때
				list[num].remove(i);// 노드를 삭제
				i--;// list[num]의 크기가 바뀌어서 1을 뺴줌
			}
		}
		if (list[num].size() == 0)// 리프 노드일 경우
			ans++;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		ans = 0;

		list = new ArrayList[N];// 초기화
		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();

		String[] input = br.readLine().split(" ");// 사용자 값 입력
		for (int i = 0; i < N; i++) {
			if (input[i].equals("-1"))// -1일 경우 root노드 번호 갱신
				root = i;
			else {// 루트노드가 아닐 때
				list[Integer.parseInt(input[i])].add(i);
			}
		}
		del_Node = Integer.parseInt(br.readLine());// 삭제할 노드 번호
		if (del_Node != root)// 루트노드를 삭제하지 않을 경우
			DFS(root);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();

	}

}
