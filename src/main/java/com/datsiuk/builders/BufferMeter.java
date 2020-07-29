package com.datsiuk.builders;

public class BufferMeter extends Meter {
    protected final StringBuffer sb = new StringBuffer();

    @Override
    public void appendString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < LOOPS; i++) {
            sb.append("123");
        }
    }

    @Override
    public void appendChar() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < LOOPS; i++) {
            sb.append('1').append('2').append('3');
        }
    }
}
