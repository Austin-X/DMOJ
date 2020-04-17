import java.io.*;
import java.util.*;

public class LOL {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int minX = 1001, maxX = -1001, minY = 1001, maxY = -1001;
		StringTokenizer st;
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			minX = Math.min(x, minX); maxX = Math.max(x, maxX);
			minY = Math.min(y, minY); maxY = Math.max(y, maxY);
		}
		
		System.out.println((maxX - minX) * (maxY - minY));
	}
}
