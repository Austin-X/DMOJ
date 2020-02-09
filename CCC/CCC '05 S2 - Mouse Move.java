import java.io.*;
import java.util.*;

public class MouseMove {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
		
		int a = -1, b = -1, curX = 0, curY = 0;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); 
			b = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0) break;
			
			if (curX + a > c) curX = c;
			else if (curX + a < 0) curX = 0;
			else curX += a;
			
			if (curY + b > r) curY = r;
			else if (curY + b < 0) curY = 0;
			else curY += b;
			
			System.out.println(curX + " " + curY);
		}
	}
}
