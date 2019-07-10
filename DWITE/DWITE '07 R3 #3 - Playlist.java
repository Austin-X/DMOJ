import java.io.*;
import java.util.*;

public class Playlist {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 5; t ++) {
			int totalSpace = Integer.parseInt(br.readLine());
			int size = Integer.parseInt(br.readLine());
			
			int[] rating = new int[size];
			int[] space = new int[size];
			for (int i = 0; i < size; i ++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				rating[i] = Integer.parseInt(st.nextToken());
				space[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			
			for (int i = 1, up = 1 << size; i < up; i ++) {
				int tempMax = 0, tempSize = 0;
				for (int j = 0; j < size; j ++) {
					if ((i & (1 << j)) != 0) {
						tempMax += rating[j];
						tempSize += space[j];
					}
				}
				if (tempSize <= totalSpace) max = Math.max(max, tempMax);
			}
			
			System.out.println(max);
		}
	}
}
