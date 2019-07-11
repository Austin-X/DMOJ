import java.io.*;
import java.util.*;

public class Knapsack1 {
	static long knapsack(int W, int[] wt, int[] val, int n) {
		long[] K = new long[W + 1];
		
		for (int i = 0; i < n; i ++) {
			for (int j = W; j >= wt[i]; j --) {
				K[j] = Math.max(K[j], val[i] + K[j - wt[i]]);
			}
		}
		
		return K[W];
	}
	
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
}
