import java.util.*;
import java.io.*;

public class Molekule {
	static int[] values;
	static ArrayList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		values = new int[n + 1];
		Arrays.fill(values, -1);
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		int[] ans = new int[n - 1];
		
		for (int i = 0; i < n - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
			ans[i] = b;
		}
		
		dfs(1, 0, 0);
		
		for (int i = 0; i < n - 1; i ++) System.out.println(values[ans[i]]);
	}

	static void dfs (int cur, int prev, int val) {
		values[cur] = val;
		for (int x : adj[cur]) {
			if (x != prev) {
				if (val == 0) dfs(x, cur, 1);
				else dfs(x, cur, 0);
			}
		}
	}
}
