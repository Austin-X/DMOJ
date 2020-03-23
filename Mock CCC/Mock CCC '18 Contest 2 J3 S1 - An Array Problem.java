import java.io.*;
import java.util.*;

public class AnArrayProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		long sum = 0;
		for (int i = 0; i < n; i ++) {
			arr[i] = Long.parseLong(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		long max = arr[n - 1];
		long ans = Math.min(sum / 2, sum - max);
		System.out.println(ans);
	}
}
