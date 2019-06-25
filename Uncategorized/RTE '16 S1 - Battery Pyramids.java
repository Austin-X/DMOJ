import java.io.*;
import java.util.*;

public class BatteryPyramids {
	static ArrayList<Long> sum = new ArrayList<Long>();
	
	public static void calculate() {
		long cur = -1;
		long curSum= 0;
		int extra = 1;
		while (cur <= 1000000000) {
			curSum += extra;
			extra ++;
			
			if (extra > 2) sum.add(sum.get(extra - 3) + curSum);
			else sum.add(curSum);
			
			cur = sum.get(sum.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		calculate();
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i ++) {
			st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long k = Long.parseLong(st.nextToken());
			long diff = n - k;
			
			int cn = 0;
			while (diff >= sum.get(cn)) {
				cn ++;
			}
			System.out.println(sum.get(cn - 1));
		}
	}
}
