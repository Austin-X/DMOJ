import java.io.*;
import java.util.*;

public class ConvexHull {
	static class route {
		int island, time, weight;
		
		route (int island, int time, int weight) {
			this.island = island;
			this.time = time;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		ArrayList<route>[] adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<route>();
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			adj[a].add(new route(b, t, h));
			adj[b].add(new route(a, t, h));
		}
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] time = new int[n + 1];
		Arrays.fill(time, Integer.MAX_VALUE);
		time[1] = 0;
		int[] weights = new int[n + 1];
		Arrays.fill(weights, Integer.MAX_VALUE);
		weights[1] = 0;
		 
		int min = Integer.MAX_VALUE;
		Stack<route> s = new Stack<route>();
		s.push(new route(A, 0, 0));
		
		while (!s.empty()) {
			route cur = s.pop();
			
			for (route x : adj[cur.island]) {
				if (cur.weight + x.weight >= k || (cur.weight + x.weight >= weights[x.island] && cur.time + x.time >= time[x.island])) continue;
				if (x.island == B && cur.weight + x.weight < k) {
					min = Math.min(min, cur.time + x.time);
				} else {
					weights[x.island] = Math.min(weights[x.island], cur.weight + x.weight);
					time[x.island] = Math.min(time[x.island], cur.time + x.time);
					s.push(new route(x.island, cur.time + x.time, cur.weight + x.weight));
				}
			}
		}
		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}
}
