package elevengame;

import java.util.Scanner;

/**
 *
 * @author lenka.wrnatova
 */
public class ElevenGame {

    public static Scanner sc = new Scanner(System.in);
    public static BoardInterface board;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Board board = new Board();

        String[] symbol = {"Srdce", "Piky", "Krize", "Kara"};
        String[] value = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] nPoints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
        board = new Board(symbol, value, nPoints, 9);

        while (board.isAnotherPlayPossible()) { //este jsou karty v balicku a existuje hratelna kombinace(JQK nwbo sum11)
            System.out.println("********** " + board.getName() + " **********");
            displayCards();
            displayDeck();
//        while (board.isAnotherPlayPossible()) { //este jsou karty v balicku a existuje hratelna kombinace(JQK nwbo sum11)
            System.out.println("Vyber karty: ");
            String[] selectedCardsPositions = sc.nextLine().split(" +"); //deli podle jedne nebo vice mezer
            if (!board.playAndReplace(selectedCardsPositions)) {
                System.out.println("Nevalidni tah");
            }
//            } else {
//                displayCards();
//                displayDeck();
//            }
        }
        if (board.hasWon()) {
            System.out.println("Gratuluji, vyhral jsi");
        } else {
            System.out.println("Nelze dale hrat");
        }
    }

    private static void displayCards() {
        for (int i = 0; i < board.nCards(); i++) {
            System.out.format("%1d. %10s     ", i + 1, board.getCardDescriptionAt(i));
            if ((i + 1) % 3 == 0) {
                System.out.println("");
            }
        }
    }

    private static void displayDeck() {
        System.out.println("V balicku je " + board.getDeckSize() + " karet");
    }

}
