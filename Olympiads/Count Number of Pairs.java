import java.io.*;
import java.util.*;

public class CountNumberOfPairs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		long ans = 0;
		
		Arrays.sort(arr);
		int low = 0, high = n - 1;
		while (low < high) {
			if (arr[low] + arr[high] <= m) {
				ans += high - low; low ++;
			} else {
				high --;
			}
		}
		
		System.out.println(ans);
	}
}
