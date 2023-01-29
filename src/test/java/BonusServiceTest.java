import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {
    @Test
    public void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        int expected = 30;
        long actual = service.calculate(1_000, true);
        //System.out.println(expected + "== ? ==" + actual);


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForRegisteredAndoverLimit() {
        BonusService service = new BonusService();
        int expected = 500;
        long actual = service.calculate(1_000_000, true);
        //System.out.println(expected + "== ? ==" + actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForUnRegisteredAndoverLimit() {
        BonusService service = new BonusService();
        int expected = 500;
        long actual = service.calculate(1_000_000, false);
        //System.out.println(expected + "== ? ==" + actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForUnRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        int expected = 10;
        long actual = service.calculate(1_000, false);
        //System.out.println(expected + "== ? ==" + actual);

        Assertions.assertEquals(expected, actual);
    }
}