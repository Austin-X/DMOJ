import java.io.*;
import java.util.*;

public class Firehose {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int MV = 1000000;
	public static void main(String[] args) throws IOException {
		int h = readInt();
		int[] houses = new int[h];
		for (int i = 0; i < h; i ++) houses[i] = readInt();
		Arrays.sort(houses);
		int k = readInt();
		
		int low = 0, high = MV;
		while (low != high) {
			int mid = (low + high) / 2;
			
			boolean works = false;
			for (int i = 0; i < h; i ++) {
				boolean flag = false;
				int idx = i;
				for (int j = 0; j < k; j ++) {
					int location = houses[idx] + mid;
					if (location >= MV) location -= MV;
					while (calcDis(houses[idx], location) <= mid) {
						idx ++;
						if (idx == h) idx = 0;
						if (idx == i) {
							flag = true;
							break;
						}
					}
					
					if (flag) {
						works = true;
						break;
					}
				}
				if (works) break;
			}
			
			if (works) high = mid;
			else low = mid + 1;
		}
		
		System.out.println(low);
	}
	
	static int calcDis(int x, int y) {
		int max = Math.max(x, y), min = Math.min(x, y);
		return Math.min(max - min, MV - max + min);
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
