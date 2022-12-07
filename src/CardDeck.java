import java.util.*;

public class CardDeck {

    public static ArrayList CreateCardDeck() {
        ArrayList<PlayingCard> card_deck = new ArrayList<>();
        int counter_hearts = 0;
        int counter_diamonds = 0;
        int counter_spades = 0;
        int counter_clubs = 0;
        int card_number_counter_hearts = 1;
        int card_number_counter_diamonds = 1;
        int card_number_counter_spades = 1;
        int card_number_counter_clubs = 1;
        while (counter_hearts < 13) {
            int card_number = card_number_counter_hearts;
            PlayingCard card = new PlayingCard(card_number, "h");
            card_deck.add(card);
            counter_hearts++;
            card_number_counter_hearts++;
        }
        while (counter_diamonds < 13) {
            int card_number = card_number_counter_diamonds;
            PlayingCard card = new PlayingCard(card_number, "d");
            card_deck.add(card);
            counter_diamonds++;
            card_number_counter_diamonds++;
        }
        while (counter_spades < 13) {
            int card_number = card_number_counter_spades;
            PlayingCard card = new PlayingCard(card_number, "s");
            card_deck.add(card);
            counter_spades++;
            card_number_counter_spades++;
        }
        while (counter_clubs < 13) {
            int card_number = (card_number_counter_clubs);
            PlayingCard card = new PlayingCard(card_number, "c");
            card_deck.add(card);
            counter_clubs++;
            card_number_counter_clubs++;
        }

        return card_deck;
    }

    public static ArrayList ShuffleCardDeck(ArrayList card_deck) {
        Collections.shuffle(card_deck);
        return card_deck;
    }

    public static PlayingCard DrawCard(ArrayList<PlayingCard> card_deck) {
        if (card_deck.size() > 1) {
            PlayingCard drawn_card = card_deck.get(0);
            card_deck.remove(0);
            return drawn_card;
        }
        else if (card_deck.size() == 1){
            System.out.println("Deck is now empty");
            PlayingCard drawn_card = card_deck.get(0);
            card_deck.remove(0);
            return drawn_card;
        }
        else {
            return null;
        }

    }

}



