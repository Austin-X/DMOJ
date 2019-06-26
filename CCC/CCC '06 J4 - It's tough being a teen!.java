import java.io.*;
import java.util.*;

public class ItsToughBeingATeen {
	static int getMinValue(ArrayList<Integer>[] adj, boolean[] visited) {
		int min = -1; boolean contains;
		for (int i = 1; i <= 7; i ++) {
			contains = false;
			for (int j = 1; j <= 7; j ++) {
				if (!adj[j].contains(i)) {
					contains = true;
				} else {
					contains = false; break;
				}
			}
			if (contains && !visited[i]) {
				min = i; break;
			}
		}
		
		return min;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] visited = new boolean[8];
		ArrayList<Integer> out = new ArrayList<Integer>();
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[8];
		for (int i = 0; i < 8; i ++) adj[i] = new ArrayList<Integer>();
		
		// This means that chore number 1 comes before chore number 7
		adj[1].add(7);
		adj[1].add(4);
		adj[2].add(1);
		adj[3].add(4);
		adj[3].add(5);
		
		while (true) {
			int x = Integer.parseInt(br.readLine());
			int y = Integer.parseInt(br.readLine());
			
			if (x == 0 && y == 0) break;
			adj[x].add(y);
		}
		
		int min = getMinValue(adj, visited);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(min);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			out.add(cur);
			visited[cur] = true;
			
			for (int i = 0; i < adj[cur].size();) {
				adj[cur].remove(i);
			}

		    min = getMinValue(adj, visited);
		    
		    if (min != -1) queue.add(min);
		}
		
		if (out.size() == 7) {
			for (int x : out) System.out.print(x + " ");
		} else System.out.println("Cannot complete these tasks. Going to bed.");
	}
}
