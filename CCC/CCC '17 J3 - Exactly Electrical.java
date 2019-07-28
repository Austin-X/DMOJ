import java.io.*;
import java.util.*;

public class ExactlyElectrical {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int diff = Math.abs(a - c) + Math.abs(b - d);
		int t = Integer.parseInt(br.readLine());

		if (diff <= t) {
			if (diff % 2 == 0) {
				System.out.println(t % 2 == 0 ? "Y" : "N");
			} else {
				System.out.println(t % 2 == 1 ? "Y" : "N");
			}
		} else System.out.println("N");
	}
}
