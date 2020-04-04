import java.io.*;
import java.util.*;

public class Grade11Math {
	static int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		char[] ch = br.readLine().toCharArray();
		
		int ans = 0;
		int[] memo = new int[n];
		memo[n - 1] = 1;
		TreeSet<Integer> zeros = new TreeSet<Integer>();
		if (ch[n - 1] == '0') zeros.add(n - 1);
		else ans = 1;
		
		for (int i = n - 2; i >= 0; i --) {	
			memo[i] = memo[i + 1] + memo[i + 1];
			memo[i] %= MOD;
			if (ch[i] == '0') zeros.add(i);		
			else { ans += memo[i]; ans %= MOD; }
		}
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			NavigableSet<Integer> set = zeros.tailSet(l - 1, true);
			while (!set.isEmpty()) {
				if (set.first() >= r) break;
				int x = set.pollFirst();
				ans += memo[x]; ans %= MOD;
				zeros.remove(x);
			}
			
			System.out.println(ans);
		}
	}
}
