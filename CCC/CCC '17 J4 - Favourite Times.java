import java.io.*;
import java.util.*;

public class FavouriteTimes {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int D = Integer.parseInt(br.readLine());
		
		int ans = 0;
		int start = 1200;
		
		int a, b, c, d;
		for (int i = 1; i <= D % 720; i ++) {
			start ++;
			int h = start / 100, m = start % 100;
			if (m >= 60) {
				m = 0; h ++;
			}
			if (h > 12) h = 1;
			start = h * 100 + m;
			
			if (start > 1000) {
				a = start / 1000; b = start % 1000 / 100; c = start % 100 / 10; d = start % 10;
				if (b - a == c - b && c - b == d - c) ans ++;
			} else {
				a = start / 100; b = start % 100 / 10; c = start % 10;
				if (b - a == c - b) ans ++;
			}
		}
		
		ans += 31 * (D / 720);
		System.out.println(ans);
	}
}
