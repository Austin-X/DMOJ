import java.io.*;
import java.util.*;

public class PhonomenalReviews {
	static ArrayList<Integer>[] adj, adj2;
	static boolean[] pho;
	static int diameter = 0, endNode, cn = 0;
	static int[] dis;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

		dis = new int[n];
		adj = new ArrayList[n];
		for (int i = 0; i < n; i ++) adj[i] = new ArrayList<Integer>();
		
		pho = new boolean[n];
		int start = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i ++) {
			int x = Integer.parseInt(st.nextToken());
			pho[x] = true;
			start = x;
		}
		
		for (int i = 0; i < n - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}		

		adj2 = new ArrayList[n];
		for (int i = 0; i < n; i ++) adj2[i] = new ArrayList<Integer>();
		dfs (start, -1);
		
		diameterDFS(start, -1);
		
		Arrays.fill(dis, 0); diameter = 0;
		diameterDFS(endNode, -1);

		System.out.println(2 * cn - diameter);
	}
	
	static void dfs (int u, int v) {
		for (int x : adj[u]) {
			if (x == v) continue;
	
			dfs(x, u);
			if (pho[x] || !adj2[x].isEmpty()) {
				adj2[x].add(u); adj2[u].add(x); cn ++;
			}
		}
	}
	
	static void diameterDFS (int cur, int prev) {
		for (int x : adj2[cur]) {
			if (x != prev) {
				dis[x] = dis[cur] + 1;
				if (dis[x] > diameter) {
					diameter = dis[x];
					endNode = x;
				}
				diameterDFS(x, cur);
			}
		}
	}
}
