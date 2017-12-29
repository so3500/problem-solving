package boj;/*
* 스위치
* 세그먼트 트리?
* https://www.acmicpc.net/problem/1395
* */
import java.util.Scanner;
import java.io.File;

public class Boj_1395 {
    private static int N, M;
    private static int start, end, H, numOfNode, command;
    private static int[] S, tree;
//    private static File f = new File("input.txt");
//    private static Scanner s;
    private static Scanner s = new Scanner(System.in);

    private static void init(){
//        try {
//            s = new Scanner(f);
//        } catch (Exception e){
//            System.out.println(e);
//        }
        N = s.nextInt();
        M = s.nextInt();
//      tree 개수: H = 밑2인 logN, treeSize = 2^(H+1) - 1
        numOfNode = 1 << ((int) Math.ceil(Math.log(N) / Math.log(2)) + 1);
//      System.out.println(N + " " + H + " " +numOfNode);
        S = new int[N + 1];
        tree = new int[numOfNode];
    }

    private static void input(){
        command = s.nextInt();
        start = s.nextInt();
        end = s.nextInt();
    }

    private static int update(int[] tree, int node, int start, int end, int index){
        int ret = 0;
        if (index < start || index > end) return 0;
        if (start != end){
            ret = (update(tree, node*2, start, (start+end)/2, index) +
            update(tree, node*2 + 1, (start+end)/2 + 1, end, index));
            tree[node] += ret;
        }
        if (start == end){
            if (tree[node] == 1){
                tree[node] = 0;
                ret = -1;
            }
            else {
                tree[node] = 1;
                ret = 1;
            }
        }
        return ret;
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
                    for (int index = start; index <= end; index++){
                        update(tree, 1, 1, N, index);
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
