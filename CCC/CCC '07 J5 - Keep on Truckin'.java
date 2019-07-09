import java.io.*;
import java.util.*;

public class KeepOnTruckin {
	static int a, b;
	static ArrayList<Integer> hotels = new ArrayList<Integer>();
	static int size;
	static long[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());

		hotels.add(0); hotels.add(990); hotels.add(1010); hotels.add(1970); hotels.add(2030); hotels.add(2940); hotels.add(3060);
		hotels.add(3930); hotels.add(4060); hotels.add(4970); hotels.add(5030); hotels.add(5990); hotels.add(6010); hotels.add(7000);
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i ++) {
			int x = Integer.parseInt(br.readLine());
			hotels.add(x);
		}	
		Collections.sort(hotels);
		size = hotels.size();
		
		dp = new long[size];
		dp[0] = 1;
		
		solve();			
		System.out.println(dp[size - 1]);
	}
	
	static void solve() {
		for (int i = 1; i < size; i ++) {
			for (int j = 0; j < i; j ++) {
				if (hotels.get(i) - hotels.get(j) >= a && hotels.get(i) - hotels.get(j) <= b) {
					dp[i] += dp[j];
				}
			}
		}
	}
}
