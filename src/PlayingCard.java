import java.lang.*;
import java.util.*;
import java.io.*;
public class PlayingCard {

    private int card_number;

    private String card_suit;

    private String faceCardChecker;

    public PlayingCard(int input_card_number , String input_card_suit){

        if (input_card_number == 1) {
            this.card_number = 11;
            this.faceCardChecker = "A";
        }
        else if (input_card_number == 11) {
            this.card_number = 10;
            this.faceCardChecker = "J";
        }
        else if (input_card_number == 12) {
            this.card_number = 10;
            this.faceCardChecker = "Q";
        }
        else if (input_card_number == 13) {
            this.card_number = 10;
            this.faceCardChecker = "K";
        }
        else {
            this.card_number = input_card_number;
            this.faceCardChecker = String.valueOf(input_card_number);
        }

        String hearts_string = "\u2764";
        String spades_string = "\u2660";
        String diamonds_string = "\u2666";
        String clubs_string = "\u2663";
        String card_suit_checker = input_card_suit.toUpperCase();
        if (card_suit_checker.equals("H")) {
            this.card_suit = hearts_string;
        }
        else if (card_suit_checker.equals("S")) {
            this.card_suit = spades_string;
        }

        else if (card_suit_checker.equals("C")) {
            this.card_suit = clubs_string;
        }

        else if (card_suit_checker.equals("D")) {
            this.card_suit = diamonds_string;
        }
        else {
            System.out.println("Please Enter the first letter of the suit you are trying to make. IE for 'Hearts enter H");
        }
    }


    public int getCard_number() {
        return card_number;
    }

    public String getCard_suit() {
        return card_suit;
    }

    public String getFaceCardChecker(){
        return faceCardChecker;
    }


    public String toString() {
        return faceCardChecker + card_suit;
    }

}
