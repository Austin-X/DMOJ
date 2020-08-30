import java.io.*;
import java.util.*;

public class SheepAndCoyotes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		double[] sheepX = new double[n], sheepY = new double[n];
		for (int i = 0; i < n; i ++) { sheepX[i] = readDouble(); sheepY[i] = readDouble(); }
		boolean[] eaten = new boolean[n];
		for (double i = 0.00; i <= 1000.00; i += 0.01) {
			double min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j ++) min = Math.min(min, Math.sqrt(Math.pow(sheepX[j] - i, 2) + Math.pow(sheepY[j], 2)));
			for (int j = 0; j < n; j ++) if (Math.sqrt(Math.pow(sheepX[j] - i, 2) + Math.pow(sheepY[j], 2)) == min) eaten[j] = true;
		}
	
		for (int i = 0; i < n; i ++) {
			if (eaten[i]) {
				System.out.print("The sheep at (");
				System.out.format("%.2f", sheepX[i]);
				System.out.print(", ");
				System.out.format("%.2f", sheepY[i]);
				System.out.println(") might be eaten.");
			}
		}
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
