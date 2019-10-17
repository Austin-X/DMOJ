import java.io.*;
import java.util.*;

public class Nukit {
	static int[][] reactions = {{2, 1, 0, 2}, {1, 1, 1, 1}, {0, 0, 2, 1}, {0, 3, 0, 0}, {1, 0, 0, 1}};
	static int[][][][] data;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
			
			data = new int[a + 1][b + 1][c + 1][d + 1];
			System.out.println(recurse(a, b, c, d) == 0 ? "Roland" : "Patrick");
		}
	}
	
	static int recurse(int a, int b, int c, int d) {
		if (data[a][b][c][d] == 1) return 1;
		
		for (int i = 0; i < 5; i ++) {
			if (hasLost(i, a, b, c, d)) continue;
			
			if (recurse(a - reactions[i][0], b - reactions[i][1], c - reactions[i][2], d - reactions[i][3]) == 0) {
				data[a][b][c][d] = 1;
				return data[a][b][c][d];
			}
		}
		
		data[a][b][c][d] = 0;
		return data[a][b][c][d];
	}
	
	static boolean hasLost(int idx, int a, int b, int c, int d) {
		if (a < reactions[idx][0]) return true;
		if (b < reactions[idx][1]) return true;
		if (c < reactions[idx][2]) return true;
		if (d < reactions[idx][3]) return true;
		return false;
	}
}
