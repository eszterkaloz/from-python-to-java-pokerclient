import java.util.*;


public class PokerClient {

    private List<Card> cardList = new ArrayList<>();

    public PokerClient(String card1, String card2, String card3, String card4, String card5) {
        for (String card : Arrays.asList(card1, card2, card3, card4, card5)) {
            this.cardList.add(new Card(card));
        }
    }

    public boolean highestCardIsMine(String card1, String card2, String card3, String card4, String card5) {
        PokerClient otherPlayer = new PokerClient(card1, card2, card3, card4, card5);

        otherPlayer.cardList.addAll(this.cardList);
        Comparator<Card> comparator = (cardOne, cardTwo) -> Integer.compare( cardOne.getValue(), cardTwo.getValue());
        return this.cardList.contains(
                otherPlayer.cardList
                        .stream()
                        .max(comparator)
                        .get());
    }

}