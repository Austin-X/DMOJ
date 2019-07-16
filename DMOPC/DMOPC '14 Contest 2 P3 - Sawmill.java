import java.io.*;
import java.util.*;

public class Sawmill {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Integer[] saws = new Integer[n], logs = new Integer[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) saws[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) logs[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(logs, Collections.reverseOrder());
		Arrays.sort(saws);
		long ans = 0;
		
		for (int i = 0; i < n; i ++) {
			ans += saws[i] * logs[i];
		}
		System.out.println(ans);
	}
}
