import java.util.*;


public class Card {

    private String cardCode;
    private String cardColor;
    private int cardValue;
    private static final List<String> CARD_COLORS = new ArrayList<>(Arrays.asList("S", "C", "D", "H"));
    private static final Map<String, Integer> ALPHABETIC_CARD_VALUE = createMap();
    private static Map<String, Integer> createMap() {
        Map<String, Integer> alphabetic = new HashMap<>();
        alphabetic.put("J", 11);
        alphabetic.put("Q", 12);
        alphabetic.put("K", 13);
        alphabetic.put("A", 14);
        return Collections.unmodifiableMap(alphabetic);
    }

    public Card(String cardCode) throws IllegalArgumentException {
        this.cardCode = cardCode;

    //  Check whether card color is right
        String cardColor = cardCode.substring(0, 1).toUpperCase();

        if(CARD_COLORS.contains(cardColor)) {
            this.cardColor = cardColor;
        } else throw new IllegalArgumentException("card color isn't valid: " + cardColor);


    //  Check whether card value is right
        String cardValueString = cardCode.substring(1).toUpperCase();

        if (ALPHABETIC_CARD_VALUE.get(cardValueString) == null) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            Integer cardValue = Integer.parseInt(cardValueString);
            if (cardValue > 10 || cardValue < 2) {
                throw new IllegalArgumentException("card number isn't valid: " + cardValue);
            } else this.cardValue = cardValue;
        } else this.cardValue = ALPHABETIC_CARD_VALUE.get(cardValueString);

    }

    public int getValue() {
        return this.cardValue;
    }
}
