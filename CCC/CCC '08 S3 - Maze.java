import java.io.*;
import java.util.*;

public class Maze {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int T = 0; T < t; T ++) {
			int r = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());
			char[][] city = new char[r][c];
			
			for (int i = 0; i < r; i ++) {
				city[i] = br.readLine().toCharArray();
			}
			
			int[][] dis = new int[r][c];
			dis[0][0] = 1;
			boolean[][] visited = new boolean[r][c];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(0); q.add(0);
			visited[0][0] = true;
			
			while (!q.isEmpty()) {
				int row = q.poll();
				int col = q.poll();
				
				if (city[row][col] == '+') {
					if (row > 0 && !visited[row - 1][col] && city[row - 1][col] != '*') { q.add(row - 1); q.add(col); visited[row - 1][col] = true; dis[row - 1][col] = dis[row][col] + 1; }
					if (row < r - 1 && !visited[row + 1][col] && city[row + 1][col] != '*') { q.add(row + 1); q.add(col); visited[row + 1][col] = true; dis[row + 1][col] = dis[row][col] + 1; }
					if (col > 0 && !visited[row][col - 1] && city[row][col - 1] != '*') { q.add(row); q.add(col - 1); visited[row][col - 1] = true; dis[row][col - 1] = dis[row][col] + 1; }
					if (col < c - 1 && !visited[row][col + 1] && city[row][col + 1] != '*') { q.add(row); q.add(col + 1); visited[row][col + 1] = true; dis[row][col + 1] = dis[row][col] + 1; }
				} else if (city[row][col] == '-') {
					if (col > 0 && !visited[row][col - 1] && city[row][col - 1] != '*') { q.add(row); q.add(col - 1); visited[row][col - 1] = true; dis[row][col - 1] = dis[row][col] + 1; }
					if (col < c - 1 && !visited[row][col + 1] && city[row][col + 1] != '*') { q.add(row); q.add(col + 1); visited[row][col + 1] = true; dis[row][col + 1] = dis[row][col] + 1; }
				} else if  (city[row][col] == '|') {
					if (row > 0 && !visited[row - 1][col] && city[row - 1][col] != '*') { q.add(row - 1); q.add(col); visited[row - 1][col] = true; dis[row - 1][col] = dis[row][col] + 1; }
					if (row < r - 1 && !visited[row + 1][col] && city[row + 1][col] != '*') { q.add(row + 1); q.add(col); visited[row + 1][col] = true; dis[row + 1][col] = dis[row][col] + 1; }
				}
			} 
			
			System.out.println(dis[r - 1][c - 1] != 0 ? dis[r - 1][c - 1] : -1);
		}
	}
}
