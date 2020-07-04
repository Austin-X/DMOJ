import java.io.*;
import java.util.*;

public class BloodDistribution {
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] blood = new int[8], patients = new int[8];
		for (int i = 0; i < 8; i ++) blood[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 8; i ++) patients[i] = Integer.parseInt(st.nextToken());
		
		solve(0, 0, blood, patients);
		System.out.println(max);
	}
	
	static void solve(int idx, int score, int[] blood, int[] patients) {
		if (idx == 8) {
			max = Math.max(max, score); return;
		}
		
		int temp;
		if (idx == 0) {
			if (blood[0] >= patients[0]) { score += patients[0]; blood[0] -= patients[0]; solve(idx + 1, score, blood, patients); }
			else { score += blood[0]; blood[0] = 0; solve(idx + 1, score, blood, patients); }
		} else if (idx == 1) {
			if (blood[1] >= patients[1]) { score += patients[1]; blood[1] -= patients[1]; solve(idx + 1, score, blood, patients); }
			else { score += blood[1]; temp = patients[1] - blood[1]; blood[1] = 0;
				if (blood[0] >= temp) { score += temp; blood[0] -= temp; solve(idx + 1, score, blood, patients); }
				else { score += blood[0]; blood[0] = 0; solve(idx + 1, score, blood, patients); }
			}
		} else if (idx == 2) {
			if (blood[2] >= patients[2]) { score += patients[2]; blood[2] -= patients[2]; solve(idx + 1, score, blood, patients); }
			else {
				score += blood[2]; temp = patients[2] - blood[2]; blood[2] = 0;
				if (blood[0] >= temp) { score += temp; blood[0] -= temp; solve(idx + 1, score, blood, patients); }
				else { score += blood[0]; blood[0] = 0; solve(idx + 1, score, blood, patients); }
			}
		} else if (idx == 3) {
			if (blood[3] >= patients[3]) { score += patients[3]; blood[3] -= patients[3]; solve(idx + 1, score, blood, patients); }
			else {
				score += blood[3]; temp = patients[3] - blood[3]; int beforeTemp = temp; blood[3] = 0;
				int[] arrCopy = Arrays.copyOf(blood, 8);
				int beforeScore = score;
				if (blood[2] >= temp) { score += temp; blood[2] -= temp; solve(idx + 1, score, blood, patients); }
				else {
					score += blood[2]; temp -= blood[2]; blood[2] = 0;  
					if (blood[1] >= temp) { score += temp; blood[1] -= temp; solve(idx + 1, score, blood, patients); }
					else {
						score += blood[1]; temp -= blood[1]; blood[1] = 0;
						if (blood[0] >= temp) { score += temp; blood[0] -= temp; solve(idx + 1, score, blood, patients); }
						else { score += blood[0]; blood[0] = 0; solve(idx + 1, score, blood, patients); }
					}
				}
				
				blood = arrCopy;
				temp = beforeTemp; score = beforeScore;
				if (blood[1] >= temp) { score += temp; blood[1] -= temp; solve(idx + 1, score, blood, patients); }
				else { 
					score += blood[1]; temp -= blood[1]; blood[1] = 0; 
					if (blood[2] >= temp) { score += temp; blood[2] -= temp; solve(idx + 1, score, blood, patients); }
					else {
						score += blood[2]; temp -= blood[2]; blood[2] = 0;
						if (blood[0] >= temp) { score += temp; blood[0] -= temp; solve(idx + 1, score, blood, patients); }
						else { score += blood[0]; blood[0] = 0; solve(idx + 1, score, blood, patients); }
					}
				}
			}
		} else if (idx == 4) {
			if (blood[4] >= patients[4]) { score += patients[4]; blood[4] -= patients[4]; solve(idx + 1, score, blood, patients); }
			else {
				score += blood[4]; temp = patients[4] - blood[4]; blood[4] = 0;
				if (blood[0] >= temp) { score += temp; blood[0] -= temp; solve(idx + 1, score, blood, patients); }
				else { score += blood[0]; blood[0] = 0; solve(idx + 1, score, blood, patients); }
			}
		} else if (idx == 5) {
			if (blood[5] >= patients[5]) { score += patients[5]; blood[5] -= patients[5]; solve(idx + 1, score, blood, patients); }
			else {
				score += blood[5]; temp = patients[5] - blood[5]; blood[5] = 0;
				if (blood[1] >= temp) { score += temp; blood[1] -= temp; solve(idx + 1, score, blood, patients); }
				else {
					score += blood[1]; temp -= blood[1]; blood[1] = 0;
					if (blood[4] >= temp) { score += temp; blood[4] -= temp; solve(idx + 1, score, blood, patients); }
					else {
						score += blood[4]; temp -= blood[4]; blood[4] = 0;
						if (blood[0] >= temp) { score += temp; blood[0] -= temp; solve(idx + 1, score, blood, patients); }
						else {
							score += blood[0]; temp -= blood[0]; blood[0] = 0;
							solve(idx + 1, score, blood, patients); 
						}
					}
				}
			}
		} else if (idx == 6) {
			if (blood[6] >= patients[6]) { score += patients[6]; blood[6] -= patients[6]; solve(idx + 1, score, blood, patients); }
			else {
				score += blood[6]; temp = patients[6] - blood[6]; blood[6] = 0;
				if (blood[4] >= temp) { score += temp; blood[4] -= temp; solve(idx + 1, score, blood, patients); }
				else {
					score += blood[4]; temp -= blood[4]; blood[4] = 0;
					if (blood[2] >= temp) { score += temp; blood[2] -= temp; solve(idx + 1, score, blood, patients); }
					else {
						score += blood[2]; temp -= blood[2]; blood[2] = 0;
						if (blood[0] >= temp) { score += temp; blood[0] -= temp; solve(idx + 1, score, blood, patients); }
						else { score += blood[0]; blood[0] = 0; solve(idx + 1, score, blood, patients); }
					}
				}
			}
		} else if (idx == 7) {
			if (blood[7] >= patients[7]) { score += patients[7]; blood[7] -= patients[7]; solve(idx + 1, score, blood, patients); }
			else {
				score += blood[7]; temp = patients[7] - blood[7]; blood[7] = 0;
				if (blood[6] >= temp) { score += temp; blood[6] -= temp; solve(idx + 1, score, blood, patients); }
				else {
					score += blood[6]; temp -= blood[6]; blood[6] = 0;
					if (blood[5] >= temp) { score += temp; blood[5] -= temp; solve(idx + 1, score, blood, patients); }
					else {
						score += blood[5]; temp -= blood[5]; blood[5] = 0;
						if (blood[4] >= temp) { score += temp; blood[4] -= temp; solve(idx + 1, score, blood, patients); }
						else {
							score += blood[4]; temp -= blood[4]; blood[4] = 0;
							if (blood[3] >= temp) { score += temp; blood[3] -= temp; solve(idx + 1, score, blood, patients); }
							else {
								score += blood[3]; temp -= blood[3]; blood[3] = 0;
								if (blood[2] >= temp) { score += temp; blood[2] -= temp; solve(idx + 1, score, blood, patients); }
								else {
									score += blood[2]; temp -= blood[2]; blood[2] = 0;
									if (blood[1] >= temp) { score += temp; blood[1] -= temp; solve(idx + 1, score, blood, patients); }
									else {
										score += blood[1]; blood[1] -= temp; blood[1] = 0;
										if (blood[0] >= temp) { score += temp; blood[0] -= temp; solve(idx + 1, score, blood, patients); }
										else { score += blood[0]; temp -= blood[0]; blood[0] = 0; solve(idx + 1, score, blood, patients); }
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
