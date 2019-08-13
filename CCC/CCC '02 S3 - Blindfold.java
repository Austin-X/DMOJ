import java.io.*;
import java.util.*;

public class Blindfold {
	static class point {
		int x, y;
		point (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static char[] moves;
	static char[][] grid;
	static int curRow, curCol, r, c, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		r = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		grid = new char[r][c];
		char[][] ans = new char[r][c];
		
		for (int i = 0; i < r; i ++) {
			grid[i] = br.readLine().toCharArray();
			ans[i] = Arrays.copyOf(grid[i], c);
		}
		
		m = Integer.parseInt(br.readLine());
		moves = new char[m];
		for (int i = 0; i < m; i ++) moves[i] = br.readLine().charAt(0);
		
		ArrayList<point> list = new ArrayList<point>();
		for (int i = 0; i < r; i ++) {
			for (int j = 0; j < c; j ++) {
				if (grid[i][j] == '.') list.add(new point(i, j));
			}
		}
		
		for (int i = 0; i < list.size(); i ++) {
			int row = list.get(i).x;
			int col = list.get(i).y;
			
			curRow = row; curCol = col;
			if (calc('u')) ans[curRow][curCol] = '*';
			curRow = row; curCol = col;
			if (calc('r')) ans[curRow][curCol] = '*';
			curRow = row; curCol = col;
			if (calc('d')) ans[curRow][curCol] = '*';
			curRow = row; curCol = col;
			if (calc('l')) ans[curRow][curCol] = '*';
		}
		
		for (int i = 0; i < r; i ++) {
			for (int j = 0; j < c; j ++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}
	
	static boolean calc(char dir) {
		for (int j = 0; j < m; j ++) {
			if (moves[j] == 'F') {
				if (dir == 'u' && curRow - 1 >= 0 && grid[curRow - 1][curCol] != 'X') curRow --;
				else if (dir == 'r' && curCol + 1 < c && grid[curRow][curCol + 1] != 'X') curCol ++;
				else if (dir == 'd' && curRow + 1 < r && grid[curRow + 1][curCol] != 'X') curRow ++;
				else if (dir == 'l' && curCol - 1 >= 0 && grid[curRow][curCol - 1] != 'X') curCol --;
				else return false;
			} else if (moves[j] == 'R') {
				if (dir == 'u') dir = 'r';
				else if (dir == 'r') dir = 'd';
				else if (dir == 'd') dir = 'l';
				else dir = 'u';
			} else if (moves[j] == 'L') {
				if (dir == 'u') dir = 'l';
				else if (dir == 'l') dir = 'd';
				else if (dir == 'd') dir = 'r';
				else dir = 'u';
			}
		}
		return true;
	}
}
