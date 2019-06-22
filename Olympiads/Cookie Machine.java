import java.io.*;
import java.util.*;

public class CookieMachine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		double T = Integer.parseInt(st.nextToken()) + 0.5;
		
		System.out.println((int)(T / b) * a);
	}
}
