import java.io.*;
import java.util.*;

public class RicochetRobot {
	static class Node {
		int row, col;
		Node (int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 5; t ++) {
			char[][] grid = new char[10][10];
			int[][] dis = new int[10][10];
			
			for (int i = 0; i < 10; i ++) {
				grid[i] = br.readLine().toCharArray();
				Arrays.fill(dis[i], 1000000);
			}
			
			int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
			for (int i = 0; i < 10; i ++) {
				for (int j = 0; j < 10; j ++) {
					if (grid[i][j] == 'A') { startRow = i; startCol = j; }
					else if (grid[i][j] == 'B') { endRow = i; endCol = j; }
				}
			}
			
			dis[startRow][startCol] = 0;
			Queue<Node> q = new LinkedList<Node>();
			boolean[][] vis = new boolean[10][10];
			q.add(new Node(startRow, startCol));
			
			while (!q.isEmpty()) {
				Node cur = q.poll();
				if (cur.row == endRow && cur.col == endCol) break;
				
				for (int i = startRow + 1; i <= 10; i ++) {
					if (dis[i - 1][cur.col] == 1000000) {
						if (i == 10) { vis[i - 1][cur.col] = true; q.add(new Node(i - 1, cur.col)); dis[i - 1][cur.col] = dis[cur.row][cur.col] + 1; }
						else if (!vis[i][cur.col] && grid[i][cur.col] == '#') { vis[i - 1][cur.col] = true; q.add(new Node(i - 1, cur.col)); dis[i - 1][cur.col] = dis[cur.row][cur.col] + 1; }
					}
				}
				
				for (int i = startRow - 1; i >= -1; i --) {
					if (dis[i + 1][cur.col] == 1000000) { 
						if (i == -1) { vis[i + 1][cur.col] = true; q.add(new Node(i + 1, cur.col)); dis[i + 1][cur.col] = dis[cur.row][cur.col] + 1; }
						else if (!vis[i][cur.col] && grid[i][cur.col] == '#') { vis[i + 1][cur.col] = true; q.add(new Node(i + 1, cur.col)); dis[i + 1][cur.col] = dis[cur.row][cur.col] + 1; }
					}
				}
				
				for (int i = startCol + 1; i <= 10; i ++) {
					if (dis[cur.row][i - 1] == 1000000) { 
						if (i == 10) { vis[cur.row][i - 1] = true; q.add(new Node(cur.row, i - 1)); dis[cur.row][i - 1] = dis[cur.row][cur.col] + 1; }
						else if (!vis[cur.row][i - 1] && grid[cur.row][i] == '#') { vis[cur.row][i - 1] = true; q.add(new Node(cur.row, i - 1)); dis[cur.row][i - 1] = dis[cur.row][cur.col] + 1; }
					}
				}
				
				for (int i = startCol - 1; i >= -1; i --) {
					if (dis[cur.row][i + 1] == 1000000) {
						if (i == -1) { vis[cur.row][i + 1] = true; q.add(new Node(cur.row, i + 1)); dis[cur.row][i + 1] = dis[cur.row][cur.col] + 1; }
						else if (!vis[cur.row][i] && grid[cur.row][i] == '#') { vis[cur.row][i + 1] = true; q.add(new Node(cur.row, i + 1)); dis[cur.row][i + 1] = dis[cur.row][cur.col] + 1; }
					}
				}
			}

			System.out.println(dis[endRow][endCol]);
			String line = br.readLine();
		}
	}
}
