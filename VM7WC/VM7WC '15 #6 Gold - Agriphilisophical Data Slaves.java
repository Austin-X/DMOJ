import java.io.*;
import java.util.*;

public class AgriphilisophicalDataSlaves {
	static int[] cn, characters;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static Stack<Integer> arr = new Stack<Integer>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		cn = new int[n + 1];
		visited = new boolean[n + 1];

		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < n - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
		}
		
		characters = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i ++) {
			characters[i] = Integer.parseInt(st.nextToken());
			cn[i] = characters[i];
		}
		
		for (int i = 1; i <= n; i ++) {
			if (!visited[i]) recurse(i); 
		}
		
		int max = -Integer.MAX_VALUE;
		for (int i = 1; i <= n; i ++) max = Math.max(max, cn[i]);
		System.out.println(max);
	}
	
	static void recurse(int x) {
		visited[x] = true;
		arr.push(x);
		for (int u : adj[x]) {
			if (!visited[u]) {
				recurse(u);
				for (int i : arr) cn[i] += characters[u];
			}
		}
		arr.pop();
	}
}
