import java.io.*;
import java.util.*;

public class InterNAV {
	 static class Node {
		 int row, col;
		 Node(int row, int col) {
			 this.row = row;
			 this.col = col;
		 }
	 }
	 
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int m = Integer.parseInt(br.readLine());
		 int n = Integer.parseInt(br.readLine());
		 char[][] grid = new char[n + 2][m + 2];
		 for (char[] x : grid) Arrays.fill(x, ' ');
		 
		 for (int i = 1; i <= n; i ++) {
			 char[] temp = br.readLine().toCharArray();
			 for (int j = 1; j <= m; j ++) {
				 grid[i][j] = temp[j - 1];
			 }
		 }
		 
		 int startRow = 0, startCol = 0;
		 outerloop: for (int i = 1; i <= n; i ++) {
			 for (int j = 1; j <= m; j ++) {
				 if (grid[i][j] == '1') { startRow = i; startCol = j; break outerloop; }
			 }
		 }
		 
		 Queue<Node> q = new LinkedList<Node>();
		 boolean[] visited = new boolean[10];
		 visited[1] = true;
		 boolean[][] visSpots = new boolean[n + 2][m + 2];
		 q.add(new Node(startRow, startCol));
		 
		 while (!q.isEmpty()) {
			 Node cur = q.poll(); 
			 if (grid[cur.row - 1][cur.col] != ' ' && grid[cur.row - 1][cur.col] != '#' && !visSpots[cur.row - 1][cur.col]) {
				 if (grid[cur.row - 1][cur.col] != 'O') visited[Character.getNumericValue(grid[cur.row - 1][cur.col])] = true;
				 q.add(new Node(cur.row - 1, cur.col));
				 visSpots[cur.row - 1][cur.col] = true;
			 }
			 if (grid[cur.row + 1][cur.col] != ' ' && grid[cur.row + 1][cur.col] != '#' && !visSpots[cur.row + 1][cur.col]) {
				 if (grid[cur.row + 1][cur.col] != 'O') visited[Character.getNumericValue(grid[cur.row + 1][cur.col])] = true;
				 q.add(new Node(cur.row + 1, cur.col));
				 visSpots[cur.row + 1][cur.col] = true;
			 }
			 if (grid[cur.row][cur.col - 1] != ' ' && grid[cur.row][cur.col - 1] != '#' && !visSpots[cur.row][cur.col - 1]) {
				 if (grid[cur.row][cur.col - 1] != 'O') visited[Character.getNumericValue(grid[cur.row][cur.col - 1])] = true;
				 q.add(new Node(cur.row, cur.col - 1));
				 visSpots[cur.row][cur.col - 1] = true;
			 }
			 if (grid[cur.row][cur.col + 1] != ' ' && grid[cur.row][cur.col + 1] != '#' && !visSpots[cur.row][cur.col + 1]) {
				 if (grid[cur.row][cur.col + 1] != 'O') visited[Character.getNumericValue(grid[cur.row][cur.col + 1])] = true;
				 q.add(new Node(cur.row, cur.col + 1));
				 visSpots[cur.row][cur.col + 1] = true;
			 }
		 }
		 
		 for (int i = 1; i <= 9; i ++) if (visited[i]) System.out.print(i + " ");
	 }
}
