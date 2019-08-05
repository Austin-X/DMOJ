import java.util.*;
import java.io.*;

public class MaxGCD {
	public static int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b); 
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] nums = new Integer[n];
		
		for (int i = 0; i < n; i ++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int[] gcdArray = new int[n]; gcdArray[0] = nums[0];
		for (int i = 1; i < n; i ++) gcdArray[i] = findGCD(gcdArray[i - 1], nums[i]);
		
		int gcd = 0, tempGCD = 0;
		for (int i = 0; i < n; i ++) {
			if (i == 0) tempGCD = nums[1];
			else tempGCD = gcdArray[i - 1];
			
			for (int j = i + 1; j < n; j ++) {
				tempGCD = findGCD(tempGCD, nums[j]);
				if (tempGCD <= gcd) break;
			}
			gcd = Math.max(gcd, tempGCD);
		}
		
		System.out.println(gcd);
	}
}
