import java.io.*;
import java.util.*;

public class LeleiAndDragonScales {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
		int[][] field = new int[h][w];
		for (int i = 0; i < h; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j ++) field[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] psa = new int[h][w];
		for (int i = 0; i < h; i ++) {
			for (int j = 0; j < w; j ++) {
				if (i == 0 && j == 0) psa[i][j] = field[i][j];
				else if (i == 0) psa[i][j] = psa[i][j - 1] + field[i][j];
				else if (j == 0) psa[i][j] = psa[i - 1][j] + field[i][j];
				else psa[i][j] = psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1] + field[i][j];
			}
		}
		int ans = 0;
		HashMap<Integer, Integer> factors = new HashMap<Integer, Integer>();

		for (int i = 1; i <= n; i ++) factors.put(i, n / i);
			
		int temp;
		for (int height : factors.keySet()) {
			int width = factors.get(height);
			for (int i = 0; i <= h - height; i ++) {
				for (int j = 0; j <= w - width; j ++) {
					if (i == 0 && j == 0) temp = psa[i + height - 1][j + width - 1];
					else if (i == 0) temp = psa[i + height - 1][j + width - 1] - psa[i + height - 1][j - 1];
					else if (j == 0) temp = psa[i + height - 1][j + width - 1] - psa[i - 1][j + width - 1];
					else temp = psa[i + height - 1][j + width - 1] - psa[i + height - 1][j - 1] - psa[i - 1][j + width - 1] + psa[i - 1][j - 1];
					ans = Math.max(ans, temp);
				}
			}
			
			int swap = height;
			height = width;
			width = swap;
			for (int i = 0; i <= h - height; i ++) {
				for (int j = 0; j <= w - width; j ++) {
					if (i == 0 && j == 0) temp = psa[i + height - 1][j + width - 1];
					else if (i == 0) temp = psa[i + height - 1][j + width - 1] - psa[i + height - 1][j - 1];
					else if (j == 0) temp = psa[i + height - 1][j + width - 1] - psa[i - 1][j + width - 1];
					else temp = psa[i + height - 1][j + width - 1] - psa[i + height - 1][j - 1] - psa[i - 1][j + width - 1] + psa[i - 1][j - 1];
					ans = Math.max(ans, temp);
				}
			}
		}
		System.out.println(ans);
	}
}
