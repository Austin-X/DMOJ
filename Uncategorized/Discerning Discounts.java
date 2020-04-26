import java.io.*;
import java.util.*;

public class DiscerningDiscounts {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
		int ans = 0;

		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
			double cost = c - ((double)c / 100 * d);
			if (cost <= t) ans ++;
		}
		System.out.println(ans);
	}
}
