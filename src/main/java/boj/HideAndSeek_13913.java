/*
 * 문제: 숨바꼭질4
 * 알고리즘:
 *  큐를 이용한 bfs 구현
 *  스택을 이용하여 경로 정보 저장
 *
 * 풀이방법:
 *  위치 N에서 bfs 탐색 시작(-1, +1, *2 인덱스를 큐에 저장)
 *  새로 방문한 위치에는 이전 위치 정보값을 저장
 *  위치 K에 도착하면 이전 위치 정보값을 참조하여 K부터 N까지 거슬러 감. 거슬러 가면서 스택에 저장
 *  스택에 저장한 값을 다시 꺼내어 출력
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *  최악의 경우 N에서 0으로 갈때 -1씩만 이동 가능하므로
 *  O(N)
 *
 * 공간복잡도(Space Complexity)
 *  크기 N 입력에 대해 큐, 스택 사용 시 최대 N만큼 저장함
 *  O(N)
 * */

package boj;

import java.util.*;

public class HideAndSeek_13913 {

    static Queue<Integer> queue;
    static Stack<Integer> stack;
    static int[] seq;
    static final int SIZE_OF_SEQ = 100000 + 100000;
    static int N, K;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        queue = new LinkedList<Integer>();
        stack = new Stack<>();

        N = sc.nextInt();
        K = sc.nextInt();
        sc.close();

        seq = new int[SIZE_OF_SEQ + 1];
        Arrays.fill(seq, -1);
        seq[N] = N;
        queue.add(N);
        bfs();
        printPath();
    }

    private static void bfs() {
        int start, left, right, rightDouble;
        while (!queue.isEmpty()) {
            start = queue.poll();
            left = start - 1;
            right = start + 1;
            rightDouble = start * 2;
            if (start == K) {
                break;
            }
            // dest 가 방문 전이면 방문표시하고(어디서로부터 왔는지 저장) 큐에 추가
            if (0 <= left && seq[left] == -1) {
                seq[left] = start;
                queue.add(left);
            }
            if (right <= SIZE_OF_SEQ && seq[right] == -1) {
                seq[right] = start;
                queue.add(right);
            }
            if (rightDouble <= SIZE_OF_SEQ && seq[rightDouble] == -1) {
                seq[rightDouble] = start;
                queue.add(rightDouble);
            }
        }
    }

    private static void printPath() {
        int elm = K;
        int time = 0;
        StringBuffer buffer = new StringBuffer();
        // K를 찾은 길을 거슬러 찾아감
        while (elm != N) {
            stack.push(elm);
            elm = seq[elm];
            time++;
        }
        stack.push(elm); // N push
        buffer.append(time).append("\n");
        while (!stack.isEmpty()) {
            buffer.append(stack.pop()).append(" ");
        }
        System.out.println(buffer);
    }
}
