import java.io.*;
import java.util.*;

public class Knapsack2 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());	
		int[] wt = new int[n];
		int[] val = new int[n];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			wt[i] = Integer.parseInt(st.nextToken());
			val[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(knapsack(W, wt, val, n));
	}
	
	static long knapsack(int W, int[] wt, int[] val, int n) {
		long[] K = new long[1000 * n + 1];
		Arrays.fill(K, 1000000001);
		
		K[0] = 0;
		for (int i = 0; i < n; i ++) {
			long x = wt[i];
			int y = val[i];
			
			for (int j = K.length - 1; j >= y; j --) {
				K[j] = Math.min(K[j], K[j - y] + x);
			}
		}
		
		for (int i = K.length - 1; i >= 0; i --) {
			if (K[i] <= W) return i;
		}
		return 0;
	}
}
