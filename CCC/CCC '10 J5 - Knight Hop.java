import java.io.*;
import java.util.*;

public class KnightHop {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int startX = Integer.parseInt(st.nextToken()), startY = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int endX = Integer.parseInt(st.nextToken()), endY = Integer.parseInt(st.nextToken());
		
		int[][] adj = new int[9][9];
		
		adj[startX][startY] = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startX); queue.add(startY);
		
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			
			if (x == endX && y == endY) break;
			
			if (x - 2 > 0 && y - 1 > 0) { queue.add(x - 2); queue.add(y - 1); adj[x - 2][y - 1] = adj[x][y] + 1; }
			if (x - 2 > 0 && y + 1 < 9) { queue.add(x - 2); queue.add(y + 1); adj[x - 2][y + 1] = adj[x][y] + 1; }
			if (x - 1 > 0 && y - 2 > 0) { queue.add(x - 1); queue.add(y - 2); adj[x - 1][y - 2] = adj[x][y] + 1; }
			if (x - 1 > 0 && y + 2 < 9) { queue.add(x - 1); queue.add(y + 2); adj[x - 1][y + 2] = adj[x][y] + 1; }
			if (x + 1 < 9 && y - 2 > 0) { queue.add(x + 1); queue.add(y - 2); adj[x + 1][y - 2] = adj[x][y] + 1; }
			if (x + 1 < 9 && y + 2 < 9) { queue.add(x + 1); queue.add(y + 2); adj[x + 1][y + 2] = adj[x][y] + 1; }
			if (x + 2 < 9 && y - 1 > 0) { queue.add(x + 2); queue.add(y - 1); adj[x + 2][y - 1] = adj[x][y] + 1; }
			if (x + 2 < 9 && y + 1 < 9) { queue.add(x + 2); queue.add(y + 1); adj[x + 2][y + 1] = adj[x][y] + 1; }
		}
		System.out.println(adj[endX][endY]);
	}
}
