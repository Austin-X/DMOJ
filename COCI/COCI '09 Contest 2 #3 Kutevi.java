import java.io.*;
import java.util.*;

public class Kutevi {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		
		int[] mirko = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) mirko[i] = Integer.parseInt(st.nextToken());
		
		int[] angles = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i ++) angles[i] = Integer.parseInt(st.nextToken());
		
		boolean[] construct = new boolean[360];
		for (int i = 0; i < n; i ++) {
			int cur = mirko[i];
			
			while (true) {
				boolean pass = false;
				
				while (cur < 360) {
					if (!construct[cur]) { 
						construct[cur] = true; 
						pass = true; 
					}
					cur += mirko[i];
				}
				cur -= 360;
				
				if (!pass) break;
			}
		}
		
		for (int i = 0; i < 360; i ++) {
			if (construct[i]) {
				for (int j = 0; j < n; j ++) {
					if (i - mirko[j] < 0) construct[i - mirko[j] + 360] = true;
					else construct[i - mirko[j]] = true;
					
					if (i + mirko[j] >= 360) construct[i + mirko[j] - 360] = true;
					else construct[i + mirko[j]] = true;
				}
			}
		}
		
		for (int i = 0; i < k; i ++) {
			System.out.println(construct[angles[i]] ? "YES" : "NO");
		}
	}
}
