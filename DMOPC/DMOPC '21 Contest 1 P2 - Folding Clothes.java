import java.io.*;
import java.util.*;

public class FoldingClothes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), moves = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		for (int i = n - 1; i >= 0; i --) s.push(arr[i]);
		Arrays.parallelSort(arr);
		int idx = n - 1, cur;
		
		if (n == 1) { System.out.println(0); System.exit(0); }
		
		while (s.size() != 2) {
			Stack<Integer> temp = new Stack<Integer>();
			cur = arr[idx];
			
			while (!s.isEmpty()) {
				int x = s.pop();
				temp.push(x);
				if (x == cur) break;
			}
			ans.add(temp.size());
			moves ++;
			if (temp.size() != 1) { moves ++; ans.add(-temp.size() + 1); }
			idx --;
			temp.pop();
			while (!temp.isEmpty()) s.push(temp.pop());
		}
		
		int x = s.pop(), y = s.pop();
		if (x >= y) {
			moves += 3;
			ans.add(1); ans.add(1); ans.add(-n);
		} else {
			moves += 2;
			ans.add(2); ans.add(-n);
		}
		System.out.println(moves);
		for (int v: ans) System.out.println(v);
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
