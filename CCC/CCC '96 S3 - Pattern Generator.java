import java.io.*;
import java.util.*;

public class PatternGenerator {
	static ArrayList<String> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i ++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
			arr = new ArrayList<String>();
			recurse(n, k, 0, "");
			System.out.println("The bit patterns are");
			for (String x : arr) System.out.println(x);
			System.out.println();
		}
	}

	static void recurse(int n, int k, int oneCn, String str) {
		if (oneCn > k) return;
		if (str.length() == n) {
			if (oneCn == k) arr.add(str); 
			return;
		} 
		recurse(n, k, oneCn + 1, str + "1");
		recurse(n, k, oneCn, str + "0");
	}
}
