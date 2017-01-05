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
    public void testInitiatingCardWithWrongCardValue() throws Exception {
        queenOfHearts = new Card("h1");
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
