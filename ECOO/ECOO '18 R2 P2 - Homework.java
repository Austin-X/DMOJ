import java.util.*;
import java.io.*;

public class Homework {
	static class pair implements Comparable<pair> {
		int d;
		double w;

		public pair(int nextInt, double nextDouble) {
			d = nextInt; w = nextDouble;
		}

		public int compareTo(pair x) {
			return Double.compare(w, x.w);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt(), mx = 0; pair[] a = new pair[n];
			for (int i = 0; i < n; i ++) {
				a[i] = new pair(sc.nextInt(), sc.nextDouble());
				mx = Math.max(mx, a[i].d);
			}
			Arrays.sort(a, Collections.reverseOrder());

			int p[] = new int[mx + 1]; double ans = 0.0;
			for (int i = 0; i <= mx; i ++) {
				p[i] = i;
			}
			for (int i = 0; i < n; i ++) {
				int f = find(a[i].d, p);
				if (f != 0) {
					p[f] = f - 1; ans += a[i].w;
				}
			}
			System.out.format("%.4f %n", ans);
		}
	}

	static int find(int d, int p[]) {
		if (d != p[d]) p[d] = find(p[d], p);
		return p[d];
	}
}
