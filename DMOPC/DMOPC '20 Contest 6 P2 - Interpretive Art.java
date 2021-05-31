import java.io.*;
import java.util.*;

public class InterpretiveArt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n + 1], b = new int[n + 1];
		
		Queue<Integer> zeroes = new LinkedList<Integer>();
		for (int i = 1; i <= n; i ++) {
			a[i] = readInt();
			if (a[i] == 0) zeroes.add(i);
		}
		for (int i = 1; i <= n; i ++) b[i] = readInt();
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		int bCnt = 0;
		for (int i = 1; i <= n; i ++) {
			if (b[i] == 1) {
				bCnt ++;	
			} else if (b[i] == 0 && bCnt > 0) {
				if (q.size() < bCnt) {
					System.out.println(-1);
					System.exit(0);
				}
				boolean flag = true;
				int l = q.peek(), r = i - 1;
				for (int j = i - bCnt; j < i; j ++) if (q.poll() != j) flag = false;
				
				if (!flag) {
					int size = q.size(); q.clear();
					if (zeroes.size() < size) {
						System.out.println(-1);
						System.exit(0);
					}
					for (int j = 0; j < size; j ++) { a[zeroes.peek()] = 1; r = zeroes.poll(); }
					res.add(l); res.add(r);
				}
				bCnt = 0;
			}
			
			if (a[i] == 1) q.add(i);
			if (!zeroes.isEmpty() && zeroes.peek() == i) zeroes.poll();
		}
		if (bCnt == 0 && q.size() > 0 || bCnt > 0 && q.size() != bCnt) {
			System.out.println(-1);
			System.exit(0);
		}
		if (bCnt > 0) {
			boolean flag = true;
			int l = q.peek();
			for (int i = n - bCnt + 1; i <= n; i ++) if (q.poll() != i) { flag = false; break; }
			if (!flag) {
				res.add(l); res.add(n);
			}
		}
		
		System.out.println(res.size() / 2);
		for (int i = 0; i < res.size() - 1; i += 2) {
			System.out.println(res.get(i) + " "  + res.get(i + 1));
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
