import java.io.*;
import java.util.*;

public class ChrisCandy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int MV = 100000;
	public static void main(String[] args) throws IOException {
		long k = Long.parseLong(br.readLine()) + 1;
		
		boolean[] primes = new boolean[MV + 1];
		Arrays.fill(primes, true);
		for (int i = 2; i <= MV; i ++) {
			if (primes[i]) {
				for (int j = i + i; j <= MV; j += i) primes[j] = false;
			}
		}
		
		ArrayList<Integer> p = new ArrayList<Integer>();
		for (int i = 2; i <= MV; i ++) if (primes[i]) p.add(i);

		ArrayList<Integer> ans = new ArrayList<Integer>();
		int sum = 0;
		while (k != 1) {
			boolean flag = false;
			for (int x: p) if (k % x == 0) { ans.add(x); sum += (x - 1); k /= x; flag = true; break; }
			if (!flag || sum > MV) {
				System.out.println("Sad Chris");
				System.exit(0);
			}
		}

		System.out.println(sum);
		for (int i = 0; i < ans.size() - 1; i ++) {
			for (int j = 1; j < ans.get(i); j ++) System.out.print((i + 1) + " ");
		}
		for (int j = 1; j < ans.get(ans.size() - 1) - 1; j ++) System.out.print(ans.size() + " ");
		System.out.println(ans.size());
	}
}
