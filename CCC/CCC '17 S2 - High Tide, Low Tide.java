import java.io.*;
import java.util.*;

public class HighTideLowTide {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] tides = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) tides[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(tides);
		
		if (n % 2 == 0) {
			System.out.print(tides[n / 2 - 1] + " ");
			int low = n / 2 - 2, high = n / 2;
			while (high < n - 1) {
				System.out.print(tides[high] + " ");
				high ++;
				System.out.print(tides[low] + " ");
				low --;
			}
			System.out.print(tides[high]);
		} else {
			System.out.print(tides[n / 2] + " ");
			int low = n / 2 - 1, high = n / 2 + 1;
			while (low >= 0) {
				System.out.print(tides[high] + " ");
				high ++;
				System.out.print(tides[low] + " ");
				low --;
			}
		}
	}
}
