import java.io.*;
import java.util.*;

public class Harvest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		
		int[] diff = new int[n + 1];
		int[] sum = new int[n];
		Arrays.fill(sum, m);
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			diff[x - 1] --;
			diff[y] ++;
		}
		
		for (int i = 1; i < n; i ++) diff[i] += diff[i - 1];
		for (int i = 0; i < n; i ++) sum[i] += diff[i];

		int width = Integer.MAX_VALUE;
		
		int l = 0, r = 0;
		long cn = sum[0];
		while (l <= r) {
			if (cn >= k) {
				width = Math.min(width,  r - l + 1); 
				cn -= sum[l];
				l ++;
			}
			else {
				r ++;
				if (r >= n) break;
				cn += sum[r];
			}
		}
		if (k == 0) System.out.println(0);
		else System.out.println(width != Integer.MAX_VALUE ? width : -1);
	}
}
