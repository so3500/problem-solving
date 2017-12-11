import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Boj_10868 {

    private static int N, M;
    private static int left, right, H, numOfNode, valOfNode;
    private static int[] S;
    private static Score[] tree;
//    private static File f = new File("input.txt");
//    private static Scanner s;
    private static Scanner s = new Scanner(System.in);
    private static final int minVal = Integer.MAX_VALUE;
    private static final int maxVal = Integer.MIN_VALUE;
    private static class Score{
        int maxVal;
        int minVal;
        public Score (int minVal, int maxVal){
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }

    private static void init(){
//        try {
//            s = new Scanner(f);
//        } catch (Exception e){
//            System.out.println(e);
//        }
        N = s.nextInt();
        M = s.nextInt();
//        tree 개수: H = 밑2인 logN, treeSize = 2^(H+1) - 1
//        numOfNode = 1 << ((int) Math.ceil(Math.log(N) / Math.log(2)) + 1);
        H = (int) Math.ceil(baseLog(N, 2));
        numOfNode = (int) Math.pow(2, H+1);
        S = new int[N + 1];
        tree = new Score[numOfNode];
        for (int i=0; i< tree.length; i++){
            tree[i] = new Score(minVal, maxVal);
        }
    }

    private static double baseLog(double x, double base){
        return Math.log10(x) / Math.log10(base);
    }

    /*
    * start: node 10개가 있다면 1
    * end: node 10개가 있다면 10
    * index: start ~ end 사이의 타켓 인덱스
    * node: 각 node에 해당하는 배열의 인덱스 (node10개 배열크기 32) 범위는 1~31 임
    *
    * */

    private static void initSegTree(Score[] tree, int node, int start, int end, int index, int val){
        if (index < start || index > end) return;
        tree[node].minVal = Math.min(tree[node].minVal, val);
        tree[node].maxVal = Math.max(tree[node].maxVal, val);
        if (start != end){
            initSegTree(tree, node*2, start, (start+end)/2, index, val);
            initSegTree(tree, node*2 + 1, (start+end)/2 + 1, end, index, val);
        }
    }

    private static int getMinValue(Score[] tree, int node, int start, int end, int left, int right){
        if (left > end || right < start){
            return minVal;
        }
        else if (left <= start && end <= right){
            return tree[node].minVal;
        }
        return Math.min(getMinValue(tree, node*2, start, (start+end)/2, left, right),
                getMinValue(tree, node*2+1, (start+end)/2+1, end, left, right));
    }

    private static int getMaxValue(Score[] tree, int node, int start, int end, int left, int right){
        if (left > end || right < start){
            return maxVal;
        }
        else if (left <= start && end <= right){
            return tree[node].maxVal;
        }
        return Math.max(getMaxValue(tree, node*2, start, (start+end)/2, left, right),
                getMaxValue(tree, node*2+1, (start+end)/2+1, end, left, right));
    }

    public static void main(String[] args){
        int minOutput, maxOutput;
        init();
        for (int index=1; index<=N; index++){
            valOfNode = s.nextInt();
            initSegTree(tree, 1, 1, N, index, valOfNode);
        }
        for (int i=0; i<M; i++){
            left = s.nextInt();
            right = s.nextInt();
            minOutput = getMinValue(tree, 1, 1, N, left, right);
            maxOutput = getMaxValue(tree, 1, 1, N, left, right);
            System.out.println(minOutput + " " + maxOutput);
        }
    }
}