import java.util.*;

public class CanShahirEvenGetThere {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		Queue <Integer> queue = new LinkedList<Integer>();
		
		// Visited boolean array defaults to false, adjency matrix defaults to 0
		boolean[] visited = new boolean[n + 1];
		int adj[][]  = new int[n + 1][n + 1];
		
		for (int i = 0; i < m; i ++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// Undirected graph so it is symmetrical
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
		
		queue.add(a);
		visited[a] = true;
		
		// Performing bfs
		while(!queue.isEmpty()) {
			int value = queue.poll();
			for (int i = 1; i <= n; i ++) {
				if (!visited[i] && adj[value][i] == 1) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
		if (visited[b]) System.out.println("GO SHAHIR!");
		else System.out.println("NO SHAHIR!");
	}
}
