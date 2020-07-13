import java.io.*;
import java.util.*;

public class Patrik {
	static class Node {
		int val, cnt;
		Node (int val, int cnt) { this.val = val; this.cnt = cnt; }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long ans = 0;
		Stack<Node> s = new Stack<Node>();
		for (int i = 0; i < n; i ++) {
			int x = Integer.parseInt(br.readLine());
			while (!s.isEmpty()) {
				if (x > s.peek().val) ans += s.pop().cnt;
				else break;
			}
			int cnt = 0;
			while (!s.isEmpty()) {
				if (x == s.peek().val) { ans += s.peek().cnt; cnt = s.peek().cnt; s.pop(); }
				else { ans ++; break; }
			}

			s.push(new Node(x, cnt + 1));
		}

		System.out.println(ans);
	}
}
