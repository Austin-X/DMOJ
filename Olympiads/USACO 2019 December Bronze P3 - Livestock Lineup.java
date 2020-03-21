import java.io.*;
import java.util.*;

public class LivestockLineup {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        
		String[] temp = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
		ArrayList<String> order = new ArrayList<String>();
		for (String x : temp) order.add(x);
		
		@SuppressWarnings("unchecked")
		ArrayList<String>[] adj = new ArrayList[8];
		for (int i = 0; i < 8; i ++) adj[i] = new ArrayList<String>();
		
		for (int t = 0; t < n; t ++) {
			String[] parts = br.readLine().split(" ");
			String cow1 = parts[0], cow2 = parts[5];
			adj[order.indexOf(cow1)].add(cow2);
			adj[order.indexOf(cow2)].add(cow1);
		}	
		boolean[] vis = new boolean[8];

		while (true) {
			String str = "z";
			int idx = -1;
			
			for (int i = 7; i >= 0; i--) {
				if (!vis[i] && adj[i].size() < 2) {
					str = temp[i]; idx = i;
				}
			}
			if (idx == -1) break;
			
			System.out.println(str);
			vis[idx] = true;
			for (int i = 0; i < 8; i ++) {
				if (adj[i].contains(str)) adj[i].remove(adj[i].indexOf(str));
			}
			
			while (!adj[idx].isEmpty()) {
				str = adj[idx].get(0);
				System.out.println(str); vis[order.indexOf(str)] = true; idx = order.indexOf(str);
				
				for (int i = 0; i < 8; i ++) {
					if (adj[i].contains(str)) adj[i].remove(adj[i].indexOf(str));
				}
			}
		}
	}
}
