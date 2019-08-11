import java.io.*;
import java.util.*;

public class BattlePositions {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int I = Integer.parseInt(br.readLine());
		long N = Long.parseLong(br.readLine());
		int J = Integer.parseInt(br.readLine());
		
		long[] diff = new long[I + 2];
		for (int i = 0; i < J; i ++) {
			st = new StringTokenizer(br.readLine());
			int xi = Integer.parseInt(st.nextToken());
			int xf = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			diff[xi] += k;
			diff[xf + 1] -= k;
		}
		
		for (int i = 1; i <= I; i ++) diff[i] += diff[i - 1];
		int ans = 0;
		for (int i = 1; i <= I; i ++) ans += diff[i] < N ? 1 : 0;
		System.out.println(ans);
	}
}
