import java.io.*;
import java.util.*;

public class MimiAndBinary {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		char[] s = br.readLine().toCharArray();
		int n = s.length;
		ArrayList<Integer> zeros = new ArrayList<Integer>();
		ArrayList<Integer> ones = new ArrayList<Integer>();
		int[] zeroPsa = new int[n + 1];
		int[] onePsa = new int[n + 1];
		
		if (s[0] == '0') { zeroPsa[1] = 1; zeros.add(1); }
		else { onePsa[1] = 1; ones.add(1); }
		
		for (int i = 1; i < n; i ++) {
			if (s[i] == '0') { zeroPsa[i + 1] = zeroPsa[i] + 1; onePsa[i + 1] = onePsa[i]; zeros.add(i + 1); }
			else { onePsa[i + 1] = onePsa[i] + 1; zeroPsa[i + 1] = zeroPsa[i]; ones.add(i + 1); }
		}

		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if (z == 0) {
				if (zeroPsa[n] - zeroPsa[x - 1] >= y) {
					System.out.println(zeros.get(y + zeroPsa[x - 1] - 1));
				} else System.out.println(-1);
			} else {
				if (onePsa[n] - onePsa[x - 1] >= y) {
					System.out.println(ones.get(y + onePsa[x - 1] - 1));
				} else System.out.println(-1);
			}
		}
	}
}
