package magicsquare;

public class MagicSquare {
	private int[][] magicSquare;
	
	public MagicSquare(int dim) {
		magicSquare = new int[dim][dim];
		fillSquare();
	}
	
	private void fillSquare() {	
		/*  Algorithm:
		 * 	    1) Start in the middle square of the top row (i.e. (0, floor(dim/2) )
		 *      2) Number until reaching number%5=0 by placing the next number diagonally
		 *         up and to the right of the last number
		 *         a) If outside the boundaries of the square, reflect the position onto the
		 *            square. (use % dim)
		 *      3) When number % 5 == 0, place (num % 5) + 1 immediately below in the square
		 *      4) Stop when dim * dim is placed.
		 */ 
		
		int dim = magicSquare[0].length;
		
		int row = 0, col = (int) Math.floor(dim/2);
	
		for(int num = 1; num <= dim*dim; num++) {
			magicSquare[row][col] = num;
			
			if((num % dim) != 0) {
				row--;
				col++;
			} 
			
			else {
				row++;
			}
						
			// Reflect the point back onto the Magic Square
			// Add dim to the current value to force anything negative to be positive
			row = (row + dim) % dim;
			col = (col + dim) % dim;
		}
	}
	
	public void checkSquare() {
		int dim = magicSquare[0].length;
		
		int magicValue = (int) Math.ceil((dim * dim) / 2.0) * dim;
		
		System.out.println("All rows, columns, and diagonals should add to " + magicValue);
		
		// Check all rows and columns
		for(int i = 0; i < dim; i++) {
			assert((sum("Row", i) == magicValue)) : String.format("Row %d: %d", i, sum("Row", i));
			assert((sum("Col", i) == magicValue)) : String.format("Col %d: %d", i, sum("Col", i));
		}
		
		// Check the diagonals
		assert((sum("RLDiag", dim - 1) == magicValue)) : String.format("RLDiag:  %d", sum("RLDiag", dim-1));
		assert((sum("LRDiag", 0) == magicValue)) : String.format("LRDiag:  %d", sum("LRDiag", 0));
		
		System.out.println("All check out.\n");
	}
	
	private int sum(String type, int line) {
		int sum = 0;
		for(int i = 0; i < magicSquare[0].length; i++) {
			if(type.equals("Row")) {
				sum += magicSquare[line][i];
			} else if(type.equals("Col")) {
				sum += magicSquare[i][line];
			} else if(type.equals("RLDiag")) {
				sum += magicSquare[i][line--];
			} else if(type.equals("LRDiag")) {
				sum += magicSquare[i][line++];
			}
		}
		
		return sum;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int dim = magicSquare[0].length;
		
		sb.append(dim + " x " + dim + "\n=========================================\n");
		for(int x = 0; x < dim; x++) {
			for(int y = 0; y < dim; y++) {
				sb.append(String.format("%-3d", magicSquare[x][y]));
				
				if(y < dim - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}	
}
