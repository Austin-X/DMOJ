import java.io.*;
import java.util.*;

public class Grade10Math {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> index = new ArrayList<Integer>();
		int[] primesA = new int[1000001];
		for (int i = 2; i <= a; i ++) {
			while (a % i == 0) {
				primesA[i] ++;
				a /= i;
			}
			if (primesA[i] != 0) index.add(i);
		}
		if (a > 2) {
			if (primesA[a] == 0) index.add(a);
			primesA[a] ++;
		}
		
		int[] primesB = new int[1000001];
		for (int i = 2; i <= b; i ++) {
			int x = i;
			for (int j = 0; j < index.size(); j ++) {
				while (x % index.get(j) == 0) {
					primesB[index.get(j)] ++;
					x /= index.get(j);
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < index.size(); i ++) {
			ans = Math.min(ans, primesB[index.get(i)] / primesA[index.get(i)]);
		}
		System.out.println(ans);
	}
}
