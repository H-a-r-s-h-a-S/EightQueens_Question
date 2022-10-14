public class ChessBoardRenderer {
	public boolean isBlackSquare(int square) {

		int row = square / 8;
		if (row % 2 == 0) {
			return square % 2 == 1;
		}
		return square % 2 == 0;
	}
}
