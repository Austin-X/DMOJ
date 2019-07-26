import java.io.*;
import java.util.*;

public class SimonAndMarcy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] princess = new int[c];
		int[] songs = new int[c];
		
		for (int i = 0; i < c; i ++) {
			st = new StringTokenizer(br.readLine());
			princess[i] = Integer.parseInt(st.nextToken());
			songs[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[m + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		int max = 0;
		for (int i = 0; i < c; i ++) {
			for (int j = m; j >= songs[i]; j --) {
				if (dp[j - songs[i]] != -1) {
					dp[j] = Math.max(dp[j - songs[i]] + princess[i], dp[j]);
					max = Math.max(max, dp[j]);
				} 
			}
		}
		
		System.out.println(max);
	}
}
