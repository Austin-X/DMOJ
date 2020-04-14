import java.io.*;
import java.util.*;

// The reason why this code has "OutOfMemoryError" on Java 8 for the submission is because the Integer.parseInt() functions returns an Integer object (24 bytes) rather than the primitive 'int' (4 bytes).
// However, by using a scanner in Java 8, this code does not receive "OutOfMemoryError" because the sc.nextInt() functions returns a primitive 'int' (4 bytes).
public class LongestIncreasingSubsequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dp, -1);
		dp[0] = arr[0];
		int size = 1;
		for (int i = 1; i < n; i ++) {
			int low = 0, high = n - 1;
			boolean pass = true;
			
			while (low <= high) {
				int mid = (low + high) / 2;

				if (dp[mid] == -1) high = mid - 1;
				else if (arr[i] < dp[mid]) high = mid - 1;
				else if (arr[i] > dp[mid]) low = mid + 1;
				else { pass = false; break; }
			}
			int idx = low;
			
			if (pass) {
				if (dp[idx] == -1) {
					size ++;
					dp[idx] = arr[i];
				} else if (arr[i] < dp[idx]) dp[idx] = arr[i];
			}
		}
		
		System.out.println(size);
	}
}
