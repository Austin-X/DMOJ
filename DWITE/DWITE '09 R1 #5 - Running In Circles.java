import java.io.*;
import java.util.*;

public class RunningInCircles {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int a = 0; a < 5; a ++) {
			int n = Integer.parseInt(br.readLine());
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] adj = new ArrayList[101];
			
			for (int i = 0; i < 101; i ++) adj[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < n; i ++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				adj[x].add(y);
			}
			
			
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(1);
			boolean[] visited = new boolean[101];
			visited[1] = true;
			int cycleSize = 0;
		
			// Performing dfs
			while (!stack.isEmpty()) {
				int cur = stack.pop();
				for (int x : adj[cur]) {
					if (x == 1) {
						cycleSize ++;
						stack.clear(); break;
					}
					else if (!visited[x] && cur == 1) {
						visited[x] = true;
						stack.push(x);
						cycleSize = 1;
					} else if (!visited[x]) {
						visited[x] = true;
						stack.push(x);
						cycleSize ++;
					}
				}
			}
			
			System.out.println(cycleSize);
		}
	}
}
