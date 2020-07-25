import java.io.*;
import java.util.*;

public class Neo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[r][s];
		for (int i = 0; i < r; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < s; j ++) matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] pass = new boolean[r][s];

		for (int i = 1; i < r; i ++) 
			for (int j = 1; j < s; j ++) 
				if (matrix[i - 1][j - 1] + matrix[i][j] <= matrix[i][j - 1] + matrix[i - 1][j]) pass[i][j] = true;


		int ans = 0;
		int[] hist = new int[s];
		
		for (int i = 1; i < r; i ++) {
			for (int j = 1; j < s; j ++) {
				if (pass[i][j]) hist[j] ++;
				else hist[j] = 0;
			}
			ans = Math.max(ans, maxRectInHist(hist));
		}
		
		System.out.println(ans);
	}
	
	static int maxRectInHist(int[] hist) {
		Stack<Integer> stk = new Stack<Integer>();
		int area = 0;
		for (int i = 1; i < hist.length; i ++) {
			while (!stk.isEmpty() && hist[i] <= hist[stk.peek()]) {
				int idx = stk.pop(), j = stk.isEmpty() ? 0 : stk.peek();
				area = Math.max(area, (i - j) * (hist[idx] + 1));
			}
			stk.push(i);
		}
		while (!stk.isEmpty()) {
			int idx = stk.pop(), j = stk.isEmpty() ? 0 : stk.peek();
			area = Math.max(area, (hist.length - j) * (hist[idx] + 1));
		}
		return area;
	}
}
