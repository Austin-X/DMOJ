import java.io.*;
import java.util.*;

public class FloorPlan {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int flooring = Integer.parseInt(br.readLine());
		int r = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		char[][] grid = new char[r][c];
		
		for (int i = 0; i < r; i ++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		int startRow = 0, startCol = 0;
		outerloop : for (int i = 0; i < r; i ++) {
			for (int j = 0; j < c; j ++) {
				if (grid[i][j] == '.') {
					startRow = i; startCol = j; break outerloop;
				}
			}
		}
		
		ArrayList<Integer> roomSizes = new ArrayList<Integer>();
		boolean[][] visited = new boolean[r][c];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startRow); queue.add(startCol);
		visited[startRow][startCol] = true;
			
		int cn = 1; 
		while(true) {
			int row = queue.poll();
			int col = queue.poll();
			
			if (row > 0 && !visited[row - 1][col] && grid[row - 1][col] == '.') { visited[row - 1][col] = true; queue.add(row - 1); queue.add(col); cn ++; }
			if (row < r - 1  && !visited[row + 1][col] && grid[row + 1][col] == '.') { visited[row + 1][col] = true; queue.add(row + 1); queue.add(col); cn ++; }
			if (col > 0 && !visited[row][col - 1] && grid[row][col - 1] == '.') { visited[row][col - 1] = true; queue.add(row); queue.add(col - 1); cn ++; }
			if (col < c - 1  && !visited[row][col + 1] && grid[row][col + 1] == '.') { visited[row][col + 1] = true; queue.add(row); queue.add(col + 1); cn ++; }
			
			if (queue.isEmpty()) {
				roomSizes.add(cn); cn = 1;
				outerloop : for (int i = 0; i < r; i ++) {
					for (int j = 0; j < c; j ++) {
						if (!visited[i][j] && grid[i][j] == '.') {
							startRow = i; startCol = j; break outerloop;
						}
					}
				}
				queue.add(startRow);
				queue.add(startCol);
				if (allVisited(grid, r, c, visited)) break;
				visited[startRow][startCol] = true;
			}
		}

		Collections.sort(roomSizes, Collections.reverseOrder());
		int index = 0, rooms = 0;
		while (flooring >= 0) {
			flooring -= roomSizes.get(index);
			
			if (flooring < 0) { flooring += roomSizes.get(index); break; }
			rooms ++;
			index ++;
			if (index == roomSizes.size()) break;
		}
		if (rooms != 1) System.out.println(rooms + " rooms, " + flooring + " square metre(s) left over");
		else System.out.println(rooms + " room, " + flooring + " square metre(s) left over");
	}
	
	static boolean allVisited(char[][] grid, int r, int c, boolean[][] visited) {
		boolean bool = true;
		outerloop : for (int i = 0; i < r; i ++) {
			for (int j = 0; j < c; j ++) {
				if (!visited[i][j] && grid[i][j] == '.') { bool = false; break outerloop; }
			}
		}
		if (bool) return true;
		else return false;
	}
}
