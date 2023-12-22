import calculator.BitrateCalculator;
import common.Device;
import common.NetworkInterface;
import parser.AristaParser;
import parser.Parsable;

import java.io.IOException;

public class Main {
    private final static double pollingRate = 2.0; // Hz

    public static void main(String[] args) {
        String jsonData = "{\n" +
                "\"Device\": \"Arista\",\n" +
                "\"Model\": \"X-Video\",\n" +
                "\"NIC\": [{\n" +
                "\"Description\": \"Linksys ABR\",\n" +
                "\"MAC\": \"14:91:82:3C:D6:7D\",\n" +
                "\"Timestamp\": \"2020-03-23T18:25:43.511Z\",\n" +
                "\"Rx\": \"3698574500\",\n" +
                "\"Tx\": \"122558800\"\n" +
                "}]\n }";

        Parsable<Device> aristaParser = new AristaParser();
        Device aristaDevice;
        try {
            aristaDevice = aristaParser.parse(jsonData);
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Unable to parse json string");
            return;
        }

        for (NetworkInterface nic: aristaDevice.getNics()) {
            BitrateCalculator calc = new BitrateCalculator(nic, pollingRate);
            calc.calculate();

            System.out.println("Rx bitrate: " + calc.getRxBitrate());
            System.out.println("Tx bitrate: " + calc.getTxBitrate());
        }
    }
}
