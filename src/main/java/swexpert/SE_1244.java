package swexpert;

import java.util.Scanner;

public class SE_1244 {
    static int max, digit, totalCnt;
    static boolean[][] visitied;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, num;
        T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            num = sc.nextInt();
            totalCnt = sc.nextInt();
            digit = getDigit(num);
            max = Integer.MIN_VALUE;
            visitied = new boolean[totalCnt + 1][1000000];
            perm(num, 0);
            System.out.println("#" + i + " " + max);
        }
    }

    static void perm(int num, int depth) {
        int swapNum;
        visitied[depth][num] = true;
//        System.out.println("depth: " + depth);
        if (totalCnt == depth) {
            if (num > max) max = num;
        } else if (totalCnt > depth) {
            for (int i = 0; i < digit; i++) {
                for (int j = i + 1; j < digit; j++) {
//                    System.out.println("swap i j " + i + " to " + j);
                    swapNum = swap(num, i, j);
                    if (!visitied[depth + 1][swapNum]) perm(swapNum, depth + 1);
                }
            }
        }
    }

    static int swap(int num, int aDigit, int bDigit) {
        int aNum, bNum, tempNum;
        if (aDigit == bDigit) {
            return num;
        } else {
            // 12345 에서 10000 과 2000의 자리를 바꿔주는 함수
            // 결과: 21345
            tempNum = num;
            aNum = num / (int) Math.pow(10, (digit - 1 - aDigit));
            bNum = num / (int) Math.pow(10, (digit - 1 - bDigit));
            if (aNum > 10) aNum %= 10;
            if (bNum > 10) bNum %= 10;
            tempNum -= aNum * (int) Math.pow(10, (digit - 1 - aDigit));
            tempNum -= bNum * (int) Math.pow(10, (digit - 1 - bDigit));
            tempNum += aNum * (int) Math.pow(10, (digit - 1 - bDigit));
            tempNum += bNum * (int) Math.pow(10, (digit - 1 - aDigit));
            return tempNum;
        }
    }

    static int getDigit(int num) {
        int digit = 0;
        while (num > 0) {
            num /= 10;
            digit++;
        }
        return digit;
    }

    static void fund() {
        int a;
    }
}

