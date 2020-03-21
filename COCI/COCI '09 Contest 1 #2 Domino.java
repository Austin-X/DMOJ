import java.io.*;
import java.util.*;

public class Domino {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 1; i <= n; i ++) ans += i;
		for (int i = 1; i <= n; i ++) 
			for (int j = i; j <= n; j ++) 
				ans += (i + j);
		System.out.println(ans);
	}
}
