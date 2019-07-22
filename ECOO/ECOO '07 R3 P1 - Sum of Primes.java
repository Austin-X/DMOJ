import java.io.*;
import java.util.*;

public class SumOfPrimes {
	static boolean[] prime = new boolean[10000000];
	static int[] primes = new int[664579];
	
	static void sieve() {
		Arrays.fill(prime, true);
		
		for (int i = 2; i * i < 10000000; i ++) {
			if (prime[i]) {
				for (int j = i * i; j < 10000000; j += i) {
					prime[j] = false;
				}
			}
		}
		prime[0] = false; prime[1] = false; prime[2] = false;
		
		int cn = 0;
		for (int i = 3; i < 10000000; i += 2) {
			if (prime[i]) {
				primes[cn] = i; cn ++;
			}
		}
	}
	
	static int n;
	static ArrayList<Integer> ans, diff;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sieve();
		
        for (int t = 0; t < 5; t ++) {
            n = Integer.parseInt(br.readLine());

            System.out.print(n + " = ");
            solve(primes);
            
            System.out.println();
        }
	}
	
	static void solve(int[] arr) {
		int a = 0, b = 0, c = 0;
		
		int upperBound = Arrays.binarySearch(arr, n);
		if (upperBound < 0) upperBound = -(upperBound) - 2;
		
		for (int i = 0; i <= upperBound; i ++) {
			if (primes[i] == n) {
				System.out.print(primes[i]); return;
			}
		}

		boolean bool = false;
		for (int i = 0; i <= upperBound; i ++) {
			if (primes[i] > n / 2) break;
			if (prime[n - primes[i]]) {
				a = primes[i]; b = n - primes[i]; bool = true;
			}
		}
		if (bool) {
			System.out.print(a + " + " + b); return;
		}

		ans = new ArrayList<Integer>(); diff = new ArrayList<Integer>();
		
		for (int i = 0; i <= upperBound; i ++) {
			if (primes[i] * 3 > n) {
				break;
			} else {
				ans.add(primes[i]);
				diff.add(n - primes[i] * 3);
				a = primes[i];
			}
		}	
		
		for (int i = diff.size() - 1; i >= 0; i --) {
			for (int j = diff.get(i) / 2; j >= 0; j --) {
				if (ans.get(i) - j + diff.get(i) < 10000000 && ans.get(i) + j < 10000000) {
					if (prime[ans.get(i) + j] && prime[ans.get(i) - j + diff.get(i)]) {
						a = ans.get(i);
						b = ans.get(i) + j;
						c = ans.get(i) - j + diff.get(i);
						System.out.print(a + " + " + b + " + " + c); return;
					}
				}
			}
		}
	}
}
