import java.io.*;
import java.util.*;

public class TheThirdCellar {
	public static boolean[] primes = new boolean[1000000];
	public static int[] cn = new int[1000000];
	
	public static void sieveOfEratosthenes() {
		for (int i = 2; i < 1000000; i ++) primes[i] = true;
		
		for (int p = 2; p * p < 1000000; p ++) {
			// If prime[p] is not changed, then it is a prime
			if (primes[p] == true) {
				for (int i = p * p; i < 1000000; i += p) {
					primes[i] = false;
				}
			} 
		}
		
		for (int i = 2; i < 1000000; i ++) {
			if (primes[i]) cn[i] = cn[i - 1] + 1;
			else cn[i] = cn[i - 1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sieveOfEratosthenes();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			System.out.println(cn[end] - cn[start]);
		}
	}
}
