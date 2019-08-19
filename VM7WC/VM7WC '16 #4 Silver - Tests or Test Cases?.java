import java.io.*;
import java.util.*;

public class TestsOrTestCases {
	static ArrayList<Character>[] adj;
	static int n, l;
	static ArrayList<String> ans = new ArrayList<String>();
	static String cur;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Character>();
		
		for (int i = 1; i <= n; i ++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < m; j ++) adj[i].add(st.nextToken().charAt(0));
		}
		
		for (int a = 0; a < adj[1].size(); a ++) {
			cur = Character.toString(adj[1].get(a));
			ans.add(cur);
			for (int i = 2; i <= n; i ++) {
				for (int j = 0; j < adj[i].size(); j ++) {
					recurse(i + 1, cur + Character.toString(adj[i].get(j)));
				}
			}
		}
		
		Collections.sort(ans);
		for (String x : ans) System.out.println(x);
	}
	
	static void recurse(int idx, String s) {
		if (s.length() <= l) ans.add(s);
		else return;
		
		for (int i = idx; i <= n; i ++) {
			for (int j = 0; j < adj[i].size(); j ++) {
				recurse(i + 1, s + adj[i].get(j));
			}
		}
	}
}
