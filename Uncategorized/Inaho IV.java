import java.io.*;
import java.util.*;

public class InahoIV {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		double sum = 0;
		
		double[] coords1 = new double[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) coords1[i] = Double.parseDouble(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) sum += Math.pow((coords1[i] - Double.parseDouble(st.nextToken())), 2);
		
		double ans = Math.sqrt(sum);
		System.out.format("%.6f", ans);
	}
}
