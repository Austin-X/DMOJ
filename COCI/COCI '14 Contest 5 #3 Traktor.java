import java.io.*;
import java.util.*;

public class Traktor {
	static final int SIZE = 100001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[] diagonalPos1 = new int[SIZE], diagonalPos2 = new int[SIZE], horizontal = new int[SIZE], vertical = new int[SIZE], diagonalNeg = new int[SIZE * 2];

		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			if (y >= x) {
				diagonalPos1[y - x] ++;
				if (diagonalPos1[y - x] == k) { ans = i; break; }
			}
			else {
				diagonalPos2[x - y] ++;
				if (diagonalPos2[x - y] >= k) { ans = i; break; }
			}
			diagonalNeg[x + y] ++;
			if (diagonalNeg[x + y] >= k) { ans = i; break; }
			
			horizontal[y] ++;
			if (horizontal[y] >= k) { ans = i; break; }
			
			vertical[x] ++;
			if (vertical[x] >= k) { ans = i; break; }
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
}
