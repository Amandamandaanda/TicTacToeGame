package TicTacToe;

import java.util.Scanner;
//Skapar en klass för att kunna hantera spelarens inmatning genom scanner
public class ScannerHandling {
    //Skapar en privat scanner för att läsa in spelares inmatning
    private Scanner scanner;
    //Skapar en konstruktor för klassen
    public ScannerHandling() {
        //Skapar ett nytt scannerobjekt
        this.scanner = new Scanner(System.in);
    }
    //Skapar en metod som efterfrågar spelaren val av placering i spelet
    //och som returnerar ett värde av en int
    //Använder currentPlayer som parameter för att visa vilken spelares tur det är
    public int getPlayersPlacement(String currentPlayer){
        System.out.println(currentPlayer + " Enter your placement 1-9");
        return scanner.nextInt();
    }
}
