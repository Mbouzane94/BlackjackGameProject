import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        Account player_account = new Account("Matthew", 100);
        System.out.println("you have created a new account and have a starting balance of " + player_account.getBalance());
        Scanner input = new Scanner(System.in);
        boolean aceFlag = false;
        char c; //Char to drive menu choice
        ArrayList<PlayingCard> card_deck = new ArrayList<>();
        ArrayList<PlayingCard> playingDeck = new ArrayList<>();
        card_deck = CardDeck.CreateCardDeck();
        playingDeck = CardDeck.ShuffleCardDeck(card_deck);
        do {
            printMenu();
            //Grab the user input
            c = Character.toUpperCase(input.next().charAt(0));


            if (c == 'A') {
                int bet = 0;
                while (bet == 0){
                    System.out.println("Please Enter Bet");
                    Scanner betScanner = new Scanner(System.in);
                    bet = betScanner.nextInt();
                    if (bet > player_account.getBalance()){
                        System.out.println("You do not have enough money!");
                        bet = 0;
                    }
                }
                player_account.debit(bet);
                HandofCards dealerHandOfCards = new HandofCards();
                dealerHandOfCards.HandofCards();
                System.out.println("Dealers Cards " + dealerHandOfCards.getPlayingCard1().toString() + " Unknown Card");
                PlayingCard dealerCardOne = dealerHandOfCards.getPlayingCard1();
                PlayingCard dealerCardTwo = dealerHandOfCards.getPlayingCard2();
                int dealersHandValue = dealerCardOne.getCard_number() + dealerCardTwo.getCard_number();
                HandofCards playerHandofCards = new HandofCards();
                playerHandofCards.HandofCards();
                PlayingCard playerCardOne = playerHandofCards.getPlayingCard1();
                PlayingCard playerCardTwo = playerHandofCards.getPlayingCard2();
                int playersHandValue = playerCardOne.getCard_number() + playerCardTwo.getCard_number();
                System.out.println("Players Cards Are " + playerHandofCards.getPlayingCard1().toString() + " " + playerHandofCards.getPlayingCard2().toString());
                if (playerHandofCards.getPlayingCard1().getCard_number() == 11 && playerHandofCards.getPlayingCard2().getCard_number() == 11){
                    playersHandValue -= 10;
                }
                if (dealerHandOfCards.getPlayingCard1().getCard_number() == 11 && dealerHandOfCards.getPlayingCard2().getCard_number() == 11){
                    playersHandValue -= 10;
                }
                while (playersHandValue < 21) {
                    System.out.println("Your hand value is " + playersHandValue);
                    System.out.println("Would you like to hit? (y/n): ");
                    Scanner hitScanner = new Scanner(System.in);
                    char d = Character.toUpperCase(input.next().charAt(0));
                    if (d == 'Y') {
                        PlayingCard playerhitCard = CardDeck.DrawCard(playingDeck);
                        int hitCardValue = playerhitCard.getCard_number();
                        playersHandValue += hitCardValue;
                        System.out.println("You drew a " + playerhitCard);
                        if (hitCardValue == 11 && playersHandValue > 21){
                            playersHandValue -= 10;
                        }
                    }
                    else if (d == 'N') {
                        System.out.println("You Stay with a hand value of " + playersHandValue);
                        break;
                    }
                }

                if (playersHandValue > 21){
                    System.out.println("BUST! You Lose");
                    break;
                }

                while(dealersHandValue < 17){
                    PlayingCard dealerHitCard = CardDeck.DrawCard(playingDeck);
                    int dealerHitCardValue = dealerHitCard.getCard_number();
                    dealersHandValue += dealerHitCardValue;
                    if (dealerHitCardValue == 11 && dealersHandValue > 21){
                        dealersHandValue -= 10;
                    }
                }
                System.out.println("Dealers has a Hand Value of " + dealersHandValue);

                if (dealersHandValue > 21){
                    System.out.println("Dealer busts, You Win you bet of " + bet);
                    player_account.credit(2* bet);
                }
                if (dealersHandValue == 21 && playersHandValue == 21){
                    System.out.println("Push , bet returned");
                    player_account.credit(bet);
                }
                else if (playersHandValue > dealersHandValue && playersHandValue <= 21){
                    System.out.println("You WIN, A total of " + (bet));
                    player_account.credit(2 * bet);
                }

                else if(dealersHandValue > playersHandValue && playersHandValue <= 21 && dealersHandValue <= 21) {
                    System.out.println("Dealer Wins, Nice Try!");
                    System.out.println("You lose your bet of " + bet);
                }

            }
            else if(c=='B'){
                System.out.println("you have a balance of " + player_account.getBalance());
            }
            else if (c=='C'){
                System.out.println("Please enter amount you would like to add");
                Scanner amountToAdd = new Scanner(System.in);
                double moneyToAdd = amountToAdd.nextInt();
                player_account.credit(moneyToAdd);
                System.out.println("you have a balance of " + player_account.getBalance());


            }
            else if (c=='D'){
                player_account.reset();
                player_account.credit(1000);
                System.out.println("Your account has been reset and has the starting balance of " + player_account.getBalance());
            }


        }while(c!='Q');

        System.out.println("\nGOODBYE!");
    }
    public static void printMenu(){
        System.out.println("\n\nMake a choice");
        System.out.println("(A) Play Blackjack!");
        System.out.println("(B) Check Balance");
        System.out.println("(C) Add Funds");
        System.out.println("(D) Reset Account");
        System.out.println("(Q) Quit");
    }
}