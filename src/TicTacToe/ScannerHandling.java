//Anger att klassen tillhör mappen TicTacToe
package TicTacToe;

import java.util.InputMismatchException;
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
        scanner = new Scanner(System.in);
        //Använder en try/catch om spelaren skriver in något felaktigt så programmet inte kraschar
        try {
            //Försöker läsa in en int från spelaren och returnera värdet, att skapa en ny scanner
            //varje gång inne i try/catch för att rensa scannern är nog inte det mest optimala, det hade
            //möjligtvis gått att lösa genom en nextLine, men på grund av tidsbrist har jag inte hunnit
            //testa
            return scanner.nextInt();
            //"Fångar" felet om det inte är en int utan exempelvis en bokstav
        } catch (InputMismatchException e) {
            //Om det inte är en siffra som skrivs in returneras -1 som felaktig information
            return -1;
        }
    }
}
