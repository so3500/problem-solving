/*
 * 문제: 14438 수열과 쿼리 17 / 732 ms
 * link: https://www.acmicpc.net/problem/14438
 * 알고리즘: 세그먼트 트리
 * 풀이방법:
 *      기존의 O(NM) 을 O(MlogN) 으로 개선
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *      세그먼트 트리 생성
 *      세그먼트 트리 update, min 질의 당 O(lonN) 시간 소요
 *
 * 공간복잡도(Space Complexity)
 *
 * */
// 풀이 참고: https://www.acmicpc.net/blog/view/9
package boj;

import java.io.*;
import java.util.Arrays;

public class Boj_14438 {

    static int M, N, H;
    static int[] A, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;
        int i, j, k, v, tempN, query;
        N = Integer.parseInt(br.readLine());
        // 2의 지수 구하기
        tempN = N;
        while (tempN != 0) {
            tempN /= 2;
            H++;
        }
        A = new int[N + 1];
        tree = new int[(int) Math.pow(2, H + 1)];
        Arrays.fill(tree, Integer.MAX_VALUE);
        // 기본 배열 만들기
        input = br.readLine().split(" ");
        for (i = 0; i < N; i++) {
            A[i + 1] = Integer.parseInt(input[i]);
        }
        // segment tree 만들기
        init(1, 1, N);
        // 질의 수행
        M = Integer.parseInt(br.readLine());
        for (k = 0; k < M; k++) {
            input = br.readLine().split(" ");
            query = Integer.parseInt(input[0]);
            switch (query) {
                case 1:
                    i = Integer.parseInt(input[1]);
                    v = Integer.parseInt(input[2]);
                    update(1, 1, N, i, v);
                    break;
                case 2:
                    i = Integer.parseInt(input[1]);
                    j = Integer.parseInt(input[2]);
                    bw.write(min(1, 1, N, i, j) + "\n");
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    // 1 i v : Ai를 v로 바꾼다.
    static int update(int node, int start, int end, int idx, int newValue) {
        // 1. [start, end] 에 index 포함되지 않는 경우
        if (idx < start || end < idx) return tree[node];

        // 2. [start, end] 에 index 포함되는 경우
        // 값을 바꿔야 할 대상 리프노드 인 경우
        if (start == end) return tree[node] = newValue;
        // 리프노드가 아닌 경우, 자식 노드도 변경해줘야 하기 때문에 해당 조건문으로 리프노드 여부 검사
        return tree[node] = Integer.min(update(node * 2, start, (start + end) / 2, idx, newValue),
                update(node * 2 + 1, (start + end) / 2 + 1, end, idx, newValue));
    }

    // 2 i j : Ai, Ai+1, ..., Aj 에서 가장 크기가 작은 값을 출력한다.
    // 이때 세그먼트 트리에서 index i ~ j 에서 크기가 작은 값을 갱신한다.
    // start, end: node 가 담당하는 구간
    // left, right: 최소값을 구해야 하는 구간

    // 1. [left,right]와 [start,end]가 겹치지 않는 경우 -> 범위를 벗어난 경우. 최대값 리턴
    // 2. [left,right]가 [start,end]를 완전히 포함하는 경우 -> tree[node] 리턴. 더 이상 들어가는 것은 비효율적
    // 3. [start,end]가 [left,right]를 완전히 포함하는 경우 -> 왼쪽, 오른쪽 자식을 루트로 하는 트리에서 재탐색
    // 4. [left,right]와 [start,end]가 겹쳐져 있는 경우 (1, 2, 3 제외한 나머지 경우) -> 해당 node 값 리턴
    static int min(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        return Integer.min(min(node * 2, start, (start + end) / 2, left, right),
                min(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
    }

    static int init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = A[start];
        } else {
            return tree[node] = Integer.min(init(node * 2, start, (start + end) / 2)
                    , init(node * 2 + 1, (start + end) / 2 + 1, end));
        }
    }

}
