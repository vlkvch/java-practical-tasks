package lab.seven;

import java.util.Random;

class Main {
	static void placeShips(byte size, byte numberOfShips, Board board) {
		byte counter = 0;
		Random rand = new Random();
		while (counter != numberOfShips) {
			boolean direction = rand.nextBoolean();
			Ship ship = new Ship(size, direction);
			board.placeShip(ship);
			counter++;
		}
	}
	
	public static void main(String[] args) {
		Board board = new Board((byte)10);
		byte j = 4;
		for (byte i = 1; i < 5; i++) {
			placeShips(i, j, board);
			j--;
		}
		board.printBoard();
	}
}