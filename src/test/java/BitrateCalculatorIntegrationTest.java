import calculator.BitrateCalculator;
import common.Bitrate;
import common.Device;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import parser.AristaParser;
import parser.Parsable;

import java.io.IOException;

public class BitrateCalculatorIntegrationTest {

    @Test
    public void bitrateCalculator_success_multipleNICs() throws IOException {
        String jsonString = "{\"Device\": \"Router\", \"Model\": \"Arista\", " +
                "\"NIC\": [{\"Description\": \"eth0\", \"MAC\": \"00:11:22:33:44:55\", " +
                "\"Timestamp\": \"2023-01-01T12:00:00Z\", \"Rx\": 1000, \"Tx\": 500}, " +
                "{\"Description\": \"eth1\", \"MAC\": \"00:11:22:33:44:66\", " +
                "\"Timestamp\": \"2023-01-01T12:00:00Z\", \"Rx\": 2000, \"Tx\": 1000}]}";

        double pollingRate = 2;
        Parsable<Device> parser;
        parser = new AristaParser();
        Device device = parser.parse(jsonString);

        BitrateCalculator bitrateCalculatorEth0 = new BitrateCalculator(device.getNics()[0], pollingRate);
        bitrateCalculatorEth0.calculate();

        Bitrate rxBitrateEth0 = bitrateCalculatorEth0.getRxBitrate();
        Bitrate txBitrateEth0 = bitrateCalculatorEth0.getTxBitrate();

        assertEquals("4000", rxBitrateEth0.toString());
        assertEquals("2000", txBitrateEth0.toString());

        BitrateCalculator bitrateCalculatorEth1 = new BitrateCalculator(device.getNics()[1], pollingRate);
        bitrateCalculatorEth1.calculate();

        Bitrate rxBitrateEth1 = bitrateCalculatorEth1.getRxBitrate();
        Bitrate txBitrateEth1 = bitrateCalculatorEth1.getTxBitrate();

        assertEquals("8000", rxBitrateEth1.toString());
        assertEquals("4000", txBitrateEth1.toString());
    }
}