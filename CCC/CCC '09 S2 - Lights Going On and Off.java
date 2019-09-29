import java.io.*;
import java.util.*;

public class LightsGoingOnAndOff {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int r = Integer.parseInt(br.readLine());
		int l = Integer.parseInt(br.readLine());
		int[][] grid = new int[r][l];
		for (int i = 0; i < r; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < l; j ++) grid[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] cur = new int[l];
		String temp = "";
		for (int i = 0; i < l; i ++) temp += String.valueOf(grid[r - 1][i]);
		HashSet<String> ans = new HashSet<String>();
		ans.add(temp);
		
		for (int i = 1; i < r; i ++) {
			int idx = i;
			cur = Arrays.copyOf(grid[i - 1], l);
			
			while (idx < r) {			
				for (int j = 0; j < l; j ++) {
					if (grid[idx][j] == cur[j]) cur[j] = 0;
					else cur[j] = 1;
				}
				idx ++;
			}
			
			temp = "";
			for (int j = 0; j < l; j ++) temp += String.valueOf(cur[j]);
			ans.add(temp);
		}
		
		System.out.println(ans.size());
	}
}
