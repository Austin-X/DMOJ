import java.io.*;
import java.util.*;

public class BrunoAndFibonacci {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> fib = new ArrayList<Integer>();
		fib.add(1); fib.add(1);
		int cur = -1;
		
		while (true) {
			cur = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
			if (cur > n) break;
			fib.add(cur);	
		}
		
		char[] ch = br.readLine().toCharArray();
		boolean flag = true;
		for (int i = 0; i < n; i ++) {
			if (fib.contains(i + 1) && ch[i] != 'A' || !fib.contains(i + 1) && ch[i] == 'A') { flag = false; break; }
		}
		System.out.println(flag ? "That's quite the observation!" : "Bruno, GO TO SLEEP");
	}
}
