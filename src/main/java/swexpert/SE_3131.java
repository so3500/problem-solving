/*
 * D3 3131 백만 이하의 모든 소수 131ms
 * 에라토스테네스의 체
 *
 * */

package swexpert;

public class SE_3131 {

    public static void main(String[] args) {
        final int SIZE = 1000001;
        boolean[] num = new boolean[SIZE];
        int s;
        for (int i = 2; i < SIZE; i++) {
            if (num[i]) continue;
            s = i * 2;
            while (s < SIZE) {
                num[s] = true;
                s += i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < SIZE; i++) {
            if (!num[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
