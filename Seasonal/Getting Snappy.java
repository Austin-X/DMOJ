import java.io.*;
import java.util.*;

public class GettingSnappy {
	static int minDistance = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		recurse(n, m);
		
		System.out.println(minDistance);
	}
	
	public static void recurse(int total, int target) {
		if (Math.abs(total - target) < Math.abs(minDistance - target)) {
			minDistance = total;
		} else {
			return;
		}
		recurse(total / 2, target);
	}
}
