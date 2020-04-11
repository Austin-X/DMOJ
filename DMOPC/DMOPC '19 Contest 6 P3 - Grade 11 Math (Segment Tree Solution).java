import java.io.*;
import java.util.*;

public class Grade11Math {
	static int MOD = 1000000007;
	static int[] segT;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		char[] ch = br.readLine().toCharArray();
		
		int[] memo = new int[n];
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
		segT = new int[2 * (int)Math.pow(2, x) - 1];
		
		int ans = 0;
		int cur = 1;
		for (int i = n - 1; i >= 0; i --) {	
			if (ch[i] == '1') { ans += cur; ans %= MOD; }
			else memo[i] = cur;
			cur *= 2;
			cur %= MOD;
		}
		
		buildSegmentTree(memo, 0, n - 1, 0);
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			ans += getSum(l, r, 0, n - 1, 0);
			ans %= MOD;
			System.out.println(ans);
		}
	}
	
	static void buildSegmentTree(int[] memo, int low, int high, int pos) {
		if (low == high) {
			segT[pos] = memo[low];
			return;
		}
		int mid = (low + high) / 2;
		buildSegmentTree(memo, low, mid, pos * 2 + 1);
		buildSegmentTree(memo, mid + 1, high, pos * 2 + 2);
		segT[pos] = segT[pos * 2 + 1] + segT[pos * 2 + 2];
		segT[pos] %= MOD;
	}
	
	static int getSum(int l, int r, int low, int high, int pos) {
		if (l > high || r < low) return 0;
		if (segT[pos] == 0) return 0;
		
		int out = 0;
		if (l <= low && r >= high) {
			out = segT[pos]; segT[pos] = 0; return out;
		}
		
		int mid = (low + high) / 2;
		out += getSum(l, r, low, mid, 2 * pos + 1);
		out %= MOD;
		out += getSum(l, r, mid + 1, high, 2 * pos + 2);
		out %= MOD;
		segT[pos] = segT[2 * pos + 1] + segT[2 * pos + 2];
		segT[pos] %= MOD;
		
		return out;
	}
}
