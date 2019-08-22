package boj;

import java.util.Scanner;

public class SuperMario_2851 {

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(new File("input.txt"));
        Scanner sc = new Scanner(System.in);
        int score, totalScore, diffScore, beforeDiffScore, i;

        score = 0;
        totalScore = 0;
        diffScore = 100;
        beforeDiffScore = 0;
        for (i = 0; i < 10; i++) {
            score = sc.nextInt();
            totalScore += score;
            diffScore -= score;
            if (diffScore <= 0) {
                break;
            } else {
                beforeDiffScore = diffScore;
            }
        }
        // 추가 score를 더해버린 경우
        // 90 21 30 ... 일 때 위 반복문에서 21까지 더한 뒤 끝내므로 그에 대한 예외 처리
        if (beforeDiffScore < Math.abs(diffScore)) {
            totalScore -= score;
        }
        System.out.println(totalScore);
    }
}
