import java.io.*;
import java.util.*;

public class Buka {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		int zeroCn = A.length() - 1;
		
		char operand = br.readLine().charAt(0);
		String B = br.readLine();
		int zeroCn2 = B.length() - 1;
		
		if (operand == '*') {
			int tot = zeroCn + zeroCn2;
			System.out.print(1);
			for (int i = 0; i < tot; i ++) System.out.print(0);
		} else {
			if (zeroCn == zeroCn2) {
				System.out.print(2);
				for (int i = 0; i < zeroCn; i ++) System.out.print(0);
			} else {
				int max = Math.max(zeroCn, zeroCn2);
				int min = Math.min(zeroCn, zeroCn2);
				System.out.print(1);
				for (int i = max; i >= 1; i --) {
					if (i == min + 1) System.out.print(1);
					else System.out.print(0);
				}
			}
		}
		System.out.println();
	}
}
