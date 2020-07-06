import java.io.*;

public class FlipTheSwitches {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		
		boolean one = false;
		int ans = 0;
		if (ch[0] == '1') { ans = 1; one = true; }
		
		for (int i = 1; i < n; i ++) {
			if (!one) {
				if(ch[i] == '1') { one = true; ans += 2; }
			} else {
				if (ch[i] == '0') one = false;
			}
		}
		
		System.out.println(ans);
	}
}
