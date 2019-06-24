import java.io.*;
import java.util.*;

public class BusJam {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int minuteBreaks = 0;
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
		
		Integer[] busTimes = new Integer[n];
		for (int i = 0; i < n; i ++) busTimes[i] = Integer.parseInt(br.readLine());
		Arrays.sort(busTimes, Collections.reverseOrder());
		
		for (int i = 0; i < n - 1; i ++) {
			while (busTimes[i] - busTimes[i + 1] > h) {
				minuteBreaks ++;
				busTimes[i + 1] += m;
			}
		}
		
		System.out.println(minuteBreaks);
	}
}
