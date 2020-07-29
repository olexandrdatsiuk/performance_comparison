package com.datsiuk.builders;

public abstract class Meter {
    public final int LOOPS = 50_000_000;

    public abstract void appendString();

    public abstract void appendChar();
}
