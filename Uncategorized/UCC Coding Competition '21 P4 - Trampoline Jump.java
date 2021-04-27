import java.io.*;
import java.util.*;

public class TrampolineJump {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Pair implements Comparable<Pair> {
		int idx, val;
		Pair (int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		public int compareTo(Pair p) {
			return Integer.compare(val, p.val);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int num1 = 1, num2 = 1;
		int[] a = new int[n + 1];
		a[1] = 2; a[2] = 3;
		for (int i = 3; i <= n; i ++) {
			a[i] = (num1 + num2) % 2021 + i % 50;
			int temp = num1;
			num1 = num2;
			num2 = (temp + num2) % 2021;
		}
		
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 5000000);
		dp[1] = 0; 
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(1, 0));
		
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			if (p.idx < n && dp[p.idx] + 1 < dp[p.idx + 1]) {
				dp[p.idx + 1] = dp[p.idx] + 1;
				pq.add(new Pair(p.idx + 1, dp[p.idx + 1]));
			}
			if (p.idx > 1 && dp[p.idx] + 1 < dp[p.idx - 1]) {
				dp[p.idx - 1] = dp[p.idx] + 1;
				pq.add(new Pair(p.idx - 1, dp[p.idx - 1]));
			}
			
			if (p.idx + a[p.idx] <= n && dp[p.idx] + 1 < dp[p.idx + a[p.idx]]) {
				int cnt = 1;
				for (int j = p.idx + a[p.idx]; j >= p.idx + 1; j --) {
					if (dp[p.idx] + cnt < dp[j]) {
						dp[j] = dp[p.idx] + cnt;
						pq.add(new Pair(j, dp[j]));
					}
					cnt ++;
				}
			}
			if (p.idx - a[p.idx] >= 1 && dp[p.idx] + 1 < dp[p.idx - a[p.idx]]) {
				int cnt = 1;
				for (int j = p.idx - a[p.idx]; j <= p.idx - 1; j ++) {
					if (dp[p.idx] + cnt < dp[j]) {
						dp[j] = dp[p.idx] + cnt;
						pq.add(new Pair(j, dp[j]));
					}
					cnt ++;
				}
			}
		}
		System.out.println(dp[n]);
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
