import java.io.*;
import java.util.*;

public class DegreesOfSeparation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[50];
		
		for (int i = 0; i <= 49; i ++) adj[i] = new ArrayList<Integer>();
		adj[1].add(6); 
		adj[2].add(6); 
		adj[3].add(6); adj[3].add(4); adj[3].add(5); adj[3].add(15);
		adj[4].add(3); adj[4].add(5); adj[4].add(6);
		adj[5].add(3); adj[5].add(4); adj[5].add(6);
		adj[6].add(1); adj[6].add(2); adj[6].add(3); adj[6].add(4); adj[6].add(5); adj[6].add(7); 
		adj[7].add(6); adj[7].add(8);
		adj[8].add(7); adj[8].add(9); 
		adj[9].add(8); adj[9].add(10); adj[9].add(12);
		adj[10].add(9); adj[10].add(11);
		adj[11].add(10); adj[11].add(12);
		adj[12].add(9); adj[12].add(11); adj[12].add(13);
		adj[13].add(12); adj[13].add(15); adj[13].add(14);
		adj[14].add(13);
		adj[15].add(3); adj[15].add(13);
		adj[16].add(17); adj[16].add(18);
		adj[17].add(16); adj[17].add(18);
		adj[18].add(16); adj[18].add(17);
		
		int[] dis = new int[50];
		boolean[] visited = new boolean[50];
		ArrayList<Integer> friends, cannotBe;
		Queue<Integer> q;
		char choice = ' ';
		int x, y, cn;
		while (choice != 'q') {
			choice = br.readLine().charAt(0);
			
			if (choice == 'i') {
				x = Integer.parseInt(br.readLine());
				y = Integer.parseInt(br.readLine());
				adj[x].add(y);
				adj[y].add(x);
			} else if (choice == 'd') {
				x = Integer.parseInt(br.readLine());
				y = Integer.parseInt(br.readLine());
				adj[x].remove(adj[x].indexOf(y));
				adj[y].remove(adj[y].indexOf(x));
			} else if (choice == 'n') {
				x = Integer.parseInt(br.readLine());
				System.out.println(adj[x].size());
			} else if (choice == 'f') {
				x = Integer.parseInt(br.readLine());
				cn = 0;
				friends = new ArrayList<Integer>();
				cannotBe = new ArrayList<Integer>();
				cannotBe.add(x);
				for (int a : adj[x]) {
					friends.add(a); 
					cannotBe.add(a);
				}
				
				for (int i = 0; i < friends.size(); i ++) {
					for (int k : adj[friends.get(i)]) {
						if (!cannotBe.contains(k)) {
							cn ++; cannotBe.add(k);
						}
					}
				}

				System.out.println(cn);
			} else if (choice == 's') {
				Arrays.fill(dis, 0);
				Arrays.fill(visited, false);
				x = Integer.parseInt(br.readLine());
				y = Integer.parseInt(br.readLine());
				q = new LinkedList<Integer>();
				
				q.add(x);
				visited[x] = true;
				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int f : adj[cur]) {
						if (!visited[f]) {
							q.add(f);
							visited[f] = true;
							dis[f] = dis[cur] + 1;
						}
					}
				}
				System.out.println(dis[y] != 0 ? dis[y] : "Not connected");
			}
		}
	}
}
