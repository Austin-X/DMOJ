import java.io.*;
import java.util.*;

public class Golf {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int distance = Integer.parseInt(br.readLine());
		int clubs = Integer.parseInt(br.readLine());
		
		int[] dp = new int[distance + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		int[] hits = new int[clubs];
		for (int i = 0; i < clubs; i ++) {
			hits[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(hits);
		
		for (int i = 0; i < clubs; i ++) {
			int temp = hits[i];
			
			while (temp <= distance) {
				for (int j = distance; j >= 0; j --) {
					if (dp[j] != -1 && j + hits[i] <= distance) dp[j + hits[i]] = dp[j] + 1;
				}
				temp += hits[i];
			}
		}

		if (dp[distance] != -1) System.out.println("Roberta wins in " + dp[distance] + " strokes.");
		else System.out.println("Roberta acknowledges defeat.");
	}
}
