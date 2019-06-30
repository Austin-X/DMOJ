import java.io.*;
import java.util.*;

public class AnimeConventions {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) parent[i] = i;
		
		for (int i = 0; i < q; i++) {
			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[1]);
			int y = Integer.parseInt(temp[2]);
			
			if (temp[0].equals("A")) {
				union(x, y);
			}
			else {
				if (find (x) == find (y)) System.out.println("Y");
				else System.out.println("N");
			}
			System.out.println(Arrays.toString(parent));
		}
	}
	
	// Returns representative of x's set
	static int find(int x) {
		// Finds the representative of the set that x is an element of
		if (parent[x] != x) {
			// If x is not the parent of itself, then x is not the representative of the set
			parent[x] = find(parent[x]);
		}
		
		// So we recursively call find on its parent and move i's node directly under the representative of this set
		return parent[x];
	}
	
	static void union (int u, int v) {
		int x = find(u);
		int y = find(v);
		parent[x] = y;
	}
}
