package org.example.Connectors;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public interface ConnectionForTheFile {
    String getPathToFile();
    ObjectReader getConnectionRead();
    ObjectWriter getConnectionWrite();
}
