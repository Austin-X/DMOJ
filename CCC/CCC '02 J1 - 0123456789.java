package ccc;

import java.io.*;
import java.util.*;

public class Zero123456789 {
	static void line() {
		System.out.println();
	}
	
	static void dash() {
		System.out.println(" * * *");
	}
	
	static void twoSide() {
		for (int i = 0; i < 3; i ++) System.out.println("*     *");
	}
	
	static void rightSide() {
		for (int i = 0; i < 3; i ++) System.out.println("      *");
	}
	
	static void leftSide() {
		for (int i = 0; i < 3; i ++) System.out.println("*");
	}
	
	static void one() {
		for (int i = 0; i < 3; i ++) System.out.println("   *");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if (n == 0) {
			dash(); twoSide(); line(); twoSide(); dash();
		} else if (n == 1) {
			one(); line(); one(); line();
		} else if (n == 2) {
			dash(); rightSide(); dash(); leftSide(); dash();
		} else if (n == 3) {
			dash(); rightSide(); dash(); rightSide(); dash();
		} else if (n == 4) {
			twoSide(); dash(); rightSide(); line();
		} else if (n == 5) {
			dash(); leftSide(); dash(); rightSide(); dash();
		} else if (n == 6) {
			dash(); leftSide(); dash(); twoSide(); dash();
		} else if (n == 7) {
			dash(); rightSide(); line(); rightSide();
		} else if (n == 8) {
			dash(); twoSide(); dash(); twoSide(); dash();
		} else if (n == 9) {
			dash(); twoSide(); dash(); rightSide(); dash();
		}
	}
}
