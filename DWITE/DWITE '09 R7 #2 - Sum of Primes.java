import java.util.*;
import java.io.*;

public class SumOfPrimes {
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static void sieveOfEratosthenes() 
    { 
        // Create a boolean array "prime[0..n]" and initialize all entries it as true.
		// A value in prime[i] will finally be false if i is Not a prime, else true.
		boolean[] prime = new boolean[1000001];
		
		for (int i = 0; i < 1000000; i ++) prime[i] = true;
		
		for (int p = 2; p * p <= 1000000; p ++) {
			// If prime[p] is not changed, then it is a prime
			if (prime[p] == true) {
				// Update all multiples of p
				for (int i = p * p; i <= 1000000; i += p) {
					prime[i] = false;
				}
			}
		}
		
		for (int i = 2; i < 1000000; i ++) {
			if (prime[i]) 
				primes.add(i);
		} 
    }
	
	public static void printPrimesSum(int n) {
		int sum = 0;
		for (int x : primes) {
			if (x > n) break;
			else sum += x;
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sieveOfEratosthenes();
		for (int a = 0; a < 5; a ++) {
			int n = Integer.parseInt(br.readLine());
			printPrimesSum(n);
		}
	}
}
