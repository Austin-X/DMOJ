import java.io.*;
import java.util.*;

public class IsItATree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean tree = true;
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[5];
		
		for (int i = 0; i < 5; i ++) adj[i] = new ArrayList<Integer>();
		for (int i = 1; i <= 4; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 4; j ++) {
				if (Integer.parseInt(st.nextToken()) == 1) adj[i].add(j);
			}
		}

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		boolean[] visited = new boolean[5];
		visited[1] = true;
		int[] parent = new int[5]; 
		
		while (!stack.empty()) {
			int cur = stack.pop();
			for (int x : adj[cur]) {
				if (!visited[x]) {
					visited[x] = true;
					stack.push(x);
					parent[x] = cur;
				} else if (parent[cur] != x) {
					tree = false; stack.clear(); break;
				}
			}
		}
		
		for (int i = 1; i <= 4; i ++) {
			if (!visited[i]) {
				tree = false; break;
			}
		}
		
		System.out.println(tree ? "Yes" : "No");
	}
}
