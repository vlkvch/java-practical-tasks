package lab.six;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		ChessBoard board = new ChessBoard((byte)8);
		System.out.print("Введите количество слонов:\n> ");
		Scanner in = new Scanner(System.in);
		byte n = in.nextByte();
		in.close();

		if (n < 0 || n > 8) {
			System.out.println("[!] Максимально может быть только 8 слонов.");
			return;
		}
		
		for (byte i = 0; i < n; i++)
			board.placeBishop();
		board.printBoard();
	}
}