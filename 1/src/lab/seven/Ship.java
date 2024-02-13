package lab.seven;

public class Ship {
	private byte    size;
	private boolean direction;

	public Ship(byte size, boolean direction) {
		this.size = size;
		this.direction = direction;
	}

	public byte getSize() {
		return size;
	}
	public boolean getDirection() {
		return direction;
	}

	public boolean canBePlaced(byte posX, byte posY, byte[][] board) {
		boolean value = false;
		byte length;
		if (direction) {
			length = (byte)(posX + size);
			if (length < board.length)
				for (byte i = posX; i < length; i++) {
					if (board[posY][i] == 0) {
						value = true;
					} else {
						value = false;
						break;
					}
				}
		} else {
			length = (byte)(posY + size);
			if (length < board.length) {
				for (byte i = posY; i < length; i++) {
					if (board[i][posX] == 0) {
						value = true;
					} else {
						value = false;
						break;
					}
				}
			}
		}
		return value;
	}
}
