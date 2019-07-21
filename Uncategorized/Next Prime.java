import java.io.*;

public class NextPrime {
	static boolean isPrime(int n) {
		if (n == 1) return false;
		
		for (int i = 2; i <= Math.sqrt(n); i ++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int ans = 0;
		for (int i = n; i <= Integer.MAX_VALUE; i ++) {
			if (isPrime(i)) {
				ans = i; break;
			}
		}
		
		System.out.println(ans != 0 ? ans : 2);
	}
}
