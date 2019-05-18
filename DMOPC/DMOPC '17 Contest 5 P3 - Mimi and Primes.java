import java.io.*;
import java.util.*;

public class MimiAndPrimes {
	public static long gcd(long nums, long result) {
		long c;
		while (result != 0) {
			c = nums % result; 
			nums = result; 
			result = c; 
		}
		return nums;
	}
	
	public static long findGCD(long[] nums, int n) {
		long result = nums[0];
		for (int i = 1; i < n; i ++) {
			result = gcd(nums[i], result);
		}
		return result;
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long[] nums = new long[n];
		long ans = 0, temp = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		
		long gcd = findGCD(nums, n);
		
		for (long i = 2; i <= Math.sqrt(gcd); i ++) {
			while (gcd % i == 0) {
				gcd /= i;
				temp = i;
			}
		}
		ans = Math.max(gcd, temp);
		
		if (ans != 1) System.out.println(ans);
		else System.out.println("DNE");
	}
}
