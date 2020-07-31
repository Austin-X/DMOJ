import java.io.*;
import java.util.*;

// Submit using Java 11
public class HopScotch2 {
	static class Pair {
		long val; int idx;
		Pair (long val, int idx) { this.val = val; this.idx = idx; }
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		long[] dp = new long[n + 1]; int[] parent = new int[n + 1], cn = new int[n + 1];
		long[] arr = new long[n + 1];
		for (int i = 1; i <= n; i ++) arr[i] = readLong();

		Deque<Pair> options = new ArrayDeque<Pair>();
		for (int i = 1; i <= n; i ++) {
			if (i <= k) {
				parent[i] = 0;
				dp[i] = arr[i];
				cn[i] = 1;
				while (!options.isEmpty() && dp[i] <= options.peekLast().val) {
					if (dp[i] == options.peekLast().val) {
						if (cn[i] >= options.peekLast().idx) options.pollLast();
						else break;
					} else options.pollLast();
				}
				options.addLast(new Pair(dp[i], i));
			} else {
				parent[i] = options.peekFirst().idx;
				dp[i] = options.peekFirst().val + arr[i];
				cn[i] = cn[options.peekFirst().idx] + 1;
				if (options.peekFirst().idx == i - k) options.pollFirst();
				
				while (!options.isEmpty() && dp[i] <= options.peekLast().val) {
					if (dp[i] == options.peekLast().val) {
						if (cn[i] > cn[options.peekLast().idx]) options.pollLast();
						else if (cn[i] == cn[options.peekLast().idx]) {
							if (parent[i] >= parent[options.peekLast().idx]) options.pollLast();
							else break;
						}
						else break;
					} else options.pollLast();
				}
				options.addLast(new Pair(dp[i], i));
			}
		}

		long ans = Long.MAX_VALUE; int ansIdx = 0, ansCn = 0, ansParent = 0;
		for (int i = n - k + 1; i <= n; i ++) {
			if (dp[i] < ans) { ans = dp[i]; ansIdx = i; ansCn = cn[i]; ansParent = parent[i]; }
			else if (dp[i] == ans) {
				if (cn[i] > ansCn) { ansIdx = i; ansCn = cn[i]; }
				else if (cn[i] == ansCn) {
					if (parent[i] >= ansParent) { ansIdx = i; ansParent = parent[i]; }
				}
			}
		}
		System.out.println(ans);

		ArrayList<Integer> path = new ArrayList<Integer>();
		while (true) { 
			if (ansIdx == 0) break;
			path.add(ansIdx);
			ansIdx = parent[ansIdx];
		}
		
		for (int i = path.size() - 1; i > 0; i --) System.out.print(path.get(i) + " ");
		System.out.println(path.get(0));
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
