package Reversi;

public class GameManager {
	
	private int[][] spaces;
	private int r;
	private int c;
	
	public GameManager() {
		spaces = new int[8][8];
		for(int r = 0; r < spaces.length; r++) {
			for( int c = 0; c < spaces[r].length; c++){
				if( (r == 3 && c == 3) || (r == 4 && c == 4)) {
					spaces[r][c] = 1;
				}
				else if( (r == 3 && c == 4) || (r == 4 && c == 3)) {
					spaces[r][c] = 2;
				}
				else {
					spaces[r][c] = 0;
				}
			}
		}
	}
	
	public int[][] getSpaces() {
		return spaces;
	}
	
	public boolean drawCircle(int r, int c, int p) {
		if(spaces[r][c] == 1 || spaces[r][c] == 2) {
			return false;
		}
		else {
			spaces[r][c] = p;
			update(r, c, p);
			return true;
		}
	}
	
	public void update(int row, int col, int p) {
		int difInR;
		int difInC;
		int tempR;
		int tempC;
		
		for(int r = row - 1; r <= row + 1; r++){
			for(int c = col - 1; c <= col + 1; c++) {
				if(spaces[r][c] == p || spaces[r][c] == 0) {
					
				}
				else {
					difInR = r - row;
					difInC = c - col;
					tempR = r;
					tempC = c;
					while(spaces[tempR][tempC] != 0) {
						tempR += difInR;
						tempC += difInC;
					}
				}
			}
		}
	}
	

}
