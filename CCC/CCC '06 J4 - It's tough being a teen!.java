import java.io.*;
import java.util.*;

public class ItsToughBeingATeen {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[8];
		
		for (int i = 0; i < 8; i ++) adj[i] = new ArrayList<Integer>();
		adj[7].add(1);
		adj[4].add(1);
		adj[1].add(2);
		adj[4].add(3);
		adj[5].add(3);
		
		while (true) {
			int x = Integer.parseInt(br.readLine());
			int y = Integer.parseInt(br.readLine());
			
			if (x == 0 && y == 0) break;
			
			adj[y].add(x);
		}
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		int min = -1;
		for (int i = 1; i < 8; i ++) {
			if (adj[i].isEmpty()) {
				min = i; break;
			}
		}
		
		boolean[] visited = new boolean[8];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(min);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			visited[cur] = true;
			out.add(cur);
			for (int i = 1; i < 8; i ++) {
				for (int j = 0; j < adj[i].size(); j ++) {
					if (adj[i].get(j) == cur) {
						adj[i].remove(j);
					}
				}
			}
			
		    min = -1;
			for (int i = 1; i < 8; i ++) {
				if (!visited[i] && adj[i].isEmpty()) {
					min = i; break;
				}
			}
			
			if (min != -1) queue.add(min);
		}
		
		if (out.size() == 7)
			for (int x : out) System.out.print(x + " ");
		else System.out.println("Cannot complete these tasks. Going to bed.");
	}
}
