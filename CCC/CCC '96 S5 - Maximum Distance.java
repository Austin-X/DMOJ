import java.io.*;
import java.util.*;

public class MaximumDistance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < n; t ++) {
			int l = Integer.parseInt(br.readLine());
			
			int[] arr1 = new int[l];
			int[] arr2 = new int[l];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < l; i ++) arr1[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < l; i ++) arr2[i] = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for (int i = 0; i < l; i ++) {
				for (int j = 0; j < l; j ++) {
					if (arr2[j] >= arr1[i] && j >= i) {
						max = Math.max(max, j - i);
					}
				}
			}
			
			System.out.println("The maximum distance is " + max);
		}
	}
}
