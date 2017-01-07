import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Card {

    private String cardCode;
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

        String cardColor = this.cardCode.substring(0, 1).toUpperCase();

        if (!cardColor.contentEquals("S") &&
            !cardColor.contentEquals("C") &&
            !cardColor.contentEquals("D") &&
            !cardColor.contentEquals("H"))
        {
            throw new IllegalArgumentException("card color isn't valid: " + cardColor);
        }

        String cardValue = cardCode.substring(1).toUpperCase();
        Integer intCardValue;

        if (ALPHABETIC_CARD_VALUE.get(cardCode.substring(1).toUpperCase()) == null) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            intCardValue = Integer.parseInt(cardValue);
            if (intCardValue > 10) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }
            if (intCardValue < 2) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }

        }
    }

    public int getValue() {
        String cardValue = cardCode.substring(1).toUpperCase();
        Integer intCardValue;

        if (ALPHABETIC_CARD_VALUE.get(cardCode.substring(1).toUpperCase()) == null) {
            intCardValue = Integer.parseInt(cardValue);
        } else {
            intCardValue = ALPHABETIC_CARD_VALUE.get(cardCode.substring(1).toUpperCase());
        }

        return intCardValue;
    }
}
