import java.io.*;
import java.util.*;

public class AFK {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t ++) {
			st = new StringTokenizer(br.readLine());
			int cols = Integer.parseInt(st.nextToken());
			int rows = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[rows][cols];
			for (int i = 0; i < rows; i ++) map[i] = br.readLine().toCharArray();
			
			int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
			for (int i = 0; i < rows; i ++) {
				for (int j = 0; j < cols; j ++) {
					if (map[i][j] == 'C') { startRow = i; startCol = j; }
					else if (map[i][j] == 'W') { endRow = i; endCol = j; }
				}
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(startRow); q.add(startCol);
			boolean[][] visited = new boolean[rows][cols];
			visited[startRow][startCol] = true;
			int[][] dis = new int[rows][cols];
			
			while (!q.isEmpty()) {
				int row = q.poll();
				int col = q.poll();
				if (row == endRow && col == endCol) break;
				
				if (row > 0 && !visited[row - 1][col] && map[row - 1][col] != 'X') { visited[row - 1][col] = true; q.add(row - 1); q.add(col); dis[row - 1][col] = dis[row][col] + 1; }
				if (row < rows - 1 && !visited[row + 1][col] && map[row + 1][col] != 'X') { visited[row + 1][col] = true; q.add(row + 1); q.add(col); dis[row + 1][col] = dis[row][col] + 1; }
				if (col > 0 && !visited[row][col - 1] && map[row][col - 1] != 'X') { visited[row][col - 1] = true; q.add(row); q.add(col - 1); dis[row][col - 1] = dis[row][col] + 1; }
				if (col < cols - 1 && !visited[row][col + 1] && map[row][col + 1] != 'X') { visited[row][col + 1] = true; q.add(row); q.add(col + 1); dis[row][col + 1] = dis[row][col] + 1; }
			}
			
			System.out.println(dis[endRow][endCol] != 0 && dis[endRow][endCol] < 60 ? dis[endRow][endCol] : "#notworth");
		}
	}
}
