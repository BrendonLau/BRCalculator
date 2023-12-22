import calculator.BitrateCalculator;
import common.NetworkInterface;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.math.BigInteger;

public class BitrateCalculatorTest {
    @Test
    public void calculateBitrate_success_2Hz() {
        final double pollingRate = 2;
        NetworkInterface nic = new NetworkInterface("Linksys ABR",
                "14:91:82:3C:D6:7D",
                "2020-03-23T18:25:43.511Z",
                new BigInteger(String.valueOf(3698574500L)),
                new BigInteger(String.valueOf(122558800)));

        BitrateCalculator bitrateCalculator = new BitrateCalculator(nic, pollingRate);
        bitrateCalculator.calculate();
        assertEquals("14794298000", bitrateCalculator.getRxBitrate().toString());
        assertEquals("490235200", bitrateCalculator.getTxBitrate().toString());
    }

    @Test
    public void calculateBitrate_success_10Hz() {
        final double pollingRate = 10;
        NetworkInterface nic = new NetworkInterface("Linksys ABR",
                "14:91:82:3C:D6:7D",
                "2020-03-23T18:25:43.511Z",
                new BigInteger(String.valueOf(3698574500L)),
                new BigInteger(String.valueOf(122558800)));

        BitrateCalculator bitrateCalculator = new BitrateCalculator(nic, pollingRate);
        bitrateCalculator.calculate();
        assertEquals("369857450", bitrateCalculator.getRxBitrate().toString());
        assertEquals("12255880", bitrateCalculator.getTxBitrate().toString());
    }

}
