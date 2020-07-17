import java.io.*;
import java.util.*;

public class SumMaximization {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			String nStr = st.nextToken(), s = st.nextToken();

			if (nStr.length() < 2 && s.length() < 2) { System.out.println(Long.parseLong(s)); continue; }
			int len = s.length();
			int[] arr = new int[len], arrN = new int[len];
			for (int j = 0; j < len; j ++) arr[j] = Character.getNumericValue(s.charAt(j));
			
			int x = nStr.length(), idx = 0;
			for (int j = 0; j < len; j ++) {
				if (x >= len) {
					arrN[j] = Character.getNumericValue(nStr.charAt(idx)); idx ++;
				}
				else arrN[j] = 0;
				x ++;
			}
			
			int ans = 0;
			for (int j = 0; j < len; j ++) {
				if (arr[j] > arrN[j]) {
					int temp = ans + arr[j];
					for (int k = j + 1; k < len; k ++) temp += arr[k];
					
					ans += arr[j] - 1;
					for (int k = j + 1; k < len; k ++) ans += 9;
					ans = Math.max(ans, temp);
					break;
				} else ans += arr[j];
			}
			
			System.out.println(ans);
		}
	}
}
