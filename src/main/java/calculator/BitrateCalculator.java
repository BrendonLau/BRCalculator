package calculator;


import common.Bitrate;
import common.NetworkInterface;

import java.math.BigDecimal;

public class BitrateCalculator {
    private NetworkInterface nic;
    private double pollingRate;
    private Bitrate rxBitrate;
    private Bitrate txBitrate;
    private final int BYTES_TO_BITS;

    public BitrateCalculator(NetworkInterface nic, double pollingRate) {
        this.nic = nic;
        this.pollingRate = pollingRate;
        this.BYTES_TO_BITS = 8;
    }

    public void calculate() {
        BigDecimal rx = new BigDecimal(nic.getRx());
        BigDecimal tx = new BigDecimal(nic.getTx());
        BigDecimal bitsConversion = BigDecimal.valueOf(BYTES_TO_BITS);
        BigDecimal pollingRate = BigDecimal.valueOf(this.pollingRate);

        this.rxBitrate = new Bitrate(rx.multiply(bitsConversion).divide(pollingRate)); // in bits per second
        this.txBitrate = new Bitrate(tx.multiply(bitsConversion).divide(pollingRate)); // in bits per second
    }

    public Bitrate getRxBitrate() {
        return this.rxBitrate;
    }

    public Bitrate getTxBitrate() {
        return this.txBitrate;
    }
}
