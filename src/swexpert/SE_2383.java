/*
 * 문제: 2383. [모의 SW 역량테스트] 점심 식사시간 / 157 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5-BEE6AK0DFAVl&
 * 알고리즘: 완전탐색, 구현, 시뮬레이션
 * 풀이방법:
 *      사람들을 두 그룹으로 나누어 각 계단에 도착하는 경우의 수를 구한다.
 *          도착한 시간 순으로 사람들의 리스트를 나열한다.
 *          리스트가 빌 때 까지 계단 내려가기 시뮬레이션을 한다. (단, 도착시간보다 경과시간이 이를 경우 계단을 내려가지 않는다)
 *          측정한 시간 중 최소값을 갱신한다.
 *
 *
 *     사람들의 리스트를 도착한 시간 순으로 나열하는 방법은 아래와 같이 여러가지 방법이 있다.
 *     1. PriorityQueue 사용 + Comparator 람다식 구현
 *     2. class P 에 Comparable 구현, List, Collections.sort 사용
 *     3. List, Collections.sort + Comparator 람다식 구현
 *
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package swexpert;

import java.util.*;

public class SE_2383 {

    static class Obj {
        int r, c;

        public Obj(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class P extends Obj implements Comparable<P> {
        int arrivalTime, runTime;

        public P(int r, int c) {
            super(r, c);
        }

        @Override // natural order
        public int compareTo(P o) {
            return this.arrivalTime - o.arrivalTime;
        }
    }

    static class S extends Obj {
        int stairLen;

        public S(int r, int c, int stairLen) {
            super(r, c);
            this.stairLen = stairLen;
        }
    }

    static int N, pNum, minTime, maxArrivalTime;
    static boolean[] visited;
    static P[] persion;
    static S[] stair;
    //    static PriorityQueue<P> pq1, pq2;
    static List<P> pList1, pList2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            solve(0);
            System.out.println("#" + t + " " + minTime);
        }
        sc.close();
    }

    private static void solve(int idx) {
        // 사람들이 두 그룹으로 나누어졌을 때 시뮬레이션 하기
        maxArrivalTime = Integer.MIN_VALUE;
        for (int i = 0; i < pNum; i++) {
            if (visited[i]) {
                persion[i].arrivalTime = Math.abs(persion[i].r - stair[0].r) + Math.abs(persion[i].c - stair[0].c);
                maxArrivalTime = Integer.max(maxArrivalTime, persion[i].arrivalTime);
                persion[i].runTime = stair[0].stairLen;
                pList1.add(persion[i]);
//                pq1.add(persion[i]);
            } else {
                persion[i].arrivalTime = Math.abs(persion[i].r - stair[1].r) + Math.abs(persion[i].c - stair[1].c);
                maxArrivalTime = Integer.max(maxArrivalTime, persion[i].arrivalTime);
                persion[i].runTime = stair[1].stairLen;
                pList2.add(persion[i]);
//                pq2.add(persion[i]);
            }
        }
//        while (!pq1.isEmpty()) pList1.add(pq1.poll());
//        while (!pq2.isEmpty()) pList2.add(pq2.poll());
        Collections.sort(pList1);
        Collections.sort(pList2);
//        Collections.sort(pList1, (p1, p2) -> {
//            if (p1.arrivalTime >= p2.arrivalTime) return 1;
//            else return -1;
//        });
        getTime();

        // 사람들을 두 그룹으로 나누는 모든 경우의 수 구하기
        for (int i = idx; i < pNum; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(i + 1);
                visited[i] = false;
            }
        }
    }

    private static void getTime() {
        int time = 0;
        while (!pList1.isEmpty() || !pList2.isEmpty()) {
            if (!pList1.isEmpty()) goDown(pList1, time);
            if (!pList2.isEmpty()) goDown(pList2, time);
            time++;
        }
        minTime = Integer.min(minTime, time);
    }

    private static void goDown(List<P> pList, int time) {
        int remain = Integer.min(3, pList.size());
        // 최대 3명이 계단을 한칸씩 내려가도록 처리
        for (int i = 0; i < remain; i++) {
            if (time > pList.get(i).arrivalTime) pList.get(i).runTime--;
        }
        // 계단 다 내려간 사람 처리
        for (int i = 0; i < remain; i++) {
            if (pList.get(0).runTime == 0) pList.remove(0);
        }
    }

    private static void init(Scanner sc) {
        int r, c, input, pIdx, sIdx;
        pIdx = 0;
        sIdx = 0;
//        pq1 = new PriorityQueue<>((p1, p2) -> {
//            if (p1.arrivalTime > p2.arrivalTime) return 1;
//            else return -1;
//        });
//        pq2 = new PriorityQueue<>((p1, p2) -> {
//            if (p1.arrivalTime > p2.arrivalTime) return 1;
//            else return -1;
//        });
        pList1 = new LinkedList<>();
        pList2 = new LinkedList<>();
        persion = new P[10];
        stair = new S[2];

        N = sc.nextInt();
        for (r = 0; r < N; r++) {
            for (c = 0; c < N; c++) {
                input = sc.nextInt();
                if (input == 1) { // 사람
                    persion[pIdx++] = new P(r, c);
                } else if (input >= 2) { // 계단
                    stair[sIdx++] = new S(r, c, input);
                }
            }
        }
        pNum = pIdx; // 사람 수
        visited = new boolean[pNum];
        minTime = Integer.MAX_VALUE;
    }
}
