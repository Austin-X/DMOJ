import java.io.*;
import java.util.*;

public class Wand {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		boolean[] works = new boolean[n + 1];

		for (int i = 0; i < m; i ++) {
			int x = readInt(), y = readInt();
			adj[y].add(x);
		}
		
		boolean[] vis = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int x : adj[cur]) {
				if (!vis[x]) { vis[x] = true; q.add(x); works[x] = true; }
			}
		}
		boolean flag = true;
		for (int i = 1; i <= n; i ++) if (works[i]) { flag = false; break; }
		if (!flag) for (int i = 1; i <= n; i ++) System.out.print(works[i] ? 1 : 0);
		else { System.out.print(1); for (int i = 2; i <= n; i ++) System.out.print(0); }
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
