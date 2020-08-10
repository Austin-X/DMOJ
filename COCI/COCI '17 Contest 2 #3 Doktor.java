import java.io.*;
import java.util.*;

public class Doktor {
	static class Pair {
		int cn, l, r;
		Pair (int cn, int l, int r) { this.cn = cn; this.l = l; this.r = r; }
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] arr = new int[n + 1], already = new int[n + 1];
		for (int i = 1; i <= n; i ++) {
			arr[i] = readInt();
			if (arr[i] == i) already[i] = already[i - 1] + 1;
			else already[i] = already[i - 1];
		}
		
		HashMap<Double, Pair> map = new HashMap<Double, Pair>();
		for (int i = 1; i <= n; i ++) {
			double val = (double)(i + arr[i]) / 2;
			if (val != i) {
				if (!map.containsKey(val)) map.put(val, new Pair(1, i, i)); 
				else map.put(val, new Pair(map.get(val).cn + 1, map.get(val).l, i));
			}
		}

		int max = already[n]; double ans = 1, diffAns = 0;
		for (double x : map.keySet()) {
			double diff = Math.max(Math.abs(x - map.get(x).l), Math.abs(x - map.get(x).r));
			int lower = (int)(x - diff), upper = (int)(x + diff);
			int temp = map.get(x).cn + already[n] - already[upper] + already[lower - 1];
			if (x % 1 == 0) temp += already[(int)x] - already[(int)x - 1];
			if (temp > max) { max = temp; ans = x; diffAns = diff; }
		}

		System.out.println(arr[(int)(ans - diffAns)] + " "  + arr[(int)(ans + diffAns)]);
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
