import java.io.*;
import java.util.*;

public class Harvest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		if (k == 0) {
			System.out.println(0); System.exit(0);
		}
		long[] sum = new long[n];
		long[] diff = new long[n + 1];
		Arrays.fill(sum, m);
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken());
			diff[x] --;
			diff[y] ++;
		}
		
		long temp = 0;
		for (int i = 0; i < n; i ++) {
			temp -= diff[i];
			sum[i] = m - temp;
		}
		
		long min = Integer.MAX_VALUE;
		
		int low = 0, high = 1;
		long cn = sum[0];
		while (high <= n && low < high) {
			if (cn >= k) {
				cn -= sum[low];
				low ++;
				min = Math.min(min, high - low + 1);
			} else {
				if (high == n) break;
				cn += sum[high];
				high ++;
			}
		}

		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}
}
