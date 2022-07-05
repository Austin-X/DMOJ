import java.io.*;
import java.util.*;

public class BreadMerchant {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] p = new int[n + 1], outdegree = new int[n + 1];
		for (int i = 1; i <= n; i ++) p[i] = readInt();
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; i ++) {
			int a = readInt(), b = readInt();
			adj[b].add(a);
			outdegree[a] ++;
		}
		
		boolean[] vis = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i ++) if (outdegree[i] == 0) { vis[i] = true; q.add(i); }

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int x: adj[cur]) {
				if (!vis[x]) {
					if (p[x] == 1) { vis[x] = true; q.add(x); }
					else {
						outdegree[x] --;
						if (outdegree[x] == 0) { vis[x] = true; q.add(x); }
					}
				}
			}
		}
		
		for (int i = 1; i < n; i ++) System.out.print(vis[i] ? 1 + " " : 0 + " ");
		System.out.println(vis[n] ? 1 : 0);
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
