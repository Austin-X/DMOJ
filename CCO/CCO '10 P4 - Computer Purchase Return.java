import java.io.*;
import java.util.*;

public class ComputerPurchaseReturn {
	static class component implements Comparable<component> {
		int cost, value;
		component (int c, int v) {
			cost = c;
			value = v;
		}
		
		public int compareTo(component c) {
			return Integer.compare(cost, c.cost);
		}
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		ArrayList<component>[] adj = new ArrayList[t + 1];
		for (int i = 1; i <= t; i ++) adj[i] = new ArrayList<component>();
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			int type = Integer.parseInt(st.nextToken());
			adj[type].add(new component(cost, value));
		}
		
		int b = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= t; i ++) Collections.sort(adj[i]);
		
		int[][] dp = new int[t + 1][b + 1];
		for (int[] x : dp) Arrays.fill(x, Integer.MAX_VALUE);
		
		boolean flag = true;
		outerloop: for (int i = 1; i <= t; i ++) {
			for (int j = 0; j < adj[i].size(); j ++) {
				if (adj[i].isEmpty()) { flag = false; break outerloop; }
				else if (i == 1) { dp[i][adj[i].get(j).cost] = adj[i].get(j).value; }
				else {
					for (int k = 1; k <= b - adj[i].get(j).cost; k ++) {
						if (dp[i - 1][k] != Integer.MAX_VALUE) {
							if (dp[i][k + adj[i].get(j).cost] != Integer.MAX_VALUE) dp[i][k + adj[i].get(j).cost] = Math.max(dp[i][k + adj[i].get(j).cost], dp[i - 1][k] + adj[i].get(j).value);
							else dp[i][k + adj[i].get(j).cost] = dp[i - 1][k] + adj[i].get(j).value;
						}
					}
				}
			}
		}
		
		int min = 0;
		for (int i = 1; i <= b; i ++) if (dp[t][i] != Integer.MAX_VALUE) min = Math.max(min, dp[t][i]);
		System.out.println(min != 0 && flag ? min : -1);
	}
}
