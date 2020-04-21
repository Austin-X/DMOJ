import java.io.*;
import java.util.*;

public class BeautifulWaterPearl {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for (int i = d; i <= c; i ++) {
			int b = i ^ e;
			if (b < i) break;
			if ((i | b) == c && (i & b) == d) {
				if (b == i) ans ++;
				else ans += 2;
			}
		}
		System.out.println(ans);
	}
}
