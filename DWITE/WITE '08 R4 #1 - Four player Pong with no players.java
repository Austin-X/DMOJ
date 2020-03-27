import java.io.*;

public class FourPlayerPongWithNoPlayers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 5; t ++) {
			int h = Integer.parseInt(br.readLine()), v = Integer.parseInt(br.readLine());
			
			int xDis = Integer.MAX_VALUE, yDis = Integer.MAX_VALUE;
			if (h != 0) xDis = Math.abs(50 / h);
			if (v != 0) yDis = Math.abs(25 / v);
			
			if (xDis < yDis) {
				int ansY = 25 + v * xDis;
				if (yDis == Integer.MAX_VALUE) ansY = 25;
				
				if (h > 0) System.out.println(100 + "," + ansY);
				else System.out.println(0 + "," + ansY);
			} else {
				int ansX = 50 + h * yDis;
				if (xDis == Integer.MAX_VALUE) ansX = 50;
				
				if (v > 0) System.out.println(ansX + "," + 50);
				else System.out.println(ansX + "," + 0);
			}
		}
	}
}
