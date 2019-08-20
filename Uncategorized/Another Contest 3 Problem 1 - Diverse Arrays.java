import java.io.*;
import java.util.*;

public class DiverseArrays {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] cn = new int[1000001];
		
		long ans = 0;
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(br.readLine());

		if (k == 1) ans = ((long)n * (long)n + (long)n) / 2;
		else {
			int low = 0, high = 0, count = 0;
			while (low <= high) {
				if (count >= k) {
					ans += n - high + 1;
					cn[arr[low]] --;
					if (cn[arr[low]] == 0) count --;
					low ++;
				} else {
					if (high == n) break;
					if (cn[arr[high]] == 0) count ++;
					cn[arr[high]] ++;
					high ++;
				}
			}
		}
		
		System.out.println(ans);
	}
}
