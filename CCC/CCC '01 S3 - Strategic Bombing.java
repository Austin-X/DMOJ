import java.io.*;
import java.util.*;

public class StrategicBombing {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		@SuppressWarnings("unchecked")
		ArrayList<Character>[] adj = new ArrayList[26];
		for (int i = 0; i < 26; i ++) adj[i] = new ArrayList<Character>();
		
		ArrayList<String> disconnecting = new ArrayList<String>();
		
		char char1, char2;
		String convert, input = "";
		while (true) {
			input = br.readLine();
			if (input.equals("**")) break;
			
			char[] chars = input.toCharArray();
			char1 = chars[0];
			char2 = chars[1];
			
			convert = String.valueOf(char1) + String.valueOf(char2);
			disconnecting.add(convert);
			
			adj[Integer.valueOf(char1) - 65].add(char2);
			adj[Integer.valueOf(char2) - 65].add(char1);
		}
		
		int ans = 0;
		
		Queue<Character> q;
		boolean[] visited;
		
		for (int i = 0; i < disconnecting.size(); i ++) {
			convert = disconnecting.get(i);
			char1 = convert.charAt(0);
			char2 = convert.charAt(1);
			
			adj[Integer.valueOf(char1) - 65].remove(adj[Integer.valueOf(char1) - 65].indexOf(char2));
			adj[Integer.valueOf(char2) - 65].remove(adj[Integer.valueOf(char2) - 65].indexOf(char1));
			
			q = new LinkedList<Character>();
			q.add('A');
			visited = new boolean[26];
			visited[0] = true;
			
			while (!q.isEmpty()) {
				char cur = q.poll();
				
				for (char x : adj[Integer.valueOf(cur) - 65]) {
					if (!visited[Integer.valueOf(x) - 65]) {
						visited[Integer.valueOf(x) - 65] = true;
						q.add(x);
					}
				}
			}
			
			if (!visited[1]) {
				System.out.println(convert); ans ++;
			}
			
			adj[Integer.valueOf(char1) - 65].add(char2);
			adj[Integer.valueOf(char2) - 65].add(char1);
		}
		
		System.out.println("There are " + ans + " disconnecting roads.");
	}
}
