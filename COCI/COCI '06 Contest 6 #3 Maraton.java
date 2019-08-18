import java.io.*;

public class Maraton {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[][] grid = new char[n][n];
		
		for (int i = 0; i < n; i ++) grid[i] = br.readLine().toCharArray();
		
		char won = ' ';
		outerloop: for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				if (grid[i][j] != '.') {
					if (i > 0 && i < n - 1 && grid[i - 1][j] == grid[i][j] && grid[i + 1][j] == grid[i][j]) { won = grid[i][j]; break outerloop; } 
					else if (j > 0 && j < n - 1 && grid[i][j - 1] == grid[i][j] && grid[i][j + 1] == grid[i][j]) { won = grid[i][j]; break outerloop; } 
					else if (i > 0 && i < n - 1 && j > 0 && j < n - 1 && grid[i][j] == grid[i - 1][j - 1] && grid[i][j] == grid[i + 1][j + 1]) { won = grid[i][j]; break outerloop; } 
					else if (i > 0 && i < n - 1 && j > 0 && j < n - 1 && grid[i][j] == grid[i - 1][j + 1] && grid[i][j] == grid[i + 1][j - 1]) { won = grid[i][j]; break outerloop; }
				}
			}
		}
		System.out.println(won != ' ' ? won : "ongoing");
	}
}
