import java.util.*;
import java.io.*;

public class KeepingScore {
	public static int howMuchExtra(String x) {
		if (x.length() == 0) return 3;
		else if (x.length() == 1) return 2;
		else if (x.length() == 2) return 1;
		return 0;
	}
	
	public static int calcTotal(String x, int n) {
		int temp = 0;
		for (int i = 0; i < x.length(); i ++) {
			switch (x.charAt(i)) {
			case 'A' : temp += 4; break;
			case 'K' : temp += 3; break;
			case 'Q' : temp += 2; break;
			case 'J' : temp ++; break;
			}
		}
		return temp;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList <String> deckOfCards = new ArrayList<String>();
		
		String deck = br.readLine();
		String substring = "";
		int clubsCn = 0, diamondsCn = 0, heartsCn = 0, spadesCn = 0, totalCn = 0;
		
		for (int i = 0; i < deck.length(); i ++) {
			if (deck.charAt(i) == 'C') substring = "";
			else if (deck.charAt(i) == 'D' || deck.charAt(i) == 'H' || deck.charAt(i) == 'S') {
				deckOfCards.add(substring);
				substring = "";
			}
			else if (i == deck.length() - 1) {
				substring += deck.charAt(i);
				deckOfCards.add(substring);
			}
			else {
				substring += deck.charAt(i);
			}
		}
		
		clubsCn = calcTotal(deckOfCards.get(0), deckOfCards.get(0).length());
		clubsCn += howMuchExtra(deckOfCards.get(0));
		diamondsCn = calcTotal(deckOfCards.get(1), deckOfCards.get(1).length());
		diamondsCn += howMuchExtra(deckOfCards.get(1));
		
		heartsCn = calcTotal(deckOfCards.get(2), deckOfCards.get(2).length());
		heartsCn += howMuchExtra(deckOfCards.get(2));
		
		if (deckOfCards.size() != 3) {
			spadesCn = calcTotal(deckOfCards.get(3), deckOfCards.get(3).length());
			spadesCn += howMuchExtra(deckOfCards.get(3));
		} else {
			spadesCn = 3;
		}
		
		System.out.format("%-10s %15s %n", "Cards Dealt", "Points");
		System.out.print("Clubs ");
		for (int i = 0; i < deckOfCards.get(0).length(); i ++) System.out.print(deckOfCards.get(0).charAt(i) + " ");
		System.out.format("%9s %n", clubsCn);
		
		System.out.print("Diamonds ");
		for (int i = 0; i < deckOfCards.get(1).length(); i ++) System.out.print(deckOfCards.get(1).charAt(i) + " ");
		System.out.format("%9s %n", diamondsCn);
		
		System.out.print("Hearts ");
		for (int i = 0; i < deckOfCards.get(2).length(); i ++) System.out.print(deckOfCards.get(2).charAt(i) + " ");
		System.out.format("%9s %n", heartsCn);
		
		if (deckOfCards.size() == 4) {
			System.out.print("Spades ");
			for (int i = 0; i < deckOfCards.get(3).length(); i ++) System.out.print(deckOfCards.get(3).charAt(i) + " ");
			System.out.format("%9s %n", spadesCn);
		} else System.out.println("Spades     3");
		
		totalCn = clubsCn + diamondsCn + heartsCn + spadesCn;
		System.out.format("%14s %16s %n", "Total", totalCn);
	}
}
