import java.io.*;
import java.util.*;

public class RatInAMaze {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] maze = new int[n][n];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean cheese = false;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[][] visited = new boolean[n][n];
		q.add(0);
		q.add(0);
		visited[0][0] = true;
		
		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			
			if (x > 0 && !visited[x - 1][y] && maze[x - 1][y] == 0) { q.add(x - 1); q.add(y); visited[x - 1][y] = true; }
			if (x < n - 1 && !visited[x + 1][y] && maze[x + 1][y] == 0) { q.add(x + 1); q.add(y); visited[x + 1][y] = true; }
			if (y > 0 && !visited[x][y - 1] && maze[x][y - 1] == 0) { q.add(x); q.add(y - 1); visited[x][y - 1] = true; }
			if (y < n - 1 && !visited[x][y + 1] && maze[x][y + 1] == 0) { q.add(x); q.add(y + 1); visited[x][y + 1] = true; }
		}
		
		System.out.println(visited[n - 1][n - 1] ? "yes" : "no");
	}
	
	static void printMaze(int[][] maze) {
		for (int i = 0; i < maze.length; i ++) {
			for (int j = 0; j < maze[0].length; j ++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}
}
