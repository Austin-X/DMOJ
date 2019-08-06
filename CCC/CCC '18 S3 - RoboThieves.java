import java.io.*;
import java.util.*;

public class RoboThieves {
	static class point {
		int x, y;
		
		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int rows = Integer.parseInt(st.nextToken());
		int cols = Integer.parseInt(st.nextToken());
		
		char[][] grid = new char[rows][cols];
		
		for (int i = 0; i < rows; i ++) grid[i] = br.readLine().toCharArray();
		
		int startRow = 0, startCol = 0;
		ArrayList<point> cameras = new ArrayList<point>();
		for (int i = 0; i < rows; i ++) {
			for (int j = 0; j < cols; j ++) {
				if (grid[i][j] == 'C') {
					cameras.add(new point(i, j));
				} else if (grid[i][j] == 'S') {
					startRow = i; startCol = j;
				}
			}
		}
		
		int row, col;
		
		boolean[][] security = new boolean[rows][cols];
		for (int i = 0; i < cameras.size(); i ++) {
			row = cameras.get(i).x;
			col = cameras.get(i).y;
			
			for (int j = row - 1; j >= 0; j --) {
				if (grid[j][col] == '.' || grid[j][col] == 'S') security[j][col] =  true;
				else if (grid[j][col] == 'W') break;
			}
			
			for (int j = row + 1; j < rows; j ++) {
				if (grid[j][col] == '.' || grid[j][col] == 'S') security[j][col] =  true;
				else if (grid[j][col] == 'W') break;
			}
			
			for (int j = col - 1; j >= 0; j --) {
				if (grid[row][j] == '.' || grid[row][j] == 'S') security[row][j] =  true;
				else if (grid[row][j] == 'W') break;
			}
			
			for (int j = col + 1; j < cols; j ++) {
				if (grid[row][j] == '.' || grid[row][j] == 'S') security[row][j] =  true;
				else if (grid[row][j] == 'W') break;
			}
		}
		if (security[startRow][startCol]) {
			for (int i = 0; i < rows; i ++) {
				for (int j = 0; j < cols; j ++) {
					if (grid[i][j] == '.') System.out.println(-1);
				}
			}
			System.exit(0);
		}
		
		Deque<Integer> q = new LinkedList<Integer>();
		q.add(startRow); q.add(startCol);
		boolean[][] visited = new boolean[rows][cols];
		visited[startRow][startCol] = true;
		int[][] dis = new int[rows][cols];
		
		while (!q.isEmpty()) {
			row = q.poll();
			col = q.poll();
			
			if (grid[row][col] == 'U') {
				if (!security[row - 1][col] && grid[row - 1][col] != 'W' && !visited[row - 1][col]) {
					if (grid[row - 1][col] != '.') { q.addFirst(col); q.addFirst(row - 1); }
					else { q.add(row - 1); q.add(col); }
					dis[row - 1][col] = dis[row][col]; visited[row - 1][col] = true;
				}
				continue;
			} else if (grid[row][col] == 'D') {
				if (!security[row + 1][col] && grid[row + 1][col] != 'W' && !visited[row + 1][col]) {
					if (grid[row + 1][col] != '.') {  q.addFirst(col); q.addFirst(row + 1); }
					else { q.add(row + 1); q.add(col); }
					dis[row + 1][col] = dis[row][col]; visited[row + 1][col] = true;
				}
				continue;
			} else if (grid[row][col] == 'L') {
				if (!security[row][col - 1] && grid[row][col - 1] != 'W' && !visited[row][col - 1]) {
					if (grid[row][col - 1] != '.') { q.addFirst(col - 1); q.addFirst(row); }
					else { q.add(row); q.add(col - 1); }
					dis[row][col - 1] = dis[row][col]; visited[row][col - 1] = true;
				}
				continue;
			} else if (grid[row][col] == 'R') {
				if (!security[row][col + 1] && grid[row][col + 1] != 'W' && !visited[row][col + 1]) {
					if (grid[row][col + 1] != '.') { q.addFirst(col + 1); q.addFirst(row); }
					else { q.add(row); q.add(col + 1); }
					dis[row][col + 1] = dis[row][col]; visited[row][col + 1] = true;
				}
				continue;
			}
			
			if (!security[row - 1][col] && grid[row - 1][col] != 'W' && !visited[row - 1][col]) {
				if (grid[row - 1][col] != '.') { q.addFirst(col); q.addFirst(row - 1); }
				else { q.add(row - 1); q.add(col); }
				dis[row - 1][col] = dis[row][col] + 1; visited[row - 1][col] = true; 
			}
			if (!security[row + 1][col] && grid[row + 1][col] != 'W' && !visited[row + 1][col]) {
				if (grid[row + 1][col] != '.') {  q.addFirst(col); q.addFirst(row + 1); }
				else { q.add(row + 1); q.add(col); }
				dis[row + 1][col] = dis[row][col] + 1; visited[row + 1][col] = true;
			}
			if (!security[row][col - 1] && grid[row][col - 1] != 'W' && !visited[row][col - 1]) {
				if (grid[row][col - 1] != '.') { q.addFirst(col - 1); q.addFirst(row); }
				else { q.add(row); q.add(col - 1); }
				dis[row][col - 1] = dis[row][col] + 1; visited[row][col - 1] = true;
			}
			if (!security[row][col + 1] && grid[row][col + 1] != 'W' && !visited[row][col + 1]) {
				if (grid[row][col + 1] != '.') { q.addFirst(col + 1); q.addFirst(row); }
				else { q.add(row); q.add(col + 1); }
				dis[row][col + 1] = dis[row][col] + 1; visited[row][col + 1] = true;
			}
 		}
		
		for (int i = 0; i < rows; i ++) {
			for (int j = 0; j < cols; j ++) {
				if (grid[i][j] == '.') System.out.println(dis[i][j] != 0 ? dis[i][j] : -1);
			}
		}
	}
}
