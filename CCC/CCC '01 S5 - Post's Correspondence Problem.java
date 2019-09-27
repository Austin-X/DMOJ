import java.io.*;
import java.util.*;

public class PostsCorrespondenceProblem {
	static String[] A, B;
	static int m, n;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		
		A = new String[n];
		B = new String[n];
		ans = new int[m];
		
		for (int i = 0; i < n; i ++) A[i] = br.readLine();
		for (int i = 0; i < n; i ++) B[i] = br.readLine();
		
		recurse ("", "", 0, 0);
		System.out.println("No solution.");
	}
	
	static void recurse (String a, String b, int cn, int idx) {
		if (cn == m) return; 
		
		int min = Math.min(a.length(), b.length());
		
		char[] aCh = a.toCharArray();
		char[] bCh = b.toCharArray();
		for (int i = idx; i < min; i ++) {
			if (aCh[i] != bCh[i]) return;
		}
		
		if (a.length() == b.length() && cn != 0) { System.out.println(cn); 
			for (int i = 0; i < cn; i ++) System.out.println(ans[i]);
			System.exit(0); 
		}
		else {
			for (int i = 0; i < n; i ++) { ans[cn] = i + 1; recurse (a + A[i], b + B[i], cn + 1, min); }
		}
	} 
}
