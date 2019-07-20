import java.io.*;
import java.util.*;

public class Putovanje {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] fruits = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) fruits[i] = Integer.parseInt(st.nextToken());
	
		int max = 0;
		for (int i = 0; i < n; i ++) {
			int sum = fruits[i], cn = 1;
			if (sum > c) continue;
			
			for (int j = i + 1; j < n; j ++) {
				if (sum + fruits[j] <= c) {
					sum += fruits[j]; cn ++;
				}
			}
			
			max = Math.max(max, cn);
		}
		
		System.out.println(max);
	}
}
