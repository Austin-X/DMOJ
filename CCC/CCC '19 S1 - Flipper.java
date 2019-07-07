import java.io.*;

public class Flipper {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] grid = {{1, 2}, {3, 4}};
		
		int temp1, temp2;
		char[] flips = br.readLine().toCharArray();
		for (int i = 0; i < flips.length; i ++) {
			if (flips[i] == 'H') {
				temp1 = grid[0][0];
				temp2 = grid[0][1];
				grid[0][0] = grid[1][0];
				grid[0][1] = grid[1][1];
				grid[1][0] = temp1;
				grid[1][1] = temp2;
			} else {
				temp1 = grid[0][0];
				temp2 = grid[1][0];
				grid[0][0] = grid[0][1];
				grid[1][0] = grid[1][1];
				grid[0][1] = temp1;
				grid[1][1] = temp2;
			}
		}
		
		printGrid(grid);
	}
	
	static void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i ++) {
			for (int j = 0; j < grid[0].length; j ++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
