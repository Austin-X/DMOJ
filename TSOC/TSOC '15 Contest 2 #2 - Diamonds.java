import java.io.*;
import java.util.*;

public class Diamonds {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int H = Integer.parseInt(br.readLine());
		
		int cn = H / 2;
		for (int i = 0; i < H; i ++) System.out.print("*");
		System.out.println();
		for (int i = 0; i < H / 2; i ++) {
			for (int j = 0; j < cn; j ++) {
				System.out.print("*");
			}
			for (int j = cn; j < H - cn; j ++) {
				System.out.print(" ");
			}
			for (int j = H - cn; j < H; j ++) {
				System.out.print("*");
			}
			System.out.println();
			cn --;
		}
		cn += 2;
		for (int i = H / 2 + 1; i < H - 1; i ++) {
			for (int j = 0; j < cn; j ++) {
				System.out.print("*");
			}
			for (int j = cn; j < H - cn; j ++) {
				System.out.print(" ");
			}
			for (int j = H - cn; j < H; j ++) {
				System.out.print("*");
			}
			System.out.println();
			cn ++;
		}
		for (int i = 0; i < H; i ++) System.out.print("*");
		System.out.println();
	}
}
