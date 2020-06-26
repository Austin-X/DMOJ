import java.io.*;
import java.util.*;

public class Firefly {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
		int[] stalagmites = new int[n / 2], stalactites = new int[n / 2];
		int[] stalagmitesCn = new int[h + 1], stalactitesCn = new int[h + 1];
		for (int i = 0; i < n / 2; i ++) {
			int x = Integer.parseInt(br.readLine()), y = Integer.parseInt(br.readLine());
			stalagmitesCn[x] ++;
			stalactitesCn[y] ++;
			stalagmites[i] = x;
			stalactites[i] = y;
		}
		
		Arrays.sort(stalagmites); Arrays.sort(stalactites);
		
		int best = Integer.MAX_VALUE, distinct = 0;
		for (int i = 1; i <= h; i ++) {
			int cn = 0;
			int idx = Arrays.binarySearch(stalagmites, i);
			if (idx < 0) {
				idx = -idx - 1;
				cn += (n / 2) - idx;
			} else {
				int temp = idx;
				while (true) {
					idx --;
					if (idx == -1) break; 
					if (stalagmites[idx] != stalagmites[temp]) break;
				}
				cn += (n / 2) - idx - 1;
			}
			
			idx = Arrays.binarySearch(stalactites, h - i + 1);
			if (idx < 0) {
				idx = -idx - 1;
				cn += (n / 2) - idx;
			} else {
				int temp = idx;
				while (true) {
					idx --;
					if (idx == -1) break; 
					if (stalactites[idx] != stalactites[temp]) break;
				}
				cn += (n / 2) - idx - 1;
			}
			
			if (cn == best) distinct ++;
			else if (cn < best) {
				best = cn;
				distinct = 1;
			}
		}
		
		System.out.println(best + " " + distinct);
	}
}
