/*
* 스위치
* 세그먼트 트리?
* https://www.acmicpc.net/problem/1395
* */
import java.util.Scanner;
import java.io.File;

public class boj_1395 {
    private static int N, M;
    private static int start, end, H, numOfNode, command;
    private static int[] S, tree;
    private static File f = new File("input.txt");
    private static Scanner s;
//    private static Scanner s = new Scanner(System.in);

    private static void init(){
        try {
            s = new Scanner(f);
        } catch (Exception e){
            System.out.println(e);
        }
        N = s.nextInt();
        M = s.nextInt();
        H = (int) Math.ceil(baseLog(N, 2));
        numOfNode = (int) Math.pow(2, H+1);

//        System.out.println(N + " " + H + " " +numOfNode);

        S = new int[N + 1];
        tree = new int[numOfNode];
    }

    private static double baseLog(double x, double base){
        return Math.log10(x) / Math.log10(base);
    }

    private static void input(){
        command = s.nextInt();
        start = s.nextInt();
        end = s.nextInt();
    }

    private static void convertSwitch(){
        for(int i = start; i <= end; i++){
            if (S[i] == 1) S[i] = 0;
            else S[i] = 1;
        }
    }

    private static void update(int[] tree, int node, int start, int end, int index, int diff){
        if (index < start || index > end) return;
        tree[node] = tree[node] + diff;
        if (start != end){
            update(tree, node*2, start, (start+end)/2, index, diff);
            update(tree, node*2 + 1, (start+end)/2 + 1, end, index, diff);
        }
    }

    private static int sum(int[] tree, int node, int start, int end, int left, int right){
        if (left > end || right < start){
            return 0;
        }
        else if (left <= start && end <= right){
            return tree[node];
        }
        return sum(tree, node*2, start, (start+end)/2, left, right) +
                sum(tree, node*2+1, (start+end)/2+1, end, left, right);
    }

    public static void main(String[] args){
        int output;
        init();
        for (int i=0; i<M; i++){
            input();
            switch (command){
                case 0:
                    // 스위치 반전
                    convertSwitch();
                    for (int index = start; index <= end; index++){
                        if (S[index] == 1)
                            update(tree, 1, 1, N, index, 1);
                        else
                            update(tree, 1, 1, N, index, -1);
                    }
                    break;
                case 1:
                    // 스위치 켜진 수
                    output = sum(tree, 1, 1, N, start, end);
                    System.out.println(output);
                    break;
            }
        }
    }
}

//    private static int N, M; // 스위치의 개수, 처리할 일의 개수
//    private static int S, mask, count, bit, command, start, end;
//    private static File f = new File("input.txt");
//    private static Scanner s;
////    private static Scanner s = new Scanner(System.in);
//
//    private static void input(){
//        command = s.nextInt();
//        start = s.nextInt();
//        end = s.nextInt();
//    }
//
//    private static void makeMask(){
//        for (int j = start; j <= end; j++){
//            mask += (int)Math.pow(2, N-j);
//        }
//    }
//
//    private static void countBit(){
//        while (bit != 0){
//            bit = bit >>> 1;
//            if ((bit & 1) == 0) count += 1;
//        }
//    }

//    public static void main(String[] args){
//        try {
//            s = new Scanner(f);
//        } catch (Exception e){
//            System.out.println(e);
//        }
//        N = s.nextInt();
//        M = s.nextInt();
//        for (int i=0; i<M; i++){
//            input();
//            mask = 0;
//            count = 0;
//            switch (command){
//                case 0:
//                    // 스위치 반전, xor
//                    makeMask();
//                    S = S ^ mask;
////                    System.out.println("S :" + S);
//                    break;
//                case 1:
//                    // 스위치 켜진 수, and 후 bit count
//                    makeMask();
//                    bit = S & mask;
////                    System.out.println("bit: " + bit);
//                    countBit();
//                    System.out.println(count);
//                    break;
//            }
//        }
//    }
