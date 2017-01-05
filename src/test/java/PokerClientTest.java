import org.junit.*;


public class PokerClientTest {
    private PokerClient pokerClient;

    @Before
    public void setUp() throws Exception {
        pokerClient = new PokerClient("h8", "h9", "h10", "hj", "hq");
    }

    @Test
    public void testHighestCardIsMineTrue() throws Exception {
        Assert.assertEquals(true, pokerClient.highestCardIsMine("h2", "c3", "s2", "cj", "d8"));
    }

    @Test
    public void testHighestCardIsMineFalse() throws Exception {
        Assert.assertEquals(false, pokerClient.highestCardIsMine("d10", "dj", "dq", "dk", "da"));
    }

    @After
    public void tearDown() throws Exception {
        pokerClient = null;
    }
}
