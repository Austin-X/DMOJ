import java.io.*;
import java.util.*;

public class Restaurants {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
		boolean[] cn = new boolean[n + 1];
		
		for (int i = 0; i < v; i ++) {
			int x = Integer.parseInt(br.readLine());
			cn[x] = true;
		}
		int ans = 0, cur = 0;
		for (int i = 1; i <= t; i ++) {
			if (cn[i]) cur ++;
		}

		if (cur < k) {
			int add = k - cur;
			cur = k; ans += add;
			for (int i = t; i >= 1; i --) {
				if (add == 0) break;
				if (!cn[i]) { cn[i] = true; add --; }
			}
		}
		
		for (int i = t + 1; i <= n; i ++) {
			if (cn[i - t]) cur --;
			if (cn[i]) cur ++;
			if (cur < k) { 
				cn[i] = true; cur ++; ans ++; 
			}
		}
		System.out.println(ans);
	}
}
