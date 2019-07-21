import java.io.*;

public class PrimeFactorization {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < n; t ++) {
			int m = Integer.parseInt(br.readLine());
			
			while (m % 2 == 0) {
				System.out.print(2 + " ");
				m >>= 1;
			}
			
			for (int i = 3; i <= Math.sqrt(m); i += 2) {
				while (m % i == 0) {
					System.out.print(i + " ");
					m /= i;
				}
			}
			
			if (m > 2) System.out.print(m);
			System.out.println();
		}
	}
}
