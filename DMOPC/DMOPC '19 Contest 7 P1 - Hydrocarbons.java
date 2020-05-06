import java.io.*;
import java.util.*;

public class Hydrocarbons {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
		
		int carbon = a + b + c + 1;
		int available = carbon * 4;
		available -= a * 2;
		available -= b * 4;
		available -= c * 6;
		if (d != available) System.out.println("invalid");
		else System.out.println("C" + carbon + "H" + d);
	}
}
