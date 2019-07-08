import java.io.*;
import java.util.*;

public class ShipDefense {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double h = Double.parseDouble(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[][] defenses = new int[d][2];
		int e = Integer.parseInt(st.nextToken());
		int[][] enemies = new int[e][3];
		
		for (int i = 0; i < d; i ++) {
			st = new StringTokenizer(br.readLine());
			defenses[i][0] = Integer.parseInt(st.nextToken());
			defenses[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int maxSecond = 0;
		for (int i = 0; i < e; i ++) {
			st = new StringTokenizer(br.readLine());
			enemies[i][0] = Integer.parseInt(st.nextToken());
			enemies[i][1] = Integer.parseInt(st.nextToken());
			enemies[i][2] = Integer.parseInt(st.nextToken());
			if (enemies[i][0] + enemies[i][1] > maxSecond) maxSecond = (int) (enemies[i][0] + enemies[i][1]);
		}
		
		for (int i = 0; i < maxSecond; i ++) {
			double damage = 0;
			for (int j = 0; j < e; j ++) {
				if (i >= enemies[j][0] && i < enemies[j][0] + enemies[j][1]) {
					damage += enemies[j][2];
				}
			}
			
			double reduction = damage;
			for (int j = 0; j < d; j ++) {
				double cur = damage - defenses[j][1];
				double temp = cur - (cur  * ((double)defenses[j][0] / 100));
				if (temp < reduction) reduction = temp;
			}
			
			if (reduction < 0) reduction = 0;	
			h -= reduction;
		}
		
		if (h > 0) System.out.format("%.2f %n", h);
		else System.out.println("DO A BARREL ROLL!");
	}
}
