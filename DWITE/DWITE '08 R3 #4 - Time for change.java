import java.io.*;
import java.util.*;

public class TimeForChange2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 5; t ++) {
			int m = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			Integer[] coins = new Integer[n];
			for (int i = 0; i < n; i ++) coins[i] = Integer.parseInt(br.readLine());
			Arrays.sort(coins, Collections.reverseOrder());
			
			int[] arr = new int[m + 1];
			Arrays.fill(arr, 101);
			arr[0] = 0;
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j <= m; j ++) {
					if (coins[i] + j <= m) arr[coins[i] + j] = Math.min(arr[coins[i] + j], arr[j] + 1);
					else break;
				}
			}
			System.out.println(arr[m]);
		}
	}
}
