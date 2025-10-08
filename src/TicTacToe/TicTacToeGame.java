package TicTacToe;
import java.util.Scanner;
public class TicTacToeGame {
    //Gör en array för spelplattorna samt skriver ut spelplanen
    public void DrawGameBoard() {
        System.out.println(gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2]);
        System.out.println("--+---+--");
        System.out.println(gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5]);
        System.out.println("--+---+--");
        System.out.println(gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8]);
    }
    public static char[] gameBoard = new char[9];
    //Skapar en scanner för att kunna läsa spelarens val
    Scanner scanner = new Scanner(System.in);
    //Skapar en boolean som gör att while-looparna fortsätter så länge condition:et är sant,
    //en för så länge spelet är igång och en för att starta om spelet
    boolean gameIsOn = true;
    boolean resetGame = true;
    //Skapar spelare X och spelare O i en enum, som är en speciell klass som representerar
    //en grupp konstanter
    enum currentPlayer {
        PLAYER_X,
        PLAYER_O
    }
    //Anger vilken spelare som startar spelet
    currentPlayer player = currentPlayer.PLAYER_X;
    //Kör spelet i en loop så det kan startas om
    public void startGame() {
        //rensar spelplanen
        boolean resetGame = true;
        while (resetGame) {
            resetGameBoard();
            gameIsOn = true;
            //Sätter int count till 0 så den kan räkna hur många drag som görs tills det blir oavgjort
            int count = 0;
            player = currentPlayer.PLAYER_X;

            while (gameIsOn) {
                //anropar och skriver ut spelplanen
                DrawGameBoard();
                //Ber spelaren välja en plats mellan 1-9
                System.out.println(player + " Enter your placement 1-9");
                //Läser in användarens spelval och sparar det i variabeln placement
                int placement = scanner.nextInt();
                //Kollar om spelarens val (placement) är inom sifferintervallet
                if (placement < 1 || placement > 9) {
                    System.out.println("Invalid placement number, choose between 1 and 9");
                    //Hoppar tillbaka till början av spelet så det kan fortsätta
                    continue;
                }
                //Kollar om spelplatsen spelaren valt är upptagen
                if (gameBoard[placement - 1] == 'X' || gameBoard[placement - 1] == 'O') {
                    System.out.println("Place is taken, choose another one");
                    continue;
                }

                //I en switch sätts den plats spelaren valt på spelplanen in
                switch (player) {
                    case PLAYER_X:
                        gameBoard[placement - 1] = 'X';
                        //här sätts spelaren till O så de kan bytas
                        player = currentPlayer.PLAYER_O;
                        break;
                    case PLAYER_O:
                        gameBoard[placement - 1] = 'O';
                        player = currentPlayer.PLAYER_X;
                        break;
                }
                //Ökar räknaren för att kolla antal drag ifall det blir oavgjort
                count++;

                //Kollar alla vinstkombinationer för spelare X
                if (gameBoard[0] == 'X' && gameBoard[1] == 'X' && gameBoard[2] == 'X' ||
                        TicTacToeGame.gameBoard[3] == 'X' && TicTacToeGame.gameBoard[4] == 'X' && TicTacToeGame.gameBoard[5] == 'X' ||
                        TicTacToeGame.gameBoard[6] == 'X' && TicTacToeGame.gameBoard[7] == 'X' && TicTacToeGame.gameBoard[8] == 'X' ||
                        TicTacToeGame.gameBoard[0] == 'X' && TicTacToeGame.gameBoard[3] == 'X' && TicTacToeGame.gameBoard[6] == 'X' ||
                        TicTacToeGame.gameBoard[1] == 'X' && TicTacToeGame.gameBoard[4] == 'X' && TicTacToeGame.gameBoard[7] == 'X' ||
                        TicTacToeGame.gameBoard[2] == 'X' && TicTacToeGame.gameBoard[5] == 'X' && TicTacToeGame.gameBoard[8] == 'X' ||
                        TicTacToeGame.gameBoard[0] == 'X' && TicTacToeGame.gameBoard[4] == 'X' && TicTacToeGame.gameBoard[8] == 'X' ||
                        TicTacToeGame.gameBoard[2] == 'X' && TicTacToeGame.gameBoard[4] == 'X' && TicTacToeGame.gameBoard[6] == 'X') {
                    //Skriver ut spelplanen igen för att få en uppdaterad spelplan där man kan se vinsten
                    DrawGameBoard();
                    System.out.println("X IS THE WINNER!!");
                    //Sätter min boolean till false eftersom spelet är slut
                    gameIsOn = false;
                }
                //Kollar alla vinstkombinationer för spelare X
                if (TicTacToeGame.gameBoard[0] == 'O' && TicTacToeGame.gameBoard[1] == 'O' && TicTacToeGame.gameBoard[2] == 'O' ||
                        TicTacToeGame.gameBoard[3] == 'O' && TicTacToeGame.gameBoard[4] == 'O' && TicTacToeGame.gameBoard[5] == 'O' ||
                        TicTacToeGame.gameBoard[6] == 'O' && TicTacToeGame.gameBoard[7] == 'O' && TicTacToeGame.gameBoard[8] == 'O' ||
                        TicTacToeGame.gameBoard[0] == 'O' && TicTacToeGame.gameBoard[3] == 'O' && TicTacToeGame.gameBoard[6] == 'O' ||
                        TicTacToeGame.gameBoard[1] == 'O' && TicTacToeGame.gameBoard[4] == 'O' && TicTacToeGame.gameBoard[7] == 'O' ||
                        TicTacToeGame.gameBoard[2] == 'O' && TicTacToeGame.gameBoard[5] == 'O' && TicTacToeGame.gameBoard[8] == 'O' ||
                        TicTacToeGame.gameBoard[0] == 'O' && TicTacToeGame.gameBoard[4] == 'O' && TicTacToeGame.gameBoard[8] == 'O' ||
                        TicTacToeGame.gameBoard[2] == 'O' && TicTacToeGame.gameBoard[4] == 'O' && TicTacToeGame.gameBoard[6] == 'O') {
                    //Skriver ut spelplanen igen för att få en uppdaterad spelplan där man kan se vinsten
                    DrawGameBoard();
                    System.out.println("O IS THE WINNER!!");
                    //Sätter min boolean till false eftersom spelet är slut
                    gameIsOn = false;
                }
                //Räknaren kollar om det blir oavgjort
                if (count == 9) {
                    DrawGameBoard();
                    System.out.println("DRAW!");
                    gameIsOn = false;
                }
            }
        }
    }
    //Återställer spelplanen
    private void resetGameBoard() {
        //For-loopen går igenom hela arrayen av spelet
        for (int i = 0; i < TicTacToeGame.gameBoard.length; i++) {
            //Sätter varje rute till ett tomt tecken = ' '
            TicTacToeGame.gameBoard[i] = ' ';
        }
    }
}





