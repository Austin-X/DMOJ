import java.io.*;
import java.util.*;

public class TopCourses {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Pair implements Comparable<Pair> {
		String course;
		int grade;
		Pair (String course, int grade) { this.course = course; this.grade = grade; }
		
		public int compareTo(Pair p) { return -Integer.compare(grade, p.grade); }
	}
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), c = readInt(), m = readInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < n; i ++) {
			String temp = "";
			String str = readLine();
			int num = 0;
			for (int j = 0; j < str.length(); j ++) {
				if (Character.isDigit(str.charAt(j))) {
					num = Integer.parseInt(str.substring(j));
					break;
				}
				temp += str.charAt(j);
			}
			temp = temp.trim();
			map.put(temp, num);
		}
		
		double total = 0;
		for (int i = 0; i < m; i ++) {
			String x = readLine();
			if (map.containsKey(x)) {
				total += map.get(x);
				map.remove(x);
			} else {
				System.out.println("Ace is dunzos"); 
				System.exit(0); 
			}
		}
		
		ArrayList<Pair> x = new ArrayList<Pair>();
		for (String s : map.keySet()) x.add(new Pair(s, map.get(s)));
		Collections.sort(x);
		
		if (n < c) { System.out.println("Ace is dunzos"); System.exit(0); }
		for (int i = 0; i < c - m; i ++) {
			total += x.get(i).grade;
		}

		System.out.printf("%.2f%n", total/c);
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
