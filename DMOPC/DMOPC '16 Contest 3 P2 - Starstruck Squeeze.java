import java.io.*;
import java.util.*;

public class StarstruckSqueeze {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt(), d = readInt();
		Queue<Integer> q = new LinkedList<Integer>(); 
		int cur = 1, prevIdx = 0;
		boolean[] jacks = new boolean[n]; int[] pieces = new int[n], jackIdx = new int[n]; int idx = 0;
		for (int i = 0; i < n; i ++) {
			char option = readCharacter();
			if (option == 'T') { jacks[i] = true; jackIdx[i] = idx; idx ++; }
			else {
				int x = readInt(); pieces[i] = x;
				q.add(i);
				cur *= x;
				while (!q.isEmpty() && cur > d) {
					for (int j = prevIdx; j < q.peek(); j ++) {
						if (jacks[j]) jacks[j] = false;
					}
					prevIdx = q.peek();
					cur /= pieces[q.poll()];
				}
			}
		}
		
		int start = -1, startIdx = -1;
		for (int i = 0; i < n; i ++) {
			if (jacks[i]) { start = jackIdx[i]; startIdx = i; break; }
		}
		if (start == -1) {
			for (int i = 0; i < k; i ++) System.out.println("dust");
		} else {
			cur = 1; Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < start; i ++) System.out.println("dust");
			for (int i = n - 1; i >= startIdx; i --) {
				if (jacks[i]) s.push(cur);
				else cur *= pieces[i];
			}
			while (!s.isEmpty()) System.out.println(s.pop());
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
