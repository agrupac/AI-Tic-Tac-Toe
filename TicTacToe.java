/**
* A class representing a tic tac toe game
*/
public class TicTacToe{
	/**
	* A 2D array for the tic tac toe board
	*/
	private char[][] board;
	/**
	* Two game players, x and o
	*/
	private Player x, o;
	/**
	* A constructor that assigns player roles and creates an empty game board
	*
	* @param x the Player using Xs
	* @param o the Player using Os
	*/
	public TicTacToe(Player x, Player o){
		this.x = x;
		this.o = o;
		board = new char[][]{ {'_','_','_'}, {'_','_','_'}, {'_','_','_'} };
	}
	/**
	* A method that counts how many empty spaces are on the board
	*
	* @return count an int amount of empty spaces
	*/
	public int countBlanks(){
		int count = 0;
		for(char[] row : board){
			for(char c : row){
				if(c == '_'){
					count++;
				}
			}
		}

		return count;
	}
	/**
	* A method that finds the game piece associated with a player
	*
	* @param player a Player to the find the marker of
	* @return either 'X' or 'O'
	*/
	public char markerForPlayer(Player player){
		if(player.equals(x)){
			return 'X';
		}
		else{
			return 'O';
		}
	}
	/**
	* A method that checks if the given player has won the game
	*
	* @param player a Player whose outcome will be determined
	* @return true if the player has three pieces in a row, false otherwise
	*/
	public boolean checkWin(Player player){
		char piece = markerForPlayer(player);
		//rows
		for(char[] row : board){
			if(row[0] == piece && row[1] == piece && row[2] == piece){
				return true;
			}
		}
		//columns
		for(int col = 0; col < 3; col++){
			if(board[0][col] == piece && board[1][col] == piece && board[2][col] == piece){
				return true;
			}
		}
		//diagonals
		if(board[0][0] == piece && board[1][1] == piece && board[2][2] == piece){
			return true;
		}
		if(board[0][2] == piece && board[1][1] == piece && board[2][0] == piece){
			return true;
		}

		return false;

	}
	/**
	* A method that checks if the given player has lost the game
	*
	* @param player a Player whose outcome will be determined
	* @return true if the player's opponent has won, false otherwise
	*/
	public boolean checkLose(Player player){

		if(markerForPlayer(player) == 'X'){
			if(checkWin(o)){
				return true;
			}
		}
		if(markerForPlayer(player) == 'O'){
			if(checkWin(x)){
				return true;
			}
		}
		return false;

	}
	/**
	* A method that checks if the current game has ended without a winner or loser
	*
	* @return true if neither player has won and the board is filled, false otherwise
	*/
	public boolean checkDraw(){
		if(!checkWin(x) && !checkLose(x) && countBlanks() == 0){
			return true;
		}
		return false;
	}
	/**
	* A method that converts the current game board into a 3x3 string representation
	*
	* @return a string representation of the board
	*/
	@Override public String toString(){
		return ""+board[0][0]+" "+board[0][1]+" "+board[0][2]+"\n"+board[1][0]+" "+board[1][1]+" "+board[1][2]+"\n"+board[2][0]+" "+board[2][1]+" "+board[2][2]+"\n";
	}
	/**
	* A method that determines the possible placements for a given player
	*
	* @param player a Player to determine next moves for
	* @return moves an array of TicTacToe games
	*/
	public TicTacToe[] possibleMoves(Player player){
		char piece = markerForPlayer(player);
		TicTacToe[] moves = new TicTacToe[countBlanks()];
		int counter = 0;
		//iterate through board spaces
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == '_'){
					TicTacToe gameCopy = new TicTacToe(this.getX(),this.getO());
					char[][] boardCopy = new char[3][3];
					boardCopy[0] = board[0].clone();
					boardCopy[1] = board[1].clone();
					boardCopy[2] = board[2].clone();
					boardCopy[i][j] = piece;
					gameCopy.setBoard(boardCopy);
					moves[counter] = gameCopy;
					counter++;
				}
			}
		}
		return moves;

	}
	/**
	* A method that gets the board of a TicTacToe game
	*
	* @return board a TicTacToe board
	*/
	public char[][] getBoard(){
		return board;
	}
	/**
	* A method that sets the board of a TicTacToe game
	*
	* @param board a TicTacToe board
	*/
	public void setBoard(char[][] board){
		this.board = board;
	}
	/**
	* A method that gets the X player of a TicTacToe game
	*
	* @return x the X player
	*/
	public Player getX(){
		return x;
	}
	/**
	* A method that sets the X player of a TicTacToe game
	*
	* @param x the X player
	*/
	public void setX(Player x){
		this.x = x;
	}
	/**
	* A method that gets the O player of a TicTacToe game
	*
	* @return o the O player
	*/
	public Player getO(){
		return o;
	}
	/**
	* A method that sets the O player of a TicTacToe game
	*
	* @param o the O player
	*/
	public void setO(Player o){
		this.o = o;
	}

}
