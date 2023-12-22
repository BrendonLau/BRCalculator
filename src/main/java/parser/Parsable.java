package parser;

import java.io.IOException;

public interface Parsable<T> {
    T parse(String rawObj) throws IOException;
}






