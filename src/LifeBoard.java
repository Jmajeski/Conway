import java.util.Random;


public class LifeBoard {
	Random rand = new Random();
	private int randVal;
	
	public static int ARRAY_SIZE = 100;
	
	private int [][] board = new int [ARRAY_SIZE][ARRAY_SIZE];
	private int [][] updateBoard = new int[ARRAY_SIZE][ARRAY_SIZE];
	
	private int count = 0;
	
	/*
	 * initializes board with 1 or 0
	 * 75% chance of being a 0
	 */
	public void initBoard(){
		for (int i = 0; i < ARRAY_SIZE; i++){
			for (int j = 0; j < ARRAY_SIZE; j++){
				
				//random value between 0 and 3
				randVal = rand.nextInt(4);
				
				if (randVal == 1){
					board[i][j] = 1;
				}
				else{
					board[i][j] = 0;
				}
			}
		}
		return;
	}
	
	/*
	 * check neighboring array elements for 1s
	 * if a given element is a 1 and is surrounded by two or three 1's it remains a 1
	 * if a given element is a 0 and is surrounded by three 1's it becomes a 1
	 * if a given element is surrounded by less than two or more than three 1's it becomes a 0
	 */
	public void updateBoard(){
		for (int i = 0; i < ARRAY_SIZE; i++){
			for (int j = 0; j < ARRAY_SIZE; j++){
				
				count = 0;
				
				for (int k = -1; k < 2; k++){
					for (int m = -1; m < 2; m++){
						if (i+k >= 0 && i+k < ARRAY_SIZE && j+m >= 0 && j+m < ARRAY_SIZE){
							if (k == 0 && m == 0){
								//pass
							}
							else if (board[i+k][j+m] == 1){
								count++;
							}
						}
					}
				}
				
				//if there is over population kill the cell
				if (count > 3){
					updateBoard[i][j] = 0;
				}
				
				//if there is under population kill the cell
				else if (count < 2){
					updateBoard[i][j] = 0;
				}
				
				//if there are 2 or 3 remain living
				else if ((count == 2 || count == 3) && board[i][j] == 1){
					updateBoard[i][j] = 1;
				}
				
				//if there are 3 become a cell
				else if (count == 3 && board[i][j] == 0){
					updateBoard[i][j] = 1;
				}
				else if (count == 2 && board[i][j] == 0){
					updateBoard[i][j] = 0;
				}
				
				
			}
			count = 0;
		}
		//store updated info into board array
		for (int i = 0; i < ARRAY_SIZE; i++){
			for (int j = 0; j < ARRAY_SIZE; j++){
				board[i][j] = updateBoard[i][j];
			}
		}
		
		
		return;
	}
	
	//return board array as new two dimensional array
	public int[][] getBoard(){
		int[][] newBoard = new int[ARRAY_SIZE][ARRAY_SIZE];
		
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}
	
	//return given cell from given board
	public int getCell(int[][] board, int x, int y){
		return board[x][y];
	}

	/*
	public void copyBoard(int[][] board){
		for (int i = 0; i < ARRAY_SIZE; i++){
			for (int j = 0; j < ARRAY_SIZE; j++){
				this.board[i][j] = board[i][j];
			}
			
			return;
		}
	}*/
}
