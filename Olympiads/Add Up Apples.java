import java.io.*;
import java.util.*;

public class AddUpApples {
	static int n, cn = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n / 2; i ++) {
			recurse(i, i, String.valueOf(i));
		}
		System.out.println("total=" + cn);
	}
	
	static void recurse(int idx, int sum, String ans) {
		if (sum == n) {
			cn ++; System.out.println(n + "=" + ans); return;
		}
		for (int i = idx; i <= n - sum; i ++) {
			recurse(i, sum + i, ans + "+" + i);
		}
	}
}
