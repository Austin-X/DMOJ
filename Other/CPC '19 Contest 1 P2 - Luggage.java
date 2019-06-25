import java.io.*;
import java.util.*;

public class Luggage {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int max = 0, lower = 0, upper = 1;
		int k = Integer.parseInt(st.nextToken());
		int[] luggage = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) luggage[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(luggage);
		
		while (upper < n) {
			if (luggage[upper] - luggage[lower] <= k) {
				upper ++; 
			} else {
				lower ++;
			}
			max = Math.max(max, upper - lower);
		}
		
		System.out.println(max);
	}
}
