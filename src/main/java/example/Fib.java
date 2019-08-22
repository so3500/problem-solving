package example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fib {

    private static Map<Integer, Integer> fibCache = new HashMap<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("n: " + cachedFib(n));
        System.out.println("n: " + fib(n));
        sc.close();

    }

    private static int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int cachedFib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        fibCache.put(0, 0);
        fibCache.put(1, 1);
        return recursiveCachedFib(n);
    }

    private static int recursiveCachedFib(int n) {
        if (fibCache.containsKey(n)) {
            return fibCache.get(n);
        }

        int value = recursiveCachedFib(n - 1) + recursiveCachedFib(n - 2);
        fibCache.put(n, value);
        return value;
    }

    private static String reverse(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    private static String inPlaceReverse(String s) {
        StringBuilder builder = new StringBuilder(s);
        int builderLen = builder.length();
        for (int i = 0; i < builderLen / 2; i++) {
            char leftChar = builder.charAt(i);
            int rightIdx = builderLen - 1 - i;
            builder.setCharAt(i, builder.charAt(rightIdx));
            builder.setCharAt(rightIdx, leftChar);
        }
        return builder.toString();
    }

}
