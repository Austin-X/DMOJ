import java.io.*;
import java.util.*;

public class Cookies {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] xCoor = new int[n], yCoor = new int[n];
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			xCoor[i] = Integer.parseInt(st.nextToken()); yCoor[i] = Integer.parseInt(st.nextToken());
		}
		
		double ans = 0;
		for (int i = 0; i < n; i ++) {
			for (int j = i + 1; j < n; j ++) {
				for (int k = j + 1; k < n; k ++) {
					double a = Math.sqrt(Math.pow(xCoor[i] - xCoor[j], 2) + Math.pow(yCoor[i] - yCoor[j], 2));
					double b = Math.sqrt(Math.pow(xCoor[i] - xCoor[k], 2) + Math.pow(yCoor[i] - yCoor[k], 2));
					double c = Math.sqrt(Math.pow(xCoor[j] - xCoor[k], 2) + Math.pow(yCoor[j] - yCoor[k], 2));
					double s = (a + b + c) / 2;

					double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
					double radiusOfCircumscribedCircle;
					
					// Considering case where area = 0 (when all three points are in a line)
					if (area == 0) radiusOfCircumscribedCircle = Math.max(Math.max(a, b), c) / 2;
					// Considering case where triangle formed is obtuse
					else if (Math.acos((b * b + c * c - a * a) / (2 * b * c)) > Math.PI / 2 || Math.acos((a * a + c * c - b * b) / (2 * a * c)) > Math.PI / 2 || Math.acos((a * a + b * b - c * c) / (2 * a * b)) > Math.PI / 2) {
						radiusOfCircumscribedCircle = Math.max(Math.max(a, b), c) / 2;
					}
					// Considering case where triangle formed is a right triangle or acute
					else radiusOfCircumscribedCircle = (a * b * c) / (4 * area);
	
					ans = Math.max(ans, radiusOfCircumscribedCircle * 2);
				}
			}
		}
		
		System.out.format("%.2f", ans);
	}
}
