import java.io.*;
import java.util.*;

public class AClassicProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		long ans = n;
		int low = 0, high = 1, max = Math.max(arr[0], arr[1]), min = Math.min(arr[0], arr[1]);
		
		while (high < n) {
			if (low == high) {
				high ++;
				if (high == n) break;
				max = Math.max(arr[low], arr[high]);
				min = Math.min(arr[low], arr[high]);	
			} else if (max - min <= k) {
				ans += high - low;
				high ++;
				if (high == n) break;
				max = Math.max(max, arr[high]);
				min = Math.min(min, arr[high]);
			} else {
				low ++;
				min = Integer.MAX_VALUE; max = -1;
				for (int i = low; i <= high; i ++) {
					min = Math.min(min, arr[i]); max = Math.max(max, arr[i]);
				}
			}
		}
		
		System.out.println(ans);
	}
}
