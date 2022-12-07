import java.util.ArrayList;

public class HandofCards {

    private PlayingCard playingCard1;
    private PlayingCard playingCard2;


    public ArrayList<PlayingCard> HandofCards(){
        ArrayList<PlayingCard> cardDeck = new ArrayList<>();
        ArrayList<PlayingCard> playingDeck = new ArrayList<>();
        cardDeck = CardDeck.CreateCardDeck();
        playingDeck = CardDeck.ShuffleCardDeck(cardDeck);
        playingCard1 = CardDeck.DrawCard(playingDeck);
        playingCard2 = CardDeck.DrawCard(playingDeck);
        return cardDeck;
    }

    public PlayingCard getPlayingCard1() {
        return playingCard1;
    }

    public PlayingCard getPlayingCard2() {
        return playingCard2;
    }
}
