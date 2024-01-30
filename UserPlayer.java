import java.util.Scanner;
/**
* A subclass of Player representing a human, manual-input player
*/
public class UserPlayer extends Player{
  /**
  * The name of a player as a String
  */
  private String name;
  /**
  * The Scanner object that will receive player input
  */
  private Scanner input;
  /**
  * A constructor that sets the fields of a UserPlayer
  *
  * @param input a Scanner for user input
  * @param name a String for the player's name
  */
  public  UserPlayer(Scanner input, String name){
    this.name = name;
    this.input = input;
  }
  /**
  * A method that returns the name of the UserPlayer
  *
  * @return name the name of the UserPlayer
  */
  @Override public String toString(){
    return name;
  }
  /**
  * A method that displays the current game board along with all possible options for the player's next move, one of which the player will choose
  *
  * @param game a game of TicTacToe
  * @return a TicTacToe object representing the next move the player chose
  */
  @Override public TicTacToe chooseMove(TicTacToe game){

    System.out.println("\n[CURRENT BOARD]\n"+game.toString()+"\nPOSSIBLE MOVES:");

    int i = 1;
    for(TicTacToe board : game.possibleMoves(this)){
      System.out.println("(MOVE "+i+")");
      System.out.println(board.toString());
      i++;
    }

    if(game.possibleMoves(this).length > 1){
      System.out.print("Choose a move (1-"+game.possibleMoves(this).length+"): ");
    }
    else{
      System.out.print("Choose a move (1): ");
    }

    int choice = input.nextInt();

    return game.possibleMoves(this)[choice-1];
  }
}
