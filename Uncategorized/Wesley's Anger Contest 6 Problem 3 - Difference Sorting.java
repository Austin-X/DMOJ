import java.io.*;
import java.util.*;

public class DifferenceSorting {
	static class Pair implements Comparable<Pair> {
		long val;
		int idx;
		
		public Pair(long val, int idx) {
			this.val = val;
			this.idx = idx;
		}

		public int compareTo(Pair p) {
			return Long.compare(val, p.val);
		}
	}
	
	static int[] parent, rank;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Pair[] arr = new Pair[n];
		
		for (int i = 0; i < n; i ++) arr[i] = new Pair(readLong(), i);
				
		Arrays.sort(arr);
		
		long low = 0, high = (long) 1e18;
		while (low < high) {
			long mid = (low + high) / 2;
			
			parent = new int[n]; rank = new int[n];
			for (int i = 0; i < n; i ++) parent[i] = i;
			for (int i = 0; i < n - 1; i ++) {
				if (arr[i + 1].val - arr[i].val <= mid) union(i, i + 1);
			}
			
			boolean flag = true;
			
			outerloop:
			for (int i = 0; i < n; i ++) {
				if (arr[i].idx == i) continue;
				else if (arr[i].idx > i) {
					if (find(arr[i].idx) > i) {
						flag = false;
						break outerloop;
					}
				} else {
					if (find(i) > arr[i].idx) {
						flag = false;
						break outerloop;
					}
				}
			}
			
			if (flag) high = mid;
			else low = mid + 1;
		}

		System.out.println(low);
	}
	
	static int find(int x) {
		if (parent[x] != x) return parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int x, int y) {
		int parentX = find(x), parentY = find(y);
		
		if(rank[parentX] > rank[parentY]) {
			parent[parentY] = parentX;
		} else if (rank[parentX] < rank[parentY]){
			parent[parentX] = parentY;
		} else {
			parent[parentY] = parentX;
			rank[parentX] ++;
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
