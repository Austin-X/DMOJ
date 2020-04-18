import java.io.*;
import java.util.*;

public class SurpriseTeleport {
	static class Node {
		int row, col, dis;
		Node (int row, int col, int dis) {
			this.row = row;
			this.col = col;
			this.dis = dis;
		}
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		char[][] grid = new char[r][c];
		st = new StringTokenizer(br.readLine());
		int startRow = Integer.parseInt(st.nextToken()), startCol = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int endRow = Integer.parseInt(st.nextToken()), endCol = Integer.parseInt(st.nextToken());
		for (int i = 0; i < r; i ++) grid[i] = br.readLine().toCharArray();
		
		int t = Integer.parseInt(br.readLine());
		
		boolean[][] teleportation = new boolean[r][c];
		for (int i = 0; i < t; i ++) {
			st = new StringTokenizer(br.readLine());
			teleportation[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		boolean[][] vis = new boolean[r][c];
		vis[startRow][startCol] = true;
		q.add(new Node(startRow, startCol, 0));
		
		int time = Integer.MAX_VALUE, teleTime = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int row = cur.row, col = cur.col, dis = cur.dis;
			if (teleportation[row][col]) teleTime = Math.min(teleTime, dis); 
			if (row == endRow && col == endCol) { time = dis; break; }
			
			if (row < r - 1 && !vis[row + 1][col] && grid[row + 1][col] != 'X') { vis[row + 1][col] = true; q.add(new Node(row + 1, col, dis + 1)); }
			if (row > 0 && !vis[row - 1][col] && grid[row - 1][col] != 'X') { vis[row - 1][col] = true; q.add(new Node(row - 1, col, dis + 1)); }
			if (col < c - 1 && !vis[row][col + 1] && grid[row][col + 1] != 'X') { vis[row][col + 1] = true; q.add(new Node(row, col + 1, dis + 1)); }
			if (col > 0 && !vis[row][col - 1] && grid[row][col - 1] != 'X') {vis[row][col - 1] = true; q.add(new Node(row, col - 1, dis + 1)); }
		}
		
		System.out.println(time - teleTime < 0 ? 0 : time - teleTime);
	}
}
