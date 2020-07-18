import java.io.*;
import java.util.*;

public class FarmerJohnSolves3Sum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		long[][] psa = new long[n][n];
		int[] cnt = new int[1000000 * 2 + 1];
		for (int i = n - 3; i >= 0; i --) {		
			if (arr[i + 1] < 0) cnt[1000000 + (-arr[i + 1])] ++;
			else cnt[arr[i + 1]] ++;
			
			for (int k = i + 2; k < n; k ++) {
				int num = -(arr[i] + arr[k]);
				if (num >= -1000000 && num <= 1000000) {
					if (num < 0) num = 1000000 + (-num);
					psa[i][k] = psa[i][k - 1] + cnt[num];
				} else {
					psa[i][k] = psa[i][k - 1];
				}
			
				if (arr[k] < 0) cnt[1000000 + (-arr[k])] ++;
				else cnt[arr[k]] ++;
			}
			
			for (int k = i + 2; k < n; k ++) psa[i][k] += psa[i + 1][k];
			for (int j = i + 1; j < n; j ++) {
				if (arr[j] < 0) cnt[1000000 + (-arr[j])] --;
				else cnt[arr[j]] --;
			}
		}
		
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			System.out.println(psa[a - 1][b - 1]);
		}
	}
}
