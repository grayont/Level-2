package Reversi;

public class GameManager {
	
	private int[][] spaces;
	
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
	
	public update() {
		
	}
	

}
