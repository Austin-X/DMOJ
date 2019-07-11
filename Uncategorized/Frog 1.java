import java.io.*;
import java.util.*;

public class Frog1 {
	static int[] pfs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(br.readLine());
		int[] heights = new int[n];
		pfs = new int[n];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) heights[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(heights, n));
	}
	
	static int solve(int[] h, int n) {
		pfs[0] = 0; pfs[1] = Math.abs(h[1] - h[0]);
		for (int i = 2; i < n; i ++) {
			pfs[i] = Math.min(pfs[i - 1] + Math.abs(h[i] - h[i - 1]), pfs[i - 2] + Math.abs(h[i] - h[i - 2]));
		}
		
		return pfs[n - 1];
	}
}
