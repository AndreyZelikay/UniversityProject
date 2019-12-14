package Interfaces;

import java.io.IOException;
import java.text.ParseException;

public interface ParsableFromFile {
    void parseFromFile(String nameOfFile) throws IOException, ParseException;
}
