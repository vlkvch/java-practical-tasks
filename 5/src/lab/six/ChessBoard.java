package lab.six;

import java.util.Random;

public class ChessBoard {
	private byte     size;
	private byte[][] board;

	public ChessBoard(byte size) {
		this.size = size;
		this.board = new byte[size][size];
	}

	public void placeBishop() {
		Random rand = new Random();
		byte posX, posY;
		do {
			posX = (byte)rand.nextInt(size);
			posY = (byte)rand.nextInt(size);
		} while (!Bishop.canBePlaced(posX, posY, board));

		board[posY][posX] = 1;

		byte up = (byte)(posY - 1);
		byte down = (byte)(posY + 1);
		
		for (byte i = (byte)(posX + 1); i < size; i++) {
			if (up >= 0) {
				board[up][i] = 2;
				up--;
			}
			if (down < size) {
				board[down][i] = 2;
				down++;
			}
		}

		up = (byte)(posY - 1);
		down = (byte)(posY + 1);

		for (byte i = (byte)(posX - 1); i >= 0; i--) {
			if (up >= 0) {
				board[up][i] = 2;
				up--;
			}
			if (down < size) {
				board[down][i] = 2;
				down++;
			}
		}
	}

	public void printBoard() {
		String borders = "-".repeat(size * 2);
		byte number = 8;
		System.out.printf("  +-%s+\n", borders);
		for (byte i = 0; i < size; i++) {
			System.out.printf("%d | ", number);
			for (byte j = 0; j < size; j++) {
				if (board[i][j] == 1)
					System.out.print("♝ ");
				else
					System.out.print(". ");
			}
			System.out.printf("|\n");
			number--;
		}
		System.out.printf("  +-%s+\n", borders);
		System.out.print("    ");
		for (byte i = 65; i < 73; i++)
			System.out.printf("%c ", (char)i);
		System.out.println();
	}
}
