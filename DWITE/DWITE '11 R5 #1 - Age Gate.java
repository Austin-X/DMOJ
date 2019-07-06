import java.io.*;
import java.util.*;

public class AgeGate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 5; t ++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			boolean tooYoung = false;
			
			if (year == 1997) {
				if (month == 10) {
					if (day > 27) {
						tooYoung = true;
					}
				} else if (month > 10) {
					tooYoung = true;
				}
			} else if (year > 1997) {
				tooYoung = true;
			} 
			System.out.println(tooYoung ? "too young" : "old enough");
		}
	}
}
