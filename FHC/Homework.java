import java.io.*;
import java.util.*;

public class Homework {
	static int[] primacity = new int[10000001];
	static int caseNum = 1;
	
	static void sieve() {
		for (int i = 2; i <= 10000000; i ++) {
			if (primacity[i] == 0) {
				for (int j = i; j <= 10000000; j += i) {
					primacity[j] ++;
				}
			}
		}
	}
	
	static void solve(int a, int b, int k) {
		int cn = 0;
		
		for (int i = a; i <= b; i ++) {
			if (primacity[i] == k) {
				cn ++;
			}
		}
		
		System.out.println("Case #" + caseNum + ": " + cn);
		caseNum ++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sieve();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			solve(a, b, k);
		}
	}
}
