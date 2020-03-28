import java.io.*;
import java.util.*;

public class TrivialMath {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		
		boolean bool = true;
		if (a + b <= c || a + c <= b || b + c <= a) bool = false;
		System.out.println(bool ? "yes" : "no");
	}
}
