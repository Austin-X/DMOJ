import java.io.*;
import java.util.*;

public class DamageOutput {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		double m = Double.parseDouble(st.nextToken());
		long[] damage = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) damage[i] = Integer.parseInt(st.nextToken());
		
		int low = 0, high = 0, ans = Integer.MAX_VALUE;
		long sum = damage[0];
		while (low <= high) {
			if (sum < m) {
				high ++;
				if (high == n) break;
				sum += damage[high];
			} else {
				ans = Math.min(ans, high - low + 1);
				sum -= damage[low];
				low ++;
			}
		}
		System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
	}
}
