//Anger att klassen tillhör mappen TicTacToe
package TicTacToe;
import java.util.Scanner;
public class TicTacToeGame {
    //Skapar en array för att hålla reda på om en plats i spelbrädet är upptaget eller tom,
    //Arrayen har 9 tecken som motsvarar en ruta i spelet
    private char[] gameBoard = new char[9];
    //Skapar ett nytt objekt av ScannerHandlingklassen som ska läsa inmatning från spelaren
    private ScannerHandling scanner = new ScannerHandling();
    //Skapar en boolean som gör att while-loopen fortsätter så länge condition:et är sant, dvs
    //så länge spelet är igång
    boolean gameIsOn = true;

    //Gör en array för spelplattorna samt skriver ut spelplanen
    public void DrawGameBoard() {
        System.out.println(gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2]);
        System.out.println("--+---+--");
        System.out.println(gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5]);
        System.out.println("--+---+--");
        System.out.println(gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8]);
    }
    //Skapar spelare X och spelare O i en enum, som är en speciell klass som representerar
    //en grupp konstanter
    enum player {
        PLAYER_X,
        PLAYER_O
    }
    //Anger vilken spelare som startar spelet
    player currentPlayer = player.PLAYER_X;
    //Kör spelet i en loop så det kan startas om
    public void startGame() {
        boolean hasPlayerWon = false;
        //Rensar spelplanen
        boolean clearGameBoard = true;
        //Skapar en loop som körs så spelet alltid kan starta om
        while (clearGameBoard) {
            //Kallar på metoden som rensar spelbrädet
            clearGameBoard();
            //Sätter gameIsOn till true för att starta spelet på nytt
            gameIsOn = true;
            //Sätter int count till 0 så den kan räkna hur många drag som görs tills det blir oavgjort
            int count = 0;
            //Sätter att spelare X börjar
            currentPlayer = player.PLAYER_X;
            //Loopar så länge spelet är igång
            while (gameIsOn) {
                //Anropar och skriver ut spelplanen
                DrawGameBoard();
                //Anropar metoden getPlayersPlacement för att skicka med currentPlayer som sträng
                //samt kunna returnera spelaren val av position
                int placement = scanner.getPlayersPlacement(currentPlayer.toString());
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
                //Skapar en ny variabel för den spelaren som senast la en bricka innan spelet byter spelare,
                player playerLastMove = currentPlayer;

                //Sätter spelarens symbol som är X eller O på den valda platsen i spelbrädet
                switch (currentPlayer) {
                    case PLAYER_X:
                        gameBoard[placement - 1] = 'X';
                        //Byter spelare till O
                        currentPlayer = player.PLAYER_O;
                        break;
                    case PLAYER_O:
                        gameBoard[placement - 1] = 'O';
                        //Byter spelare till X
                        currentPlayer = player.PLAYER_X;
                        break;
                }
                //Ökar räknaren för att kolla antal drag ifall det blir oavgjort
                count++;
                //Kollar om spelaren som senast la sin bricka har vunnit
                if (checkWinner(playerLastMove)) {
                    //Visar att en spelare har vunnit och att spelet därmed är slut
                    hasPlayerWon = true;
                    //Skriver ut det slutgiltliga spelbrädet
                    DrawGameBoard();
                    //Skriver ut vinnaren
                    System.out.println(playerLastMove + " IS THE WINNER!!");
                    //Stoppar boolean:en eftersom spelet är slut
                    //Avslutar spelet då det finns en vinnare
                    gameIsOn = false;
                }
                //Kollar om alla rutor är fyllda och att det inte finns någon vinnare
                if (count == 9 && hasPlayerWon == false) {
                    DrawGameBoard();
                    //Skriver ut att det blir oavgjort
                    System.out.println("DRAW!!");
                    gameIsOn = false;
                }
            }
        }
    }
        //Kollar om en spelare har tre av sin symbol i rad i spelarrayen
        private boolean checkWinner(player currentPlayer) {
            //Skapar en tom variabel som kommer innehålla symbolen för den aktuella spelaren
            char playerPiece = ' ';
            //Här kollar if satsen om symbolen motsvarar spelaren,
            if (currentPlayer == player.PLAYER_X) {
                playerPiece = 'X';
            } else {
                playerPiece = 'O';
            }
            //Kollar alla möjliga olika vinstkombinationer för att få tre i rad och jämför det med playerPiece
            //då det motsvarar den spelaren som kontrolleras
            if (gameBoard[0] == playerPiece && gameBoard[1] == playerPiece && gameBoard[2] == playerPiece ||
                    gameBoard[3] == playerPiece && gameBoard[4] == playerPiece && gameBoard[5] == playerPiece ||
                    gameBoard[6] == playerPiece && gameBoard[7] == playerPiece && gameBoard[8] == playerPiece ||
                    gameBoard[0] == playerPiece && gameBoard[3] == playerPiece && gameBoard[6] == playerPiece ||
                    gameBoard[1] == playerPiece && gameBoard[4] == playerPiece && gameBoard[7] == playerPiece ||
                    gameBoard[2] == playerPiece && gameBoard[5] == playerPiece && gameBoard[8] == playerPiece ||
                    gameBoard[0] == playerPiece && gameBoard[4] == playerPiece && gameBoard[8] == playerPiece ||
                    gameBoard[2] == playerPiece && gameBoard[4] == playerPiece && gameBoard[6] == playerPiece) {
                //Om spelaren har tre i rad returneras true
                return true;
            } else {
                //Om ingen har vunnit returneras false
                return false;
            }
        }
            //Skapar en metod för att rensa spelplanen så den blir tom igen
            private void clearGameBoard() {
                //For-loopen går igenom hela arrayen av spelet
                for (int i = 0; i < gameBoard.length; i++) {
                    //Sätter varje rute till ett tomt tecken = ' '
                    gameBoard[i] = ' ';
                }
            }
    }







