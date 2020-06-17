import java.io.*;
import java.util.*;

public class ExpensiveChariStacking {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		
		int[] xCoor = new int[n], yCoor = new int[n];
		long xSum = 0, ySum = 0;
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			xCoor[i] = Integer.parseInt(st.nextToken()); yCoor[i] = Integer.parseInt(st.nextToken());
			xSum += xCoor[i]; ySum += yCoor[i];
		}
		
		double xTemp = (double)xSum / n, yTemp = (double)ySum / n;
		int xAns = m - xTemp < xTemp ? 1 : m, yAns = m - yTemp < yTemp ? 1 : m;
		
		long ans = 0;
		for (int i = 0; i < n; i ++) {
			ans += Math.abs(xAns - xCoor[i]) + Math.abs(yAns - yCoor[i]);
		}
		System.out.println(ans);
	}
}
