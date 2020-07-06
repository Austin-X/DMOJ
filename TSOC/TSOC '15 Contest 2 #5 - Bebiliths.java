import java.io.*;
import java.util.*;

public class Bebiliths {
	static int s;
	
	static class Bebilith implements Comparable<Bebilith> {
		int speed, venom, claw, idx;
		
		Bebilith(int speed, int venom, int claw, int idx) {
			this.speed = speed;
			this.venom = venom;
			this.claw = claw;
			this.idx = idx;
		}
		
		public int compareTo(Bebilith b) {
			if (speed > b.speed) return 1;
			else if (speed < b.speed) return -1;
			else {
				if (speed >= s) {
					if (claw > b.claw) return 1;
					else if (claw < b.claw) return -1;
					else return -Integer.compare(idx, b.idx);
				} else {
					if (venom > b.venom) return 1;
					else if (venom < b.venom) return -1;
					else return -Integer.compare(idx, b.idx);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		s = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Bebilith> arr = new ArrayList<Bebilith>();
		for (int i = 1; i <= n; i ++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Bebilith(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
		}
		Collections.sort(arr);

		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i ++) {
			int x = Integer.parseInt(br.readLine());
			System.out.println(arr.get(arr.size() - x).idx);
		}
	}
}
