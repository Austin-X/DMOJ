import java.io.*;
import java.util.*;

public class MimiAndKuteness {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long[] psa = new long[n + 1]; int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken()); psa[i] = psa[i - 1] + arr[i];
		}
		
		int half = n / 2;
		long sum = psa[n];
		int low = 1, high = n - 1;
		ArrayList<Long> flame = new ArrayList<Long>();
		for (int i = 1; i <= half; i ++) {
			System.out.println(sum);
			flame.add(sum);
	
			sum = sum + psa[high] - psa[low];
			low ++; high --;
		}
		if (n % 2 == 1) System.out.println(sum);

		for (int i = flame.size() - 1; i >= 0; i --) System.out.println(flame.get(i));
	}
}
