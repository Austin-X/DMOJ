import java.io.*;
import java.util.*;

public class GuessingGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
		int idx = -1, cn = 0;
		while (true) {
			idx = (x + y) / 2;
			cn ++;
			if (idx < n) x = idx;
			else if (idx > n) y = idx;
			else break;
		}
		System.out.println(cn);
	}
}
