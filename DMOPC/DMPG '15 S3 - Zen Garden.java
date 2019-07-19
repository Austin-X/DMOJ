import java.io.*;
import java.util.*;

public class ZenGarden {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] flowers = new int[n];
		int[] distur = new int[n - 1];
		
		st = new StringTokenizer(br.readLine());	
		for (int i = 0; i < n; i ++) flowers[i] = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			distur[a] = d;
		}

		for (int i = 0; i < n - 1; i ++) {
			if (flowers[i] < distur[i] || flowers[i + 1] < distur[i]) {
				if (flowers[i] < flowers[i + 1]) flowers[i] = 0;
				else flowers[i + 1] = 0;
			} else {
				flowers[i] -= distur[i];
			}
		}
				
		int ans = 0;
		for (int x : flowers) ans += x;
		System.out.println(ans);
	}
}
