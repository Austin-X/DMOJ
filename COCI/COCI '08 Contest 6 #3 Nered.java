import java.io.*;
import java.util.*;

public class Nered {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int[][] grid = new int[n][n];

		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1, c = Integer.parseInt(st.nextToken()) - 1;
			grid[c][r] = 1;
		}
		
		int[][] psa = new int[n][n];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				if (i == 0 && j == 0) psa[i][j] = grid[i][j];
				else if (i == 0) psa[i][j] = grid[i][j] + psa[i][j - 1];
				else if (j == 0) psa[i][j] = grid[i][j] + psa[i - 1][j];
				else psa[i][j] = grid[i][j] + psa[i][j - 1] + psa[i - 1][j] - psa[i - 1][j - 1];
			}
		}

		HashMap<Integer, Integer> factors = new HashMap<Integer, Integer>();
		for (int i = 1; i <= (int)Math.sqrt(m); i ++) {
			if (m % i == 0) {
				factors.put(i, m / i); factors.put(m / i, i);
			}
		}	
		
		int max = 0;
		for (int width : factors.keySet()) {
			int length = factors.get(width);
			
			int temp = 0;
			for (int i = 0; i <= n - length; i ++) {
				for (int j = 0; j <= n - width; j ++) {
					if (i == 0 && j == 0) temp = Math.max(temp, psa[j + width - 1][i + length - 1]);
					else if (i == 0) temp = Math.max(temp, psa[j + width - 1][i + length - 1] - psa[j - 1][i + length - 1]);
					else if (j == 0) temp = Math.max(temp, psa[j + width - 1][i + length - 1] - psa[j + width - 1][i - 1]);
					else temp = Math.max(temp, psa[j + width - 1][i + length - 1] - psa[j + width - 1][i - 1] - psa[j - 1][i + length - 1] + psa[j - 1][i - 1]);
				}
			}
			max = Math.max(max, temp);
		}
		
		System.out.println(m - max);
	}
}
