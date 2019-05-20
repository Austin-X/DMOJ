import java.util.*;

public class CanShahirEvenGetThere {
	static int vertices, edges, a, b;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vertices = sc.nextInt();
		edges = sc.nextInt();
		a = sc.nextInt() - 1;
		b = sc.nextInt() - 1;
		visited = new boolean[vertices];
		
		for (int i = 0; i < vertices; i ++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edges; i ++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
		
		if (dfs(a)) System.out.println("GO SHAHIR!");
		else System.out.println("NO SHAHIR!");
	}
	
	static boolean dfs(int u) {
		visited[u] = true;
		if (b == u) {
			return true;
		}
		for (int x : adj.get(u)) {
			if (!visited[x] && dfs(x)) {
				return true;
			}
		}
		return false;
	}
}
