import java.io.*;
import java.util.*;

public class TSSClubFair2017ProblemB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		double[] houses = new double[n];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// Pythagorean theorem
			houses[i] = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		}
		Arrays.sort(houses);

		for (int i = 0; i < q; i ++) {
			int range = Integer.parseInt(br.readLine());
			
			int low = 0, high = n - 1;
			
			while (low <= high) {
				int mid = (low + high) / 2;
				if (houses[mid] <= range) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			
			System.out.println(low);
		}
	}
}
