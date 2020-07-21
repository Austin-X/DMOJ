import java.io.*;
import java.util.*;

public class Patrik {
	static class Pair {
		int val, cnt;
		Pair (int val, int cnt) { this.val = val; this.cnt = cnt; }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long ans = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(br.readLine());
		
		Stack<Pair> s = new Stack<Pair>();
		for (int i = 0; i < n; i ++) {
			int cnt = 1;
			while (!s.isEmpty()) {
				if (arr[i] > s.peek().val) ans += s.pop().cnt; 
				else if (arr[i] == s.peek().val) { cnt = s.pop().cnt + 1; ans += cnt - 1; }
				else { ans ++; break; }
			}
			s.push(new Pair(arr[i], cnt));
		}
		System.out.println(ans);
	}
}
