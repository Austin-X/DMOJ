import java.io.*;
import java.util.*;

public class NailedIt {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] boards = new int[2001];
		int[] sums = new int[4001];
		
		for (int i = 0; i < n; i ++) {
			boards[Integer.parseInt(st.nextToken())] ++;
		}
		
		for (int i = 1; i <= 2000; i ++) {
			if (boards[i] != 0) {
				for (int j = i; j <= 2000; j ++) {
					if (i == j) sums[i + j] += boards[i] >> 1;
					else if (boards[j] != 0) {
						sums[i + j] += Math.min(boards[i], boards[j]);
					}
				}
			}
		}
		
		int length = 0, cn = 0;
		for (int i = 1; i <= 4000; i ++) {
			if (sums[i] == length) cn ++;
			else if (sums[i] > length) {
				cn = 1;
				length = sums[i];
			}
		}
		
		System.out.println(length + " " + cn);
	}
}
