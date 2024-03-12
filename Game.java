
import java.util.ArrayList;
import java.util.Collections;

public class Game{

    public Game(){
        
    }
    // cards 0-8 are black cards
    // cards 9 - 13 are white cards
    // cards 14 15 16 are red cards

    public ArrayList<Integer> NumberOfCards(){

        ArrayList<Integer> deck = new ArrayList<Integer>();

        // BLACK
        // step foward 1 block
        // turn right
        // turn left
        // diagonally left
        // diagonally right
        for(int i=0; i<8; i++){
            deck.add(0);
            deck.add(2);
            deck.add(3);
            deck.add(7);
            deck.add(8);
        }

        // BLACK
        // step foward 2 blocks
        // turn around
        // DASH
        // play again
        for(int i=0; i<4; i++){
            deck.add(1);
            deck.add(4);
            deck.add(5);
            deck.add(6);
        }

        // WHITE
        // skip player
        // reverse play order
        // one block move
        for(int i=0; i<8; i++){
            deck.add(9);
            deck.add(11);
            deck.add(13);
        }

        // WHITE
        // turn around enemy goober
        // reverse move
        for(int i=0; i<4; i++){
            deck.add(10);
            deck.add(12);
        }

        // RED
        // board rotation
        // start over
        // goober swap
        deck.add(14);
        deck.add(15);
        deck.add(16);
        return deck;
    }


    public ArrayList<card> MakeDeck(ArrayList<Integer> deck){

        // contains complete deck
        ArrayList<card> cardDeck = new ArrayList<card>();

        // contains all 16 cards once
        ArrayList<card> AllCards = new ArrayList<card>();     

        card zero = new card("cards/0.jpg", "step forward 1", 0);
        AllCards.add(zero);
        card one = new card("cards/1.jpg", "step forward 2", 1);
        AllCards.add(one);
        card two = new card("cards/2.jpg", "turn right", 2);
        AllCards.add(two);
        card three = new card("cards/3.jpg", "turn left", 3);
        AllCards.add(three);
        card four = new card("cards/4.jpg", "turn around", 4);
        AllCards.add(four);
        card five = new card("cards/5.jpg", "DASH", 5);
        AllCards.add(five);
        card six = new card("cards/6.jpg", "play again", 6);
        AllCards.add(six);
        card seven = new card("cards/7.jpg", "diagonally left", 7);
        AllCards.add(seven);
        card eight = new card("cards/8.jpg", "diagonally right", 8);
        AllCards.add(eight);
        card nine = new card("cards/9.jpg", "skip player", 9);
        AllCards.add(nine);
        card ten = new card("cards/10.jpg", "turn around", 10);
        AllCards.add(ten);
        card eleven = new card("cards/11.jpg", "reverse play order", 11);
        AllCards.add(eleven);
        card twelve = new card("cards/12.jpg", "reverse move", 12);
        AllCards.add(twelve);
        card thirteen = new card("cards/13.jpg", "1 block move", 13);
        AllCards.add(thirteen);
        card fourteen = new card("cards/14.jpg", "BOARD ROTATION", 14);
        AllCards.add(fourteen);
        card fifteen = new card("cards/15.jpg", "START OVER", 15);
        AllCards.add(fifteen);
        card sixteen = new card("cards/16.jpg", "GOOBER SWAP", 16);
        AllCards.add(sixteen);


        for(int i = 0; i < deck.size(); i++){
            for(int j = 0; j < AllCards.size(); j ++){

                if(deck.get(i).equals( AllCards.get(j).getID() )){
                    cardDeck.add(AllCards.get(j));
                }
            }
        }

        return cardDeck;
    }


    public ArrayList<card> shuffle(ArrayList<card> cardDeck){

        Collections.shuffle(cardDeck);
        return cardDeck;
    }

    public ArrayList<card> begin(){
        ArrayList<Integer> deck = new ArrayList<Integer>();
        deck = NumberOfCards();
        ArrayList<card> gameDeck = new ArrayList<card>();
        gameDeck = MakeDeck(deck);
        gameDeck = shuffle(gameDeck);
        return gameDeck;
    }


    public static void main(String[] args) {
        ArrayList<card> gameDeck = new ArrayList<card>();
        Game game = new Game();
        
        System.out.println(game.begin());
    }
}