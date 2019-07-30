import java.io.*;
import java.util.*;

public class Slikar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		
		for (int i = 0; i < r; i ++) map[i] = br.readLine().toCharArray();
		
		int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
		Queue<Integer> floods = new LinkedList<Integer>();
		
		int[][] floodDis = new int[r][c];
		for (int[] x : floodDis) Arrays.fill(x, Integer.MAX_VALUE);
		boolean[][] visited = new boolean[r][c];
		
		for (int i = 0; i < r; i ++) {
			for (int j = 0; j < c; j ++) {
				if (map[i][j] == 'S') { startRow = i; startCol = j; } 
				else if (map[i][j] == 'D') { endRow = i; endCol = j; }
				else if (map[i][j] == '*') { floods.add(i); floods.add(j); floodDis[i][j] = 0; visited[i][j] = true; }
			}
		}
		
		int row, col;
		while (!floods.isEmpty()) {
			row = floods.poll();
			col = floods.poll();
			
			if (row > 0 && map[row - 1][col] != 'D' && map[row - 1][col] != 'X' && !visited[row - 1][col]) { visited[row - 1][col] = true; floodDis[row - 1][col] = floodDis[row][col] + 1; floods.add(row - 1); floods.add(col); } 
			if (row < r - 1 && map[row + 1][col] != 'D' && map[row + 1][col] != 'X' && !visited[row + 1][col]) { visited[row + 1][col] = true; floodDis[row + 1][col] = floodDis[row][col] + 1; floods.add(row + 1); floods.add(col); } 
			if (col > 0 && map[row][col - 1] != 'D' && map[row][col - 1] != 'X' && !visited[row][col - 1]) { visited[row][col - 1] = true; floodDis[row][col - 1] = floodDis[row][col] + 1; floods.add(row); floods.add(col - 1); } 
			if (col < c - 1 && map[row][col + 1] != 'D' && map[row][col + 1] != 'X' && !visited[row][col + 1]) { visited[row][col + 1] = true; floodDis[row][col + 1] = floodDis[row][col] + 1; floods.add(row); floods.add(col + 1); } 
		}
		
		for (boolean[] x : visited) Arrays.fill(x, false);
		
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] dis = new int[r][c];
		q.add(startRow); q.add(startCol);
		visited[startRow][startCol] = true;
		
		while(!q.isEmpty()) {
			row = q.poll();
			col = q.poll();
			
			if (row > 0 && map[row - 1][col] != 'X' && !visited[row - 1][col] && dis[row][col] + 1 < floodDis[row - 1][col]) { visited[row - 1][col] = true; dis[row - 1][col] = dis[row][col] + 1; q.add(row - 1); q.add(col); }
			if (row < r - 1 && map[row + 1][col] != 'X' && !visited[row + 1][col] && dis[row][col] + 1 < floodDis[row + 1][col]) { visited[row + 1][col] = true; dis[row + 1][col] = dis[row][col] + 1; q.add(row + 1); q.add(col); }
			if (col > 0 && map[row][col - 1] != 'X' && !visited[row][col - 1] && dis[row][col] + 1 < floodDis[row][col - 1]) { visited[row][col - 1] = true; dis[row][col - 1] = dis[row][col] + 1; q.add(row); q.add(col - 1); }
			if (col < c - 1 && map[row][col + 1] != 'X' && !visited[row][col + 1] && dis[row][col] + 1 < floodDis[row][col + 1]) { visited[row][col + 1] = true; dis[row][col + 1] = dis[row][col] + 1; q.add(row); q.add(col + 1); }
		}
		
		System.out.println(dis[endRow][endCol] != 0 ? dis[endRow][endCol] : "KAKTUS");
	}
}
