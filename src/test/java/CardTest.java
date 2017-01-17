import org.junit.*;


public class CardTest {
    private Card queenOfHearts;
    private Card sixOfSpades;

    @Before
    public void setUp() throws Exception {
        queenOfHearts = new Card("hq");
        sixOfSpades = new Card("s6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitiatingCardWithWrongCardColor() throws Exception {
        sixOfSpades = new Card("e6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitiatingCardWithLowCardValue() throws Exception {
        queenOfHearts = new Card("h1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitiatingCardWithHighCardValue() throws Exception {
        sixOfSpades = new Card("s11");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitiatingCardWithInvalidCardValue() throws Exception {
        queenOfHearts = new Card("hfljdsflé");
    }


    @Test
    public void testInitiationLowerCaseCardColor() throws Exception {
        queenOfHearts = new Card("hQ");
        sixOfSpades = new Card("s6");
    }

    @Test
    public void testInitiationUpperCaseCardColor() throws Exception {
        queenOfHearts = new Card("HQ");
        sixOfSpades = new Card("S6");
    }

    @Test
    public void testInitiationLowerCaseCardValue() throws Exception {
        queenOfHearts = new Card("Hq");
    }

    @Test
    public void testInitiationUpperCaseCardValue() throws Exception {
        queenOfHearts = new Card("hQ");
    }

    @Test
    public void testGetValueOfHQ() throws Exception {
        Assert.assertEquals(12, queenOfHearts.getValue());
    }

    @Test
    public void testGetValueOfS6() throws Exception {
        Assert.assertEquals(6, sixOfSpades.getValue());
    }

    @After
    public void tearDown() throws Exception {
        queenOfHearts = null;
        sixOfSpades = null;
    }
}
