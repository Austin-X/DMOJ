import java.io.*;
import java.util.*;

public class ItamiAndCandy {
	static boolean[] primes = new boolean[148735];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	static void sieveOfEratosthenes(int n) {
		for (int i = 0; i < 148735; i ++) {
			primes[i] = true;
		}
		
		for (int p = 2; p * p < 148735; p ++) {
			// If prime[p] is not changed, then it is a prime
			if (primes[p] == true) {
				// Update all multiples of p
				for (int i = p * p; i < 148735; i += p) {
					primes[i] = false;
				}
			}
		}
		primes[0] = false; primes[1] = false;
		
		for (int i = 1; i <= n; i ++) {
			if (primes[i] == true) {
				list.add(i);
			}
		}
  	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		sieveOfEratosthenes(n);
		int cn = 0;
		
		for (int i = 0; i < list.size(); i ++) {
			if (n - list.get(i) == 0) cn ++;
			else {
				cn += (n - list.get(i)) / x + 1;	
				cn += (n - list.get(i) - 1) / x + 1;
			}
		}
		
		System.out.println(cn);
	}
}
