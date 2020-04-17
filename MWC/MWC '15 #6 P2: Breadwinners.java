import java.io.*;
import java.util.*;

public class Breadwinners {
	static boolean[] primes = new boolean[10001];
	static TreeSet<Integer> ans = new TreeSet<Integer>();
	
	static void generate() {
		Arrays.fill(primes, true);
		primes[0] = false; primes[1] = false; 
		for (int i = 2; i * i <= 10000; i ++) {
			if (primes[i]) {
				for (int j = i * i; j <= 10000; j += i) {
					primes[j] = false;
				}
			}
		}
		
		for (int i = 2; i <= 10000; i ++) {
			if (primes[i]) ans.add(i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		generate();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) {
			int x = Integer.parseInt(st.nextToken());
			if (x == 1 || x == 2) System.out.println("no can do");
			else System.out.println(ans.lower(x));
		}
	}
}
