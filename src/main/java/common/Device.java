package common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {
    private String device;
    private String model;
    private NetworkInterface[] nics;

    // Empty constructor for JSON parser
    public Device() {}

    public Device(String device, String model, NetworkInterface[] nics) {
        this.device = device;
        this.model = model;
        this.nics = nics;
    }

    @JsonProperty("Device")
    public String getDevice() {
        return device;
    }

    @JsonProperty("Model")
    public String getModel() {
        return model;
    }

    @JsonProperty("NIC")
    public NetworkInterface[] getNics() {
        return nics;
    }

}
