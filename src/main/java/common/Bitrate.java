package common;

import java.math.BigDecimal;

public class Bitrate {
    private BigDecimal bitrate;

    public Bitrate(BigDecimal bitrate) {
        this.bitrate = bitrate;
    }

    public void setBitrate(BigDecimal bitrate) {
        this.bitrate = bitrate;
    }

    @Override
    public String toString() {
        return  bitrate.toPlainString();
    }
}
