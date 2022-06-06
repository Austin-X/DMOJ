import java.io.*;
import java.util.*;

public class WorkExperience {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static ArrayList<Integer>[] adj;
	static long[] freq;
	static boolean[] vis;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < n - 1; i ++) {
			int x = readInt(), y = readInt();
			adj[x].add(y); adj[y].add(x);
		}
		
		freq = new long[n + 1];
		vis = new boolean[n + 1];
		dfs(1);
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		vis = new boolean[n + 1];
		vis[1] = true;
		
		long[] out = new long[n + 1];
		while (!q.isEmpty()) {
			long ans = 1;
			ans += (n - 1) * 3;
			int cur = q.poll();
			
			long sum = 0, temp = 0, squares = 0, cubes = 0;
			for (int x: adj[cur]) {
				if (!vis[x]) { 
					q.add(x);
					vis[x] = true;
					sum += freq[x];
					squares += freq[x] * freq[x];
					cubes += freq[x] * freq[x] * freq[x];
				} else {
					long val = freq[1] - freq[cur];
					sum += val;
					squares += val * val;
					cubes += val * val * val;
				}
			}
			temp = sum * sum - squares;
			ans += temp * 3;
			ans += sum * temp - 2 * squares * sum + 2 * cubes;
			out[cur] = ans;
		}

		for (int i = 1; i <= n; i ++) System.out.print(out[i] + " ");
		System.out.println();
	}

	static void dfs(int u) {
		vis[u] = true;
		long cnt = 1;
		for (int x: adj[u]) {
			if (!vis[x]) {
				dfs(x);
				cnt += freq[x];
			}
		}
		freq[u] = cnt;
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
