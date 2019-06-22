import java.io.*;
import java.util.*;

public class CommonDivisor {
	public static long GCD(long a, long b) {
		if (b==0) return a;
		return GCD(b,a%b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long gcd = GCD(a, b);
		
		HashSet<Long> temp = new HashSet<Long>();
		for (int i = 1; i <= Math.sqrt(gcd); i ++) {
			if (gcd % i == 0) {
				temp.add((long) i); temp.add(gcd / i);
			}
		}
		
		ArrayList<Long> arr = new ArrayList<Long>(temp);
		Collections.sort(arr);

		System.out.println(k > arr.size() ? -1 : arr.get(arr.size() - k));
	}
}
