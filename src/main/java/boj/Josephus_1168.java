package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Josephus_1168 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int N, M, i, currentPosition, elm;
        List<Integer> circle;
        StringBuilder output;

        N = sc.nextInt();
        M = sc.nextInt();
        output = new StringBuilder(N * 2);
        circle = new ArrayList<>(N);

        for (i = 1; i <= N; i++) {
            circle.add(i);
        }

        currentPosition = 0;
        output.append("<");
        while (circle.size() > 1) {
            currentPosition = (currentPosition + M - 1) % circle.size();
            elm = circle.remove(currentPosition);
            output.append(elm).append(", ");
        }
        elm = circle.remove(0);
        output.append(elm).append(">");

        System.out.println(output);
    }
}
