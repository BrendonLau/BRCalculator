package parser;

import common.Device;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class AristaParser implements Parsable<Device>{
    @Override
    public Device parse(String rawObj) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(rawObj, Device.class);
    }
}
