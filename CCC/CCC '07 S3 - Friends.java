import java.io.*;
import java.util.*;

public class Friends {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[10000];
		
		for (int i = 0; i <= 9999; i ++) adj[i] = new ArrayList<Integer>();
		
		int[] dis = new int[10000];
		Queue<Integer> q;
		boolean[] visited = new boolean[10000];
		
		int x, y;
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
		}
		
		while (true) {
			Arrays.fill(dis, -1);
			Arrays.fill(visited, false);
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if (x == 0 && y == 0) break;
			
			q = new LinkedList<Integer>();
			q.add(x);
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				
				for (int a : adj[cur]) {
					if (!visited[a]) {
						q.add(a); visited[a] = true;
						dis[a] = dis[cur] + 1;
					}
				}
			}
			
			if (visited[y]) {
				System.out.println("Yes " + dis[y]);
			} else System.out.println("No");
		}
	}
}
