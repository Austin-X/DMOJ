import java.io.*;

public class G {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dim = 5 * n;
		char[][] grid = new char[dim][dim];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < dim; j ++) {
				grid[i][j] = 'G';
				grid[j][i] = 'G';
			}
		}
		
		for (int i = dim - n; i < dim; i ++) {
			for (int j = 0; j < dim; j ++) {
				grid[i][j] = 'G';
			}
		}
		
		int scale = n * 2;
		for (int i = scale; i < dim; i ++) {
			for (int j = dim - n; j < dim; j ++) {
				grid[i][j] = 'G';
			}
		}
		for (int i = scale; i < dim - scale; i ++) {
			for (int j = 3 * n; j < dim; j ++) {
				grid[i][j] = 'G';
			}
		}
		
		for (int i = 0; i < dim; i ++) {
			for (int j = 0; j < dim; j ++) {
				System.out.print(grid[i][j] == 'G' ? grid[i][j] : ".");
			}
			System.out.println();
		}
	}
}
