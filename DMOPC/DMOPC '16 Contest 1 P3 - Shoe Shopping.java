import java.io.*;
import java.util.*;

// DMOPC '16 Contest 1 P3 - Shoe Shopping
public class ShoeShopping {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] shoes = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = 0;
		for (int i = 0; i < n; i ++) {
			shoes[i] = Integer.parseInt(st.nextToken());
			max += shoes[i];
		}
		
		double[] dp = new double[n];
	
		double min; int index;
		dp[0] = max;
		int sum = shoes[0];
		for (int i = 1; i < n; i ++) {	
			sum += shoes[i];
			dp[i] = sum;
				
			if (shoes[i] < shoes[i - 1]) {
				min = shoes[i]; index = i - 1;
			} else {
				min = shoes[i - 1]; index = i;
			}
			
			if (i >= 2) dp[i] = Math.min(dp[i] - (min / 2), dp[i - 2] + (min / 2) + shoes[index]);
			else dp[i] = Math.min(dp[i], sum - (min / 2));
				
			min = Integer.MAX_VALUE;
			if (i >= 2) {
				int temp = 0;
				for (int j = i - 2; j <= i; j ++) {
					if (shoes[j] < min) {
						min = shoes[j]; index = j;
					}
				}
				for (int j = i - 2; j <= i; j ++) if (j != index) temp += shoes[j];
 
				if (i > 3) dp[i] = Math.min(dp[i], dp[i - 3] + temp);
				else if (i == 3) dp[i] = Math.min(dp[i], sum - min);
				else dp[i] = Math.min(dp[i], sum - min);
			}
			
			dp[i] = Math.min(dp[i - 1] + shoes[i], dp[i]);
		}

		System.out.format("%.1f %n", dp[n - 1]);
	}
}
