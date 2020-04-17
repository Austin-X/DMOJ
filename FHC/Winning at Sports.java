import java.io.*;

public class WinningAtSports {
	static final int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] stressFree = new int[2001][2001];
		for (int i = 1; i <= 2000; i ++) {
			for (int j = 0; j < i; j ++) {
				if (j == 0) stressFree[i][j] = 1;
				else stressFree[i][j] = (stressFree[i - 1][j] + stressFree[i][j - 1]) % MOD;
			}
		}
		int[][] stressful = new int[2001][2001];
		int[] stressfulAns = new int[2001];
		for (int i = 0; i <= 2000; i ++) {
			for (int j = 0; j <= i; j ++) {
				if (j == 0 || i == 1) stressful[i][j] = 1;
				else {
					stressful[i][j] = (stressful[i - 1][j] + stressful[i][j - 1]) % MOD;
				}
			}
			stressfulAns[i] = stressful[i][i];
		}
		
		for (int t = 1; t <= T; t ++) {
			String[] nums = br.readLine().split("-");
			int myScore = Integer.parseInt(nums[0]), enemyScore = Integer.parseInt(nums[1]);
			
			System.out.println("Case #" + t + ": " + stressFree[myScore][enemyScore] + " " + stressfulAns[enemyScore]);
		}
	}
}
