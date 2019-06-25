import java.io.*;
import java.util.*;

public class TradingCards {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int aliceCards = Integer.parseInt(br.readLine());
		int[] aliceValues = new int[aliceCards];
		int aliceValue = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < aliceCards; i ++) aliceValues[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < aliceCards; i ++) aliceValue += aliceValues[i] * Integer.parseInt(st.nextToken());
		
		int carlCards = Integer.parseInt(br.readLine());
		int[] carlValues = new int[carlCards];
		int carlValue = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < carlCards; i ++) carlValues[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < carlCards; i ++) carlValue += carlValues[i] * Integer.parseInt(st.nextToken());
		
		System.out.println(aliceValue + " " + carlValue);
	}
}
