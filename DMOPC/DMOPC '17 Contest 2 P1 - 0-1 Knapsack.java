import java.io.*;
import java.util.StringTokenizer;

public class ZeroOneKnapsack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long max = 0;
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int capacity = Integer.parseInt(st.nextToken());
			long value = Long.parseLong(st.nextToken());
			if (value > 0) max += capacity;
		}
		System.out.println(max);
	}
}
