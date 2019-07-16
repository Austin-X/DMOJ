import java.io.*;
import java.util.*;

public class NotEnoughTesters {
	// All numbers from 1 to 100000 will all have less than or equal to 200 factors, so the dimensions are 200 * 100000.
	static int[][] factors = new int[201][100001];
			
	static void precompute() {
		for (int i = 1; i <= 100000; i ++) {
			int fctors = 1, cur = i;
			
			for (int j = 2; j <= (int)Math.sqrt(i); j ++) {
				int cn = 1;
				
				while (cur % j == 0) {
					cur /= j;
					cn ++;
				}
				fctors *= cn;
			}
			
			// If cur is greater than 1, it means that the number is prime and can therefore only have 2 factors
			if (cur > 1) fctors *= 2;
			
			factors[fctors][i] = 1;
		}

		for (int i = 0; i <= 200; i ++) {
			for (int j = 1; j <= 100000; j ++) {
				factors[i][j] += factors[i][j - 1];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		precompute();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i ++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (k > 138) System.out.println(0);
			else System.out.println(factors[k][b] - factors[k][a - 1]);
		}
	}
}
