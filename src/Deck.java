import java.util.ArrayList;
import java.util.Collections;

/**
 * This is a class
 * Created 2020-11-04
 *
 * @author Magnus Silverdal
 */
public class Deck {
    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList();
        for (Card.Suits s : Card.Suits.values()) {
            for (int i = 1; i < 14; i++) {
                cards.add(new Card(s, i));
            }
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < cards.size() ; i++) {
            result += cards.get(i) + (i==cards.size()-1?"":", ");
        }
        return result;
    }

    public Card dealCard() {
        return cards.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void sort() {
        Collections.sort(cards);
    }
    public static void main(String[] args) {
        Deck d = new Deck();
        System.out.println(d);
        d.shuffle();
        Card player1 = d.dealCard();
        Card player2 = d.dealCard();
        if (player1.compareTo(player2) > 0) {
            System.out.println("player 1 wins");
        } else {
            System.out.println("player 2 wins");
        }
        System.out.println(player1 + ", " + player2);
        System.out.println(d);
    }
}
