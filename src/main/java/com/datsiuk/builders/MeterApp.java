package com.datsiuk.builders;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MeterApp {
    private static final Meter[] METERS = {
            new BuilderMeter(),
            new BufferMeter(),
    };

    private static final String[] HEADERS = {
            "Builder#string",
            "Builder#char",
            "Buffer#string",
            "Buffer#char",
    };

    private static final int LOOPS = 5;
    private static int head = 0;

    private static List<String> averages = new ArrayList<>();

    private static String EOL = System.lineSeparator();

    public static void main(String[] args) throws FileNotFoundException {
        final String logFilePath = "jdk8.txt";
//        final String bufferLogPath = "jdk11.txt";
        ResultWriter resultWriter = new ResultWriter(logFilePath);
        resultWriter.setOut();
        for (int i = 0; i < METERS.length; i++) {
            meter(METERS[i]);
        }
        showAverage();
        resultWriter.resetOut();
    }

    private static void showAverage() {
        StringBuilder sb = new StringBuilder(EOL);
        for (int i = 0; i < HEADERS.length; i++) {
            sb.append(HEADERS[i]).append(':').append(' ').append(averages.get(i)).append(EOL);
        }
        System.out.println(sb);
    }

    private static void measure(Runnable append) {
        long averageTime = 0;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < LOOPS; j++) {
            long time = System.nanoTime();
            append.run();
            time = System.nanoTime() - time;
            averageTime += time;
            sb.append(String.format("\tstep: %d; time: %,9.3f sec%n", j + 1, time / 1_000_000.0));
        }
        String doubleInSec = getDoubleInSec(averageTime / 1_000_000.0 / LOOPS);
        averages.add(doubleInSec);
        sb.append("\tIn average: ").append(doubleInSec);
        System.out.println(sb);
    }

    private static String getDoubleInSec(double time) {
        return String.format("%,9.3f", time);
    }

    private static void meter(Meter meter) {
        System.out.println(HEADERS[head++]);
        measure(meter::appendString);
        System.out.println(HEADERS[head++]);
        measure(meter::appendChar);
    }
}