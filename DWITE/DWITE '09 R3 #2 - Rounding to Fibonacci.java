import java.io.*;
import java.util.*;

public class RoundingToFibonacci {
	static TreeSet<Integer> cache = new TreeSet<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cache.add(0);
		recurse(0, 1);
		
		for (int t = 0; t < 5; t ++) {
			int n = Integer.parseInt(br.readLine());
			int min = cache.floor(n), max = cache.ceiling(n);
			int diffMin = n - min, diffMax = max - n;
			if (diffMin == diffMax) System.out.println(max);
			else System.out.println(diffMin < diffMax ? min : max);
		}
	}
	
	static void recurse(int a, int b) {
		if (a + b >= 1000000000) { cache.add(a + b); return; }
		else { cache.add(a + b); recurse(b, a + b); }
	}
}
