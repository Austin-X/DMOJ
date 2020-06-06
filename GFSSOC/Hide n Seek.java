import java.io.*;
import java.util.*;

public class HideNSeek {
	static char[][] map;
	static int[][][][] minDis;
	static int n, m;
	static ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> hiderX = new ArrayList<Integer>(), hiderY = new ArrayList<Integer>();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		int startX = 0, startY = 0;
		
		for (int i = 0; i < n; i ++) map[i] = br.readLine().toCharArray();
		outerloop: for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				if (map[i][j] == 'G') { startX = i; startY = j; }
				else if (map[i][j] == 'H') { hiderX.add(i); hiderY.add(j); }
			}
		}
		
		minDis = new int[n][m][n][m];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				for (int k = 0; k < n; k ++) {
					for (int l = 0; l < m; l ++) {
						minDis[i][j][k][l] = Integer.MAX_VALUE;
					}
				}
				minDis[i][j][i][j] = 0;
				compute(i, j, i, j);
			}
		}

		generate(hiderX.size(), new ArrayList<Integer>());

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < permutations.size(); i ++) {
			int temp = minDis[startX][startY][hiderX.get(permutations.get(i).get(0))][hiderY.get(permutations.get(i).get(0))];
			for (int j = 1; j < permutations.get(i).size(); j ++) temp += minDis[hiderX.get(permutations.get(i).get(j - 1))][hiderY.get(permutations.get(i).get(j - 1))][hiderX.get(permutations.get(i).get(j))][hiderY.get(permutations.get(i).get(j))];
			ans = Math.min(ans, temp);
		}
		System.out.println(ans);
	}

	static void compute(int startX, int startY, int x, int y) {
		if (x > 0 && map[x - 1][y] != 'X' && minDis[startX][startY][x][y] + 1 < minDis[startX][startY][x - 1][y]) {
			minDis[startX][startY][x - 1][y] = minDis[startX][startY][x][y] + 1; compute(startX, startY, x - 1, y);
		}
		if (x < n - 1 && map[x + 1][y] != 'X' && minDis[startX][startY][x][y] + 1 < minDis[startX][startY][x + 1][y]) {
			minDis[startX][startY][x + 1][y] = minDis[startX][startY][x][y] + 1; compute(startX, startY, x + 1, y);
		}
		if (y > 0 && map[x][y - 1] != 'X' && minDis[startX][startY][x][y] + 1 < minDis[startX][startY][x][y - 1]) {
			minDis[startX][startY][x][y - 1] = minDis[startX][startY][x][y] + 1; compute(startX, startY, x, y - 1);
		}
		if (y < m - 1 && map[x][y + 1] != 'X' && minDis[startX][startY][x][y] + 1 < minDis[startX][startY][x][y + 1]) {
			minDis[startX][startY][x][y + 1] = minDis[startX][startY][x][y] + 1; compute(startX, startY, x, y + 1);
		}
	}
	
	static void generate(int n, ArrayList<Integer> arr) {
		if (arr.size() == hiderX.size()) {
			@SuppressWarnings("unchecked")
			ArrayList<Integer> temp = (ArrayList<Integer>) arr.clone();
			permutations.add(temp);
		}
		for (int i = 0; i < n; i ++) {
			if (!arr.contains(i)) { arr.add(i); generate(n, arr); arr.remove(arr.size() - 1); }
		}
	}
}
