import java.io.*;
import java.util.*;

public class Coci {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[] score1 = new int[n], score2 = new int[n];
		
		int[][] psa = new int[651][651];
		int[][] cn = new int[651][651];
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			score1[i] = Integer.parseInt(st.nextToken()); score2[i] = Integer.parseInt(st.nextToken());
			psa[score1[i]][score2[i]] ++;
			cn[score1[i]][score2[i]] ++;
		}
		
		for (int i = 0; i <= 650; i ++) {
			for (int j = 0; j <= 650; j ++) {
				if (i == 0 && j == 0) continue;
				else if (i == 0) psa[i][j] += psa[i][j - 1];
				else if (j == 0) psa[i][j] += psa[i - 1][j];
				else psa[i][j] += psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1];
			}
		}

		int high, low;
		for (int i = 0; i < n; i ++) {
			high = n - psa[650][score2[i]] - psa[score1[i]][650] + psa[score1[i]][score2[i]] + 1;

			if (score1[i] == 0 || score2[i] == 0) low = n;
			else low = n - psa[score1[i] - 1][score2[i] - 1];
			if (score2[i] == 650) low -= cn[score1[i]][0];
			if (score1[i] == 650) low -= cn[0][score2[i]];
			
			System.out.println(high + " " + low);
		}
	}
}
