import java.io.*;
import java.util.*;

public class IsItATree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[5];
		for (int i = 0; i < 5; i ++) adj[i] = new ArrayList<Integer>();
		
		for (int i = 1; i <= 4; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 4; j ++) {
				if (Integer.parseInt(st.nextToken()) == 1) adj[i].add(j);
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		boolean[] visited = new boolean[5];
		visited[1] = true;
		int[] parent = new int[5];
		Arrays.fill(parent, -1);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
		
			for (int x : adj[cur]) {
				if (!visited[x]) {
					visited[x] = true;
					queue.add(x);
					parent[x] = cur;
				} else if (parent[cur] != x) {
					System.out.println("No"); System.exit(0);
				}
			}
		}

		for (int i = 1; i <= 4; i ++) {
			if (!visited[i]) {
				System.out.println("No"); System.exit(0);
			}
		}
		
		System.out.println("Yes");
	}
}
