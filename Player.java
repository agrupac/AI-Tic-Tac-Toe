/**
* An abstract class representing a general player
*/
public abstract class Player{
  /**
  * An abstract method that is defined by subclasses
  *
  * @param game a TicTacToe game
  * @return a TicTacToe object
  */
  public abstract TicTacToe chooseMove(TicTacToe game);
  /**
  * A method that determines the outcome of a game and returns a score
  *
  * @param game a TicTacToe game
  * @return a double score: 1.0 for win, -1.0 for loss, 0.0 otherwise
  */
  public double boardValue(TicTacToe game){
    if(game.checkWin(this)){
      return 1.0;
    }
    else if(game.checkLose(this)){
      return -1.0;
    }
    else{
      return 0.0;
    }
  }

}
