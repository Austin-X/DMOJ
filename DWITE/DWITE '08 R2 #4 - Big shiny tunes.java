import java.io.*;
import java.util.*;

public class BigShinyTunes {
	static class album {
		int space, utility;
		album (int space, int utility) {
			this.space = space;
			this.utility = utility;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 5; t ++) {
			int s = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			album[] albums = new album[n + 1];
			int[][] best = new int[n + 1][s + 1];
			for (int i = 1; i <= n; i ++) {
				st = new StringTokenizer(br.readLine());
				albums[i] = new album(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 1; i <= n; i ++) {
				if (albums[i].space <= s) best[i][albums[i].space] = Math.max(albums[i].utility, best[i - 1][albums[i].space]); 

				for (int j = albums[i].space + 1; j <= s; j ++) {
					best[i][j] = Math.max(Math.max(best[i - 1][j], best[i][j - 1]), best[i - 1][j - albums[i].space] + albums[i].utility);
				}
			}
			
			System.out.println(best[n][s]);
			String line = br.readLine();
		}
	}
}
