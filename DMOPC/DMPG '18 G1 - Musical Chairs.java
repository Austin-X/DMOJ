import java.io.*;
import java.util.*;

public class MusicalChairs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		boolean[] empty = new boolean[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i ++) empty[Integer.parseInt(st.nextToken())] = true;
		int[] students = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= k + 1; i ++) students[Integer.parseInt(st.nextToken())] = i;
		
		Stack<Integer> s = new Stack<Integer>();
		int idx = 1, cn = 0;
		while (true) {
			if (students[idx] != 0) { int temp = students[idx]; students[idx] = 0; s.push(temp); }
			if (empty[idx] && !s.isEmpty()) { empty[idx] = false; s.pop(); cn ++; }
			if (cn == k) break;
			idx ++;
			if (idx == n + 1) idx = 1;
		}
		System.out.println(s.peek());
	}
}
