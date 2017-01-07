import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PokerClient {

    private List<Card> pokerClientCards = new ArrayList<>();

    public PokerClient(String p1, String p2, String p3, String p4, String p5) {

        for (String card : Arrays.asList(p1, p2, p3, p4, p5)) {
            pokerClientCards.add(new Card(card.toUpperCase()));
        }

    }

    public boolean highestCardIsMine(String p1, String p2, String p3, String p4, String p5) {
        List<Card> otherCards = new ArrayList<>();

        for (String card : Arrays.asList(p1, p2, p3, p4, p5)) {
            otherCards.add(new Card(card.toUpperCase()));
        }

        Card highestCard = otherCards.get(0);

        for (Card myCard : pokerClientCards) {
            for (Card otherCard : otherCards) {
                if (otherCard.getValue() > myCard.getValue()) {
                    if (otherCard.getValue() > highestCard.getValue()) {
                        highestCard = otherCard;
                    }
                } else {
                    if (myCard.getValue() > highestCard.getValue()) {
                        highestCard = myCard;
                    }
                }
            }
        }

        return pokerClientCards.contains(highestCard);
    }

}