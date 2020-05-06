import java.io.*;
import java.util.*;

public class ContestFeedback {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Double a = Double.parseDouble(st.nextToken()), b = Double.parseDouble(st.nextToken()), c = Double.parseDouble(st.nextToken()), d = Double.parseDouble(st.nextToken());
		
		System.out.format("%.6f %n", (a + b) / 2);
		System.out.format("%.6f %n", (a + c) / 2);
		System.out.format("%.6f %n", (a + d) / 2);
		System.out.format("%.6f %n", (b + c) / 2);
		System.out.format("%.6f %n", (b + d) / 2);
		System.out.format("%.6f %n", (c + d) / 2);
		System.out.format("%.6f %n", (a + b + c) / 3);
		System.out.format("%.6f %n", (a + b + d) / 3);
		System.out.format("%.6f %n", (a + c + d) / 3);
		System.out.format("%.6f %n", (b + c + d) / 3);
		System.out.format("%.6f %n", (a + b + c + d) / 4);
	}
}
