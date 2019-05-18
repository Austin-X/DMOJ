import java.util.*;
import java.io.*;

public class Tiles {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());
		System.out.println((int)(Math.floor(w * 1.0 / s) * Math.floor(l * 1.0 / s)));
	}
}
