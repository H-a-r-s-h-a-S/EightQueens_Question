public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		return cellId % 8;
	}
	
	private int getRow(int cellId) {
		return cellId / 8;
	}

	public boolean isValidPosition(int cellId) {

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		
		int r = row, c = col;
		
		// check for row
		for(int i=0; i<8; i++) {
			if (placedQueens[r][i]) {
				return false;
			}
		}
		
		// check for columns
		for(int i=0; i<8; i++) {
			if (placedQueens[i][c]) {
				return false;
			}
		}
		
		// check for diagonals
		while (r > -1 && c > -1 && r < 8 && c < 8) {
			if (placedQueens[r--][c--]) {
				return false;
			}
		}
		
		r = row;
		c = col;
		while (r > -1 && c > -1 && r < 8 && c < 8) {
			if (placedQueens[r++][c++]) {
				return false;
			}
		}
		
		r = row;
		c = col;
		while (r > -1 && c > -1 && r < 8 && c < 8) {
			if (placedQueens[r--][c++]) {
				return false;
			}
		}
		
		r = row;
		c = col;
		while (r > -1 && c > -1 && r < 8 && c < 8) {
			if (placedQueens[r++][c--]) {
				return false;
			}
		}
		
		// if valid, then
		placedQueens[row][col] = true;
		numQueens++;		
		return true;
	}
}