import java.io.*;
import java.util.*;

public class Granica {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		int gcf = 0;
		
		for (int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		gcf = arr[1] - arr[0];
		for (int i = 1; i < n - 1; i ++) {
			gcf = gcd(gcf, arr[i + 1] - arr[i]);
		}

		for (int i = 2; i <= Math.sqrt(gcf); i ++) {
			if (gcf % i == 0) {
				System.out.print(i + " ");
				if (gcf / i != i) System.out.print(gcf / i + " ");
			}
		}	
		System.out.println(gcf);
	}
	
	static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}
