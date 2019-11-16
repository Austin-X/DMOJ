import java.io.*;
import java.util.*;

public class BigDeposits {
	static double interest;
	static int y, p;
	static long t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		p = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		t = Long.parseLong(st.nextToken());
		
		long lower = 1, upper = (long)1e17;
		while (lower < upper) {
			long mid = (lower + upper) / 2;
			if(solve(mid)) upper = mid;
			else lower = mid + 1;
		}
		System.out.println(lower);
	}

	static boolean solve(long amount) {
		long cur = 0;
		for (int i = 0; i < y; i ++) {
			cur += amount;
			cur += (long)(cur * p/100);
			if (cur >= t) return true;
		}
		return false;
	}
}	
