import java.io.*;
import java.util.*;

public class War {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());		
		int[] larry = new int[n], opponent = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) larry[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) opponent[i] = Integer.parseInt(st.nextToken());
				
		int ans = 0;
		
		boolean war = false;
		for (int i = 0; i < n; i ++) {
			if (!war && larry[i] == opponent[i]) {
				war = true; ans ++;
			} else if (war && larry[i] != opponent[i]) war = false;
		}
		
		System.out.println(ans);
	}
}
