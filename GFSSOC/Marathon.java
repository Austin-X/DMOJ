import java.io.*;
import java.util.*;

public class Marathon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[] pfs = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		pfs[1] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= n; i ++) pfs[i] = pfs[i - 1] + Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(pfs[n] - pfs[b] + pfs[a - 1]);
		}
	}
}
