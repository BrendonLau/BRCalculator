package common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class NetworkInterface {
    private String description;
    private String mac;
    private String timestamp;
    private BigInteger rx;
    private BigInteger tx;

    // Empty constructor for JSON parser
    public NetworkInterface() {}

    public NetworkInterface(String description, String mac, String timestamp, BigInteger rx, BigInteger tx) {
        this.description = description;
        this.mac = mac;
        this.timestamp = timestamp;
        this.rx = rx;
        this.tx = tx;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("MAC")
    public String getMac() {
        return this.mac;
    }

    @JsonProperty("Timestamp")
    public String getTimestamp() {
        return this.timestamp;
    }

    @JsonProperty("Rx")
    public BigInteger getRx() {
        return this.rx;
    }

    @JsonProperty("Tx")
    public BigInteger getTx() {
        return this.tx;
    }
}