import java.io.*;
import java.util.*;

public class DisjointSetTest {
	static int[] parent, rank;
	static ArrayList<Integer> out = new ArrayList<Integer>();
	
	static int find(int x) {
		if (parent[x] != x) return find(parent[x]);
		return parent[x];
	}
	
	static void union(int x, int y, int idx) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if (xRoot == yRoot) return;
		
		if (rank[xRoot] < rank[yRoot]) parent[xRoot] = yRoot;
		else if (rank[xRoot] > rank[yRoot]) parent[yRoot] = xRoot;
		else {
			parent[xRoot] = yRoot;
			rank[yRoot] ++;
		}
		
		out.add(idx);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		for (int i = 1; i <= n; i ++) parent[i] = i;
		rank = new int[n + 1];

		for (int i = 1; i <= m; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			union(x, y, i);
		}

		if (out.size() == n - 1) for (int x : out) System.out.println(x);
		else System.out.println("Disconnected Graph");
	}
}
