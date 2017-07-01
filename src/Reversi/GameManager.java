package Reversi;

import javax.swing.JOptionPane;

public class GameManager {
		
		private int[][] spaces;
		private int r;
		private int c;
		private int numMoves;
		private Controller ctrl;
		
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
		
		public void setController(Controller ctrl) {
			this.ctrl = ctrl;
		}
		
		public Controller getController() {
			return ctrl;
		}
		
		public int[][] getSpaces() {
			return spaces;
		}
		
		public boolean drawCircle(int r, int c, int p) {
			if(spaces[r][c] == 1 || spaces[r][c] == 2) {
				return false;
			}
			else {
				
				if( update(r, c, p) ) {
					spaces[r][c] = p;
					numMoves++;
					return true;
				}
				else {
					return false;
				}
			}
		}
		
		public boolean update(int row, int col, int p) {
			int difInR;
			int difInC;
			int tempR;
			int tempC;
			boolean completeMove = false;
			int numOfSpacesChecked = 0;
			
			for(int r = row - 1; r <= row + 1; r++){
				for(int c = col - 1; c <= col + 1; c++) {
					if(!(r < 0 || r > 7 || c < 0 || c > 7) ) {
						if(spaces[r][c] == p || spaces[r][c] == 0) {
							
						}
						else {
							numOfSpacesChecked = 0;
							difInR = r - row;
							difInC = c - col;
							tempR = r;
							tempC = c;
							
							 
							while((!(tempR < 0 || tempR > 7 || tempC < 0 || tempC > 7) ) && spaces[tempR][tempC] != 0) {
								
								numOfSpacesChecked++;
								if(spaces[tempR][tempC] == p) {
									for(int x = 0; x < numOfSpacesChecked; x++){
										
										if(spaces[tempR][tempC] != p) {
											spaces[tempR][tempC] = p;
											completeMove = true;
										}
											
											tempR -= difInR;
											tempC -= difInC;
									}
									
									break;
								}
								tempR += difInR;
								tempC += difInC;
								
								
							}
							
						}
					}
				}
			}
			return completeMove;
		}
		
		public int getWhiteScore() {
			int pOneScore = 0;
			for(int r = 0; r < spaces.length; r++) {
				for( int c = 0; c < spaces[r].length; c++){
					if(spaces[r][c] == 1) {
						pOneScore++;
					}
				}
			}
			return pOneScore;
		}
		
		public int getBlackScore() {
			int pTwoScore = 0;
			for(int r = 0; r < spaces.length; r++) {
				for( int c = 0; c < spaces[r].length; c++){
					if(spaces[r][c] == 2) {
						pTwoScore++;
					}
				}
			}
			return pTwoScore;
		}
		
		public void checkWin() {
			int pOneScore = 0;
			int pTwoScore = 0;
			if(numMoves >= 60) {
				for(int r = 0; r < spaces.length; r++) {
					for( int c = 0; c < spaces[r].length; c++){
						if(spaces[r][c] == 1) {
							pOneScore++;
						}
						if(spaces[r][c] == 2) {
							pTwoScore++;
						}
						
					}
				}
				if(pOneScore > pTwoScore) {
					JOptionPane.showMessageDialog(null, "Player one, the white player, wins!");
				}
				else if(pTwoScore > pOneScore) {
					JOptionPane.showMessageDialog(null, "Player two, the black player, wins!");
				}
				else{
					JOptionPane.showMessageDialog(null, "It's a tie.");
				}
			}
		}
}
		
	


