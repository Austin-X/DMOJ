import java.io.*;
import java.util.*;

public class CourseRequirements {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		int[] freq = new int[n + 1];
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		
		boolean[] vis = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i ++) {
			int c = readInt();
			freq[i] = c;
			if (c == 0) { vis[i] = true; q.add(i); }
			for (int j = 0; j < c; j ++) adj[readInt()].add(i);
		}
		
		int[] ans = new int[n];
		int idx = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			ans[idx++] = cur;
			for (int x: adj[cur]) {
				freq[x] --;
				if (freq[x] == 0) { vis[x] = true; q.add(x); }
			}
		}
		for (int i = 0; i < n; i ++) System.out.print(i == n - 1 ? ans[i] + "\n" : ans[i] + " ");
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
