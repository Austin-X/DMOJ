import java.io.*;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Necroposting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String date1 = readLine().replaceAll("/", "-"), date2 = readLine().replaceAll("/", "-");
		LocalDate commentDate = LocalDate.parse(date1), replyDate = LocalDate.parse(date2);
		int daysElapsed = (int) ChronoUnit.DAYS.between(commentDate, replyDate);
		System.out.println(daysElapsed);
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
