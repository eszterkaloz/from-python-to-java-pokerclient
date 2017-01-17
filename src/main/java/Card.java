import java.util.*;


public class Card {

    private String cardCode, cardColor;
    private Integer cardValue;
    private static final List<String> CARD_COLORS = new ArrayList<>(Arrays.asList("S", "C", "D", "H"));
    private static final Map<String, Integer> ALPHABETIC_CARD_VALUE = new HashMap<>();
    static {
        ALPHABETIC_CARD_VALUE.put("J", 11);
        ALPHABETIC_CARD_VALUE.put("Q", 12);
        ALPHABETIC_CARD_VALUE.put("K", 13);
        ALPHABETIC_CARD_VALUE.put("A", 14);
    }

    public Card(String cardCode) throws IllegalArgumentException {
        this.cardCode = cardCode;
        this.cardColor = cardCode.substring(0, 1).toUpperCase();

        if(!CARD_COLORS.contains(cardColor)) {
            throw new IllegalArgumentException("Card color isn't valid: " + cardColor);
        }

        String cardValueString = cardCode.substring(1).toUpperCase();

        if (ALPHABETIC_CARD_VALUE.get(cardValueString) == null) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            this.cardValue = Integer.parseInt(cardValueString);
            if (cardValue > 10 || cardValue < 2) {
                throw new IllegalArgumentException("Card number isn't valid: " + cardValue);
            }
        } else {
            this.cardValue = ALPHABETIC_CARD_VALUE.get(cardValueString);
        }
    }

    public int getValue() {
        return this.cardValue;
    }
}
