import java.io.*;
import java.util.*;

public class TruckingTroubles {
	static class Node {
		int city, weight;
		Node (int city, int weight) {
			this.city = city;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[] weights = new int[c + 1];
		@SuppressWarnings("unchecked")
		ArrayList<Node>[] adj = new ArrayList[c + 1];
		for (int i = 1; i <= c; i ++) adj[i] = new ArrayList<Node>();
		
		for (int i = 0; i < r; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[x].add(new Node(y, w));
			adj[y].add(new Node(x, w));
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(1, Integer.MAX_VALUE));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (Node x : adj[cur.city]) {
				if (Math.min(cur.weight, x.weight) > weights[x.city]) {
					weights[x.city] = Math.min(cur.weight, x.weight);
					q.add(x);
				}
			}
		}
		
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < d; i ++) max = Math.min(max, weights[Integer.parseInt(br.readLine())]);
		System.out.println(max);
	}
}
