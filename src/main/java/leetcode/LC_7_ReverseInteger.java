package leetcode;

public class LC_7_ReverseInteger {

    public int reverse(int x) {
        return reverseWithCalculation(x);
    }

    private int reverseWithCalculation(int x) {
        int result = 0;
        while (x != 0) {
            int num = x % 10;
            x /= 10;
            if (isOverflow(result, num)) {
                return 0;
            }
            result = 10 * result + num;
        }
        return result;
    }

    private boolean isOverflow(int result, int num) {
        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > 7)) {
            return true;
        }
        return result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && num < -8);
    }

    private int reverseWithJavaLibrary(int x) {
        StringBuilder sb = new StringBuilder().append(Math.abs(x)).reverse();
        try {
            return x < 0 ? -1 * Integer.valueOf(sb.toString()) : Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int reverseWithLong(int x) {
        // Integer.MIN_VALUE * -1 is still Integer.MIN_VALUE
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }

        StringBuilder reverseStr = new StringBuilder();
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        while (x != 0) {
            reverseStr.append(x % 10);
            x /= 10;
        }

        long reverseLong = Long.parseLong(reverseStr.toString());
        if (isNegative) {
            reverseLong *= -1;
        }

        if ((!isNegative && reverseLong > Integer.MAX_VALUE) ||
            (isNegative && reverseLong < Integer.MIN_VALUE)) {
            return 0;
        }

        return (int)reverseLong;
    }
}
