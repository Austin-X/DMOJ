import java.io.*;
import java.util.*;

public class AliceThroughTheLookingGlass {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t ++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(crystal(x, y, m)) System.out.println("crystal");
			else System.out.println("empty");
		}
	}
	
	static boolean crystal(int x, int y, int m) {
		int quadrantX = (int)(x / Math.pow(5, m - 1));
		int quadrantY = (int)(y / Math.pow(5, m - 1));
		int remX = (int)(x % Math.pow(5, m - 1)), remY = (int)(y % Math.pow(5, m - 1));
		
		if ((quadrantX >= 1 && quadrantX <= 3 && quadrantY == 0) || quadrantX == 2 && quadrantY == 1) return true;
		else if (quadrantX == 1 && quadrantY == 1 || quadrantX == 3 && quadrantY == 1 || quadrantX == 2 && quadrantY == 2) {
			return crystal(remX, remY, m - 1);
		}
		return false;
	} 
}
