import java.io.*;
import java.util.*;

public class WhoIsTaller {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		
		for (int i = 0; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[y].add(x);
		}
		
		st = new StringTokenizer(br.readLine());
		int taller = Integer.parseInt(st.nextToken());
		int shorter = Integer.parseInt(st.nextToken());
		
		boolean isTaller = false;
		boolean allVisited = false;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(shorter);
		boolean[] visited = new boolean[n + 1];
		visited[shorter] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (int x : adj[cur]) {
				if (x == taller) {
					allVisited = true;
					isTaller = true; queue.clear(); break;
				}
				else if (!visited[x]) {
					visited[x] = true;
					queue.add(x);
				}
			}
		}
		if (!allVisited) {
			Arrays.fill(visited, false);
			queue.add(taller);
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				for (int x : adj[cur]) {
					if (x == shorter) {
						allVisited = true;
						queue.clear(); break;
					}
					else if (!visited[x]) {
						visited[x] = true;
						queue.add(x);
					}
				}
			}
		}
		
		if (isTaller && allVisited) System.out.println("yes");
		else if (!isTaller && allVisited) System.out.println("no");
		else System.out.println("unknown");
	}
}
