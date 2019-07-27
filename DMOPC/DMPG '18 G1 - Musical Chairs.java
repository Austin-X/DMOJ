import java.io.*;
import java.util.*;

public class MusicalChairs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] chairs = new boolean[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i ++) chairs[Integer.parseInt(st.nextToken())] = true;
		
		Stack<Integer> stack = new Stack <Integer>();
		int[] students = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= k + 1; i ++) {
			students[Integer.parseInt(st.nextToken())] = i;
		}
		
		while (stack.size() != 1) {
			for (int i = 1; i <= n; i ++) {
				if (chairs[i] && students[i] != 0) {
					chairs[i] = false;
					students[i] = 0;
				} else if (chairs[i] && !stack.empty()) {
					stack.pop(); chairs[i] = false;
				} else if (students[i] != 0) {
					stack.push(students[i]);
					students[i] = 0;
				} 
			}
		}

		System.out.println(stack.peek());
	}
}
