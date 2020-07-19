import java.io.*;
import java.util.*;

public class PizzaBag {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		long[] psa = new long[2 * n];
		psa[0] = arr[0]; 
		for (int i = 1; i < n; i ++) psa[i] = psa[i - 1] + arr[i];
		for (int i = n; i < 2 * n; i ++) psa[i] = psa[i - 1] + arr[i - n];

		Deque<Long> min = new ArrayDeque<Long>();
		for (int i = 0; i < k - 1; i ++) {
			while (!min.isEmpty() && psa[i] < min.peekLast()) min.pollLast();
			min.addLast(psa[i]);
		}
		
		long ans = 0;
		for (int i = k - 1; i < n + k - 1; i ++) {
			if (k == 1) {
				ans = Math.max(ans, arr[i]);
			} else {
				ans = Math.max(ans, psa[i] - min.peekFirst());
				if (i >= k && psa[i - k] == min.peekFirst()) min.pollFirst();
				while (!min.isEmpty() && psa[i] < min.peekLast()) min.pollLast();
				min.addLast(psa[i]);
			}
		}
		
		System.out.println(ans);
	}
}
