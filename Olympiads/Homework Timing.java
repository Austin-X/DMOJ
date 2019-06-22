import java.io.*;
import java.util.*;

public class HomeworkTiming {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if ((d == 11 && h == 11 && m < 11) || (d == 11 && h < 11) || d < 11) {
			System.out.println(-1); System.exit(0);
		} 
		
		int dayDiff = d - 11; int hourDiff = h - 11; int minDiff = m - 11;
		
		System.out.println(1440 * dayDiff + 60 * hourDiff + minDiff);
	}
}
