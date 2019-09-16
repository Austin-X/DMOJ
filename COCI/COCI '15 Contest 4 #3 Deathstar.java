import java.io.*;
import java.util.*;

public class Deathstar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] ans = new int[n];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) {
				int value = Integer.parseInt(st.nextToken());
				ans[i] = ans[i] | value;
				ans[j] = ans[j] | value;
			}
		}

		for (int i = 0; i < n; i ++) System.out.print(ans[i] + " ");
	}
}
