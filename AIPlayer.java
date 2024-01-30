/**
* A subclass of Player representing a computer-controlled player
*/
public class AIPlayer extends Player{
  /**
  * The name of the AI as a String
  */
  private String name;
  /**
  * The other Player in the game
  */
  private Player opponent;
  /**
  * A constructor that sets the fields of an AIPlayer
  *
  * @param name the name of the AI as a String
  * @param opponent the other Player in the game
  */
  public AIPlayer(String name, Player opponent){
    this.name = name;
    this.opponent = opponent;
  }
  /**
  * A method that is mutually recursive with minValue() which determines the score of possible player moves
  *
  * @param game a game of TicTacToe
  * @return base cases: a double score of the game outcome for the AI, recursive case: calls minValue() and returns highest min value
  */
  public double maxValue(TicTacToe game){
    if(game.checkWin(this)){
      return 1.0;
    }
    else if(game.checkLose(this)){
      return -1.0;
    }
    else if(game.checkDraw()){
      return 0.0;
    }

    TicTacToe[] moves = game.possibleMoves(this);
    double highestMinValue = minValue(moves[0]);
    for(TicTacToe move : moves){
      if(minValue(move) > highestMinValue){
        highestMinValue = minValue(move);
      }
    }
    return highestMinValue;

  }
  /**
  * A method that is mutually recursive with maxValue() which determines the score of possible player moves
  *
  * @param game a game of TicTacToe
  * @return base cases: a double score of the game outcome for the AI, recursive case: calls maxValue() and returns lowest max value
  */
  public double minValue(TicTacToe game){
    if(game.checkWin(this)){
      return 1.0;
    }
    else if(game.checkLose(this)){
      return -1.0;
    }
    else if(game.checkDraw()){
      return 0.0;
    }

    TicTacToe[] moves = game.possibleMoves(opponent);
    double lowestMaxValue = maxValue(moves[0]);
    for(TicTacToe move : moves){
      if(maxValue(move) < lowestMaxValue){
        lowestMaxValue = maxValue(move);
      }
    }
    return lowestMaxValue;

  }
  /**
  * A method that uses minValue() and maxValue() to choose the best next move for the AI
  *
  * @param game a game of TicTacToe
  * @return moves[index] the best possible move
  */
  @Override public TicTacToe chooseMove(TicTacToe game){

    TicTacToe[] moves = game.possibleMoves(this);

    double highestMinValue = minValue(moves[0]);
    int index = 0;
    for(int i = 1; i < moves.length; i++){
      if(minValue(moves[i]) > highestMinValue){
        highestMinValue = minValue(moves[i]);
        index = i;
      }
    }

    return moves[index];

  }
  /**
  * A method that finds the maxValue() of a given tictactoe game
  *
  * @param game a TicTacToe game
  * @return maxValue() of game
  */
  @Override public double boardValue(TicTacToe game){
    return maxValue(game);
  }
  /**
  * A method that creates a String representation of the AI player's name
  *
  * @return "[name] (AI)"
  */
  @Override public String toString(){
    return name+" (AI)";
  }
  /**
  * A method that gets the opponent of an AIPlayer
  *
  * @return opponent the opponent Player
  */
  public Player getOpponent(){
    return opponent;
  }
  /**
  * A method that sets the opponent of an AIPlayer
  *
  * @param opponent the opponent Player
  */
  public void setOpponent(Player opponent){
    this.opponent = opponent;
  }
}
