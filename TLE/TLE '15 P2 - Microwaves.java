import java.io.*;
import java.util.*;

public class Microwaves {
	static class Pair implements Comparable<Pair>{
		int t, f;
		Pair (int t, int f) { this.t = t; this.f = f; }
		public int compareTo(Pair p) { return Integer.compare(t, p.t); }
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), t = readInt();
		TreeSet<Pair> people = new TreeSet<Pair>(); 
		for (int i = 0; i < m; i ++) people.add(new Pair(readInt(), readInt()));

		TreeMap<Long, Integer> microwave = new TreeMap<Long, Integer>();
		microwave.put(0L, n);

		for (int i = 0; i < m; i ++) {
			if (people.first().t - microwave.firstKey() >= t) { System.out.println(microwave.firstKey()); System.exit(0); }
			long temp;
			if (microwave.floorKey((long)people.first().t) == null) {
				temp = microwave.firstKey();
				if (microwave.get(temp) == 1) microwave.remove(temp);
				else microwave.put(temp, microwave.get(temp) - 1);
				if (!microwave.containsKey(temp + people.first().f)) microwave.put(temp + people.pollFirst().f, 1);
				else microwave.put(temp + people.first().f, microwave.get(temp + people.pollFirst().f) + 1);
			} else {
				temp = microwave.floorKey((long)people.first().t);
				if (microwave.get(temp) == 1) microwave.remove(temp);
				else microwave.put(temp, microwave.get(temp) - 1);
				if (!microwave.containsKey((long)people.first().t + people.first().f)) microwave.put((long)people.first().t + people.pollFirst().f, 1);
				else microwave.put((long)people.first().t + people.first().f, microwave.get((long)people.first().t + people.pollFirst().f) + 1);
			} 
		}	
		
		System.out.println(microwave.firstKey());
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
