import java.io.*;
import java.util.*;

public class MimiAndChristmasCake {
	static int MV = 100000;
	static boolean[] primes = new boolean[MV + 1];
	
	static void sieve() {
		Arrays.fill(primes, true);
		primes[1] = false;
		for (int i = 2; i * i <= MV; i ++) {
			if (primes[i]) {
				for (int j = i * i; j <= MV; j += i) {
					primes[j] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		sieve();
		
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) {
			ans += primes[Integer.parseInt(st.nextToken())] ? 1 : 0;
		}
		System.out.println(ans);
	}
}
