import java.io.*;
import java.util.*;

public class Oversleep {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] neighbourhood = new char[n][m];
		
		for (int i = 0; i < n; i ++) {
			neighbourhood[i] = br.readLine().toCharArray();
		}
		
		int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				if (neighbourhood[i][j] == 's') {
					startRow = i; startCol = j;
				}
				if (neighbourhood[i][j] == 'e') {
					endRow = i; endCol = j;
				}
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[][] visited = new boolean[n][m];
		int[][] dis = new int[n][m];
		for (int[] x : dis) Arrays.fill(x, -1);

		q.add(startRow); q.add(startCol);
		visited[startRow][startCol] = true;
		dis[startRow][startCol] = 0;
		
		int ans = -1;
		while(!q.isEmpty()) {
			int row = q.poll();
			int col = q.poll();
			
			if (row == endRow && col == endCol) { ans = dis[row][col] - 1; break; }
			if (row > 0 && neighbourhood[row - 1][col] != 'X' && !visited[row - 1][col]) { q.add(row - 1); q.add(col); visited[row - 1][col] = true; dis[row - 1][col] = dis[row][col] + 1; }
			if (row < n - 1 && neighbourhood[row + 1][col] != 'X' && !visited[row + 1][col]) { q.add(row + 1); q.add(col); visited[row + 1][col] = true;  dis[row + 1][col] = dis[row][col] + 1;}
			if (col > 0 && neighbourhood[row][col - 1] != 'X' && !visited[row][col - 1]) { q.add(row); q.add(col - 1); visited[row][col - 1] = true;  dis[row][col - 1] = dis[row][col] + 1;}
			if (col < m - 1 && neighbourhood[row][col + 1] != 'X' && !visited[row][col + 1]) { q.add(row); q.add(col + 1); visited[row][col + 1] = true;  dis[row][col + 1] = dis[row][col] + 1;}
		}
		
		System.out.println(ans != -1 ? ans : -1);
	}
}
