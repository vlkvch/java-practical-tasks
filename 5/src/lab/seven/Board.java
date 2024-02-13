package lab.seven;

import java.util.Random;

public class Board {
	private byte     size;
	private byte[][] board;

	public Board(byte size) {
		this.size = size;
		this.board = new byte[size][size];
	}

	public byte[][] getBoard() {
		return board;
	}

	public void placeShip(Ship ship) {
		Random rand = new Random();
		byte posX, posY;
		do {
			posX = (byte)rand.nextInt(size);
			posY = (byte)rand.nextInt(size);
		} while (!ship.canBePlaced(posX, posY, board));

		
		byte border = (byte)(size - 1);
		boolean top = posY - 1 >= 0;
		boolean right = posX + 1 <= border;
		boolean bottom = posY + 1 <= border;
		boolean left = posX - 1 >= 0;
		byte shipSize = ship.getSize();
		
		if (ship.getDirection()) {
			if (left) board[posY][posX - 1] = 2;
			if (left && top) board[posY - 1][posX - 1] = 2;
			if (right && top) board[posY - 1][posX + shipSize] = 2;
			
			for (byte i = posX; i < posX + shipSize; i++) {
				if (top) board[posY - 1][i] = 2;
				board[posY][i] = 1;
				if (bottom) board[posY + 1][i] = 2;
			}
			
			if (right) board[posY][posX + shipSize] = 2;
			if (left && bottom) board[posY + 1][posX - 1] = 2;
			if (right && bottom) board[posY + 1][posX + shipSize] = 2;
		} else {
			if (top) board[posY - 1][posX] = 2;
			if (left && top) board[posY - 1][posX - 1] = 2;
			if (right && top) board[posY - 1][posX + 1] = 2;
			
			for (byte i = posY; i < posY + shipSize; i++) {
				if (right) board[i][posX + 1] = 2;
				board[i][posX] = 1;
				if (left) board[i][posX - 1] = 2;
			}
			
			if (bottom) board[posY + shipSize][posX] = 2;
			if (left && bottom) board[posY + shipSize][posX - 1] = 2;
			if (right && bottom) board[posY + shipSize][posX + 1] = 2;
		}
	}

	public void printBoard() {
		String borders = "-".repeat(size * 2);
		System.out.printf("+-%s+\n", borders);
		for (byte i = 0; i < size; i++) {
			System.out.print("| ");
			for (byte j = 0; j < size; j++) {
				if (board[i][j] == 1)
					System.out.print("• ");
				else
					System.out.print(". ");
			}
			System.out.printf("|\n");
		}
		System.out.printf("+-%s+\n", borders);
	}
}
