import java.io.*;
import java.util.*;

public class EbolaOutbreak {
	static int[] parent, rank;
	
	static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int x, int y) {
		int xRoot = find(x); int yRoot = find(y);
		if (rank[xRoot] > rank[yRoot]) {
			parent[yRoot] = xRoot;
		} else if (rank[xRoot] < rank[yRoot]) {
			parent[xRoot] = yRoot;
		} else {
			parent[xRoot] = yRoot;
			rank[yRoot] ++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 1; i <= n; i ++) parent[i] = i;
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int students = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for (int j = 0; j < students - 1; j ++) {
				int temp = Integer.parseInt(st.nextToken());
				union(x, temp);
				x = temp;
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int cn = 0;
		for (int i = 1; i <= n; i ++) {
			if (find(1) == find(i)) {
				cn ++;
				ans.add(i);
			}
		}
		
		System.out.println(cn);
		for (int x : ans) System.out.print(x + " ");
	}
}
