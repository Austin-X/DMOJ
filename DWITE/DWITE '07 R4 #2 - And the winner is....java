import java.util.*;
import java.io.*;

public class AndTheWinnerIs {
	static class pair implements Comparable<pair> {
		int score;
		String name;

		public pair(int s, String n) {
			score = s;
			name = n;
		}

		public int compareTo(pair o) {
			if (Integer.compare(score, o.score) != 0)
				return Integer.compare(score, o.score);
			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			ArrayList<pair> lines = new ArrayList<pair>();
			for (int j = 0; j < 5; j++) {
				String[] data = br.readLine().split(" ", 2);
				lines.add(new pair(Integer.parseInt(data[0]), data[1]));
			}
			Collections.sort(lines);
			Collections.reverse(lines);

			for (pair x : lines) {
				System.out.println(x.name);
			}
		}
	}
}
