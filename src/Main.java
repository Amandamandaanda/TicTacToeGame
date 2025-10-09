//Importerar klassen TicTacToeGame från mappen TicTacToe
import TicTacToe.TicTacToeGame;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Skapar ett objekt av tictactoegame-klassen
        TicTacToeGame game = new TicTacToeGame();
        //Skriver ut spelet i konsolen
        game.startGame();
    }
}
