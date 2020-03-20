import java.io.*;
import java.util.*;

public class MagicTrick {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 5; t ++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] deck = new int[n + 1];
			int[] cn = new int[n + 1];
			boolean[] vis = new boolean[n + 1];
			for (int i = 1; i <= n; i ++) cn[i] = n - i;
			
			boolean imposs = false;
			for (int i = 1; i <= n; i ++) {
				int x = Integer.parseInt(st.nextToken());
				
				int idx = -1;
				for (int j = 1; j <= n; j ++) {
					if (!vis[j] && cn[j] == x) { idx = j; vis[j] = true; break; }
				}
				
				deck[i] = idx;
				if (idx == -1) imposs = true;
				else {
					for (int j = 1; j < idx; j ++) cn[j] --;
				}
			}

			if (imposs) System.out.println("IMPOSSIBLE");
			else {
				for (int i = 1; i <= n; i ++) System.out.print(deck[i] + " ");
				System.out.println();
			}
			
		}
	}
}
