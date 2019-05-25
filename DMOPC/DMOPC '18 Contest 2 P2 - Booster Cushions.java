import java.util.*;

public class BoosterCushions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int rows = sc.nextInt();
		int cols = sc.nextInt();
		long k = sc.nextLong();
		ArrayList<Long> people = new ArrayList<Long>();
		int colsRequired = (int) Math.ceil((double) k / rows);
		long[][] seats = new long[rows][colsRequired];
		int peopleCount = colsRequired;
		long boosterCushions = 0;

		for (int i = 0; i < k; i++) {
			people.add(sc.nextLong());
		}
		Collections.sort(people, Collections.reverseOrder());

		for (int i = 0; i < colsRequired; i++) {
			seats[0][i] = people.get(i);
		}

		if (rows > 1) {
			outerloop: for (int i = 0; i < colsRequired; i++) {
				for (int j = 1; j < rows; j++) {
					if (peopleCount == people.size()) break outerloop;
					seats[j][i] = people.get(peopleCount);
					peopleCount++;
				}
			}

			for (int i = 0; i < seats.length - 1; i++) {
				for (int j = 0; j < colsRequired; j++) {
					if (seats[i + 1][j] != 0) {
						boosterCushions += seats[i][j] - seats[i + 1][j] + 1;
						seats[i + 1][j] = seats[i][j] + 1;
					}
				}
			}
		}

		System.out.println(boosterCushions);
	}
}
