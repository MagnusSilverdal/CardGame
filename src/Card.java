/**
 * This is a class
 * Created 2020-11-04
 *
 * @author Magnus Silverdal
 */
public class Card implements Comparable<Card>{
    private Suits suit;
    private int value;

    public Card(Suits s, int v) {
        suit = s;
        value = v;
    }

    public Suits getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String result = "";
        char s = '\u2660';
        s +=  getSuit().ordinal();
        switch (value) {
            case 1 :
                result = "A";
                break;
            case 11 :
                result = "Kn";
                break;
            case 12 :
                result = "Q";
                break;
            case 13 :
                result = "K";
                break;
            default :
                result = ""+getValue();
                break;
        }
        return result + s;
    }

    @Override
    public int compareTo(Card card) {
        int diff = (getValue()==1?14:getValue()) - (card.getValue()==1?14:card.getValue());
        if (diff != 0) {
            return diff;
        } else  {
            diff = card.getSuit().ordinal()-getSuit().ordinal();
            return diff;
        }
    }

    enum Suits {SPADE,HEART,DIAMOND,CLUB};

    public static void main(String[] args) {
        Card aceOfSpades = new Card(Suits.SPADE, 1);
        Card twoOfHearts = new Card(Suits.HEART, 2);
        System.out.println(aceOfSpades + ", " + twoOfHearts);
        if (aceOfSpades.compareTo(twoOfHearts) > 0) {
            System.out.println("Ace of spades beats two of hearts");
        }
    }
}
