package lab.six;

public class Bishop {
	public static boolean canBePlaced(byte posX, byte posY, byte[][] board) {
		if (board[posY][posX] == 0)
			return true;
		return false;
	}
}
