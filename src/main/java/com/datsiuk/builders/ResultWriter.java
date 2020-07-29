package com.datsiuk.builders;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ResultWriter {
    private static final PrintStream OUT = System.out;
    private PrintStream NEW_OUT;

    public ResultWriter(String fPath) throws FileNotFoundException {
        this.setPath(fPath);
    }

    public void setOut() {
        System.setOut(NEW_OUT);
    }

    public void resetOut() {
        System.setOut(OUT);
    }

    public void setPath(String fPath) throws FileNotFoundException {
        NEW_OUT = new PrintStream(new FileOutputStream(fPath));
    }
}
