package net.morerpg.util;

public class Probability {
    public static boolean of(int a, int b) {  // Chance: a/b
        return ((double) a / (double) b) >= Math.random();
    }

    public static boolean of(int a) {
        return of(1, a);
    }
}
