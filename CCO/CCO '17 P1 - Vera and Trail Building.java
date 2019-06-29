import java.io.*;
import java.util.*;

public class VeraAndTrailBuilding {
	public static class Edge {
		int x, y;
		Edge(int x, int y) {
			this.x = x; 
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		ArrayList<Edge> trails = new ArrayList<Edge>();
		
		int k = Integer.parseInt(br.readLine());
		int cn = 0, lower, upper, vertices, edges;
		
		// 'i' represents the vertices
		for (int i = 5001; i > 1; i --) {
			while (i * (i - 1) / 2 <= k) {
				lower = cn + 1;
				if (cn > 0) trails.add(new Edge(cn, lower));
				upper = cn + i;
				
				for (int j = lower; j < upper; j ++) {
					trails.add(new Edge(j, j + 1));
				}
				cn = upper;
				trails.add(new Edge(upper, lower));
				k -= i * (i - 1) / 2;
			}
		}
		
		vertices = cn; edges = trails.size();
		System.out.println(vertices + " " + edges);
		for (Edge e : trails) System.out.println(e.x + " " + e.y);
	}
}
