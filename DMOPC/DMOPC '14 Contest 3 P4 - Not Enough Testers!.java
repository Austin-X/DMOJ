import java.io.*;
import java.util.*;

public class NotEnoughTesters {
	static int[] factors = new int[100001];
	@SuppressWarnings("unchecked")
	static ArrayList<Integer>[] list = new ArrayList[100001];
	
	static void precompute() {
		for (int i = 0; i <= 100000; i ++) list[i] = new ArrayList<Integer>();
		
		for (int i = 1; i <= 100000; i ++) {
			for (int j = i; j <= 100000; j += i) {
				factors[j] ++;
			}
			list[factors[i]].add(i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		precompute();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i ++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int low = Collections.binarySearch(list[k], a);
			int high = Collections.binarySearch(list[k], b);
			
			if (low < 0 && high < 0) System.out.println((-high) + low);
			else if (low < 0 && high >= 0) System.out.println(high + low + 2);
			else if (low >= 0 && high < 0) System.out.println((-high) - low - 1);
			else System.out.println(high - low + 1);
		}
	}
}
