import java.io.*;
import java.util.*;

public class ToweringTowers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] towers = new int[n];
		int[] see = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		see[0] = 0;
		for (int i = 1; i < n; i ++) {
			int cn = 1;
			for (int j = i - 1; j > 0; j --) {
				if (towers[i] >= towers[j]) {
					cn ++;
				} else break;
			}
			see[i] = cn;
		}
		
		for (int x : see) System.out.print(x + " ");
	}
}
