import java.io.*;
import java.util.*;

public class Cameras {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		boolean[] cameras = new boolean[n + 1];
		int cn = 0, sum = 0;
		
		for (int i = 0; i < k; i ++) {
			int x = Integer.parseInt(br.readLine());
			cameras[x] = true;
		}
		
		for (int i = 1; i <= r; i ++) {
			if (cameras[i]) sum ++;
		}
		if (sum == 0) {
			cameras[r] = true;
			cameras[r - 1] = true;
			cn += 2;
			sum += 2;
		}
		else if (sum == 1) {
			if (cameras[r]) {
				cameras[r - 1] = true;
			}
			else {
				cameras[r] = true;
			}
			cn ++;
			sum ++;
		}
		
		for (int i = 2; i <= i + r && i + r - 1 <= n; i ++) {
			if (cameras[i - 1]) sum --;
			if (cameras[i + r - 1]) sum ++;
			
			if (sum == 0) {
				cameras[i + r - 1] = true;
				cameras[i + r - 2] = true;
				cn += 2;
				sum += 2;
			}
			else if (sum == 1) {
				if (cameras[i + r - 1]) {
					cameras[i + r - 2] = true;
				}
				else {
					cameras[i + r - 1] = true;
				}
				cn ++;
				sum ++;
			}
		}

		System.out.println(cn);
	}
}
