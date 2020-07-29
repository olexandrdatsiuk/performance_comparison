package com.datsiuk.builders;

public class BuilderMeter extends Meter {
    protected final StringBuilder sb = new StringBuilder();

    @Override
    public void appendString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LOOPS; i++) {
            sb.append("123");
        }
    }

    @Override
    public void appendChar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LOOPS; i++) {
            sb.append('1').append('2').append('3');
        }
    }
}
