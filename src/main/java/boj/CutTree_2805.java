/*
 * 문제: 2805 나무 자르기 / 500ms
 * link: https://www.acmicpc.net/problem/2805
 * 알고리즘: 이진 탐색
 * 풀이방법:
 *   나무 높이들을 입력받고 그 중 최고 높이를 구한다.
 *   최고높이와 최저높이(최초 0)의 중간 높이를 구한다. 이 높이는 앞으로 나무를 자를 기준 높이가 된다.
 *   기준높이로 나무들을 자른 결과가
 *       M보다 크면 "필요 이상으로 더 잘랐으므로 덜 자르기 위해 최고높이를 기준높이보다 낮게 줄인다.
 *       M보다 작으면 "더 잘라야 하므로 더 자르기 위해 최저높이를 기준높이보다 높게 한다.
 *   의사코드에서 right가 left보다 더 작아질 때 right를 출력하는데 left가 기준일 때 이미 M보다 같거나 많도록 나무를
 *   자르는 것이 참이므로 상관없다.
 *
 * 의사코드(Pseudo Code)
 *   input N, M
 *   init tree[N] with N numbers
 *
 *   sum, left, mid <- 0
 *   right <- max(tree)
 *
 *   while left <= right
 *       mid <- (left + right)/2
 *       sum <- cutTree(mid) // mid: 나무 자르는 기준 높이
 *       if M > sum // 덜 잘렸으므로 더 자른다. 기준높이 up
 *           left <- mid + 1
 *       else // 더 잘렸을 가능성이 있으므로 덜 자른다. 기준높이 down
 *           right <- mid -1
 *
 *   print(right)
 *
 *
 *   cutTree(height):
 *       sum <- 0
 *       all element in tree[N] for bigger than height
 *           sum <- sum + (element - height)
 *       return sum
 *
 * 시간복잡도(Time Complexity)
 *   while 문이 최대 logN, cutTree 함수의 복잡도는 N/2 + N/4 + N/8 + .. + 1 (=2n-1)
 *   O(NlogN)
 *
 * 공간복잡도(Space Complexity)
 *   선형 자료구조 O(N)
 *
 * */

package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

//public class Main {
public class CutTree_2805 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N, M, i, left, mid, right;
        int[] tree;
        long sum;
        int MAX_TREE_H = 0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            MAX_TREE_H = Integer.max(MAX_TREE_H, tree[i]);
        }

        sum = 0;
        left = 0;
        mid = 0;
        right = MAX_TREE_H;
        // Get lower bound
        while (left <= right) {
            mid = (left + right) / 2;
            sum = cutTree(tree, mid);
            if (sum < M) { // 자른 양이 적음. 더 잘라야 하므로 기준(mid) 낮춤.
                right = mid - 1;
            } else { // 자른 양이 많거나 같음. 덜 잘라야 하므로 기준(mid) 높임.
                left = mid + 1;
            }
        }
        System.out.println(right);
    }

    private static long cutTree(int[] tree, int height) {
        long sum = 0;
        for (int aTree : tree) {
            if (aTree - height > 0) {
                sum += aTree - height;
            }
        }
        return sum;
    }
}
