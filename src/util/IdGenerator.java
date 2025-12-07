package util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger COUNTER = new AtomicInteger(1000);
    public static String next() { return String.valueOf(COUNTER.getAndIncrement()); }
}
