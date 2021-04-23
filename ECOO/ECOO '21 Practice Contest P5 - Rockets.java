import java.io.*;
import java.util.*;

public class Rockets {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] parent, rank;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		parent = new int[n + 1]; rank = new int[n + 1];
		for (int i = 1; i <= n; i ++) parent[i] = i;
		
		int[] arrA = new int[n - 1], arrB = new int[n - 1];
		for (int i = 0; i < n - 1; i ++) {
			arrA[i] = readInt(); arrB[i] = readInt();
		}
		
		int c = readInt(), d = readInt();
		for (int i = 0; i < n - 1; i ++) {
			if (arrA[i] == c && arrB[i] == d || arrA[i] == d && arrB[i] == c) continue;
			union(arrA[i], arrB[i]);
		}
		
		int[] freq = new int[n + 1];
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= n; i ++) {
			int p = find(i);
			freq[p] ++;
			set.add(p);
		}
		
		boolean flag = false;
		for (int x: set) {
			if (freq[x] % 2 == 0) {
				flag = true;
				break;
			}
		}
		
		System.out.println(flag ? "Let's play >:)" : "NOU >:(");
	}
	
	static int find(int x) {
		if (parent[x] != x) return parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int x, int y) {
		int pX = find(x), pY = find(y);
		if (rank[pX] > rank[pY]) {
			parent[pY] = pX;
		} else if (rank[pX] < rank[pY]) {
			parent[pX] = pY;
		} else {
			parent[pX] = pY;
			rank[pY] ++;
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
