import java.io.*;
import java.util.*;

public class ANoisyClass {
	static Stack<Integer> stack = new Stack<Integer>();
	static ArrayList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			adj[i] = new ArrayList<Integer>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int noisy = Integer.parseInt(st.nextToken());
			int distracted = Integer.parseInt(st.nextToken());
			adj[noisy].add(distracted);
		}
	
		for (int i = 1; i <= n; i++) {
			dfs(i);
		}

		System.out.println("Y");
	}
	
	static void dfs(int cur) {
		if (stack.contains(cur)) {
			System.out.println("N");
			System.exit(0);
		}
		stack.push(cur);
		
		for (int x : adj[cur]) {
			dfs(x);
		}
		stack.pop();
	}
}
