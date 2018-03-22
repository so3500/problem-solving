/*
 * 문제: 2477. [모의 SW 역량테스트] 차량 정비소 / 223 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV6c6bgaIuoDFAXy
 * 알고리즘: 구현, 시뮬레이션
 * 풀이방법:
 * 모든 손님이 용무가 끝날 때까지 반복

    1-1. 접수 데스크에서 끝난 손님이 있다면
         빈자리 확보
         큐에 추가
    1-2. 수리 데스크에서 끝난 손님이 있다면
         빈자리 확보

    2. 도착손님이 있다면 -> 접수데스크에 빈 자리 여부 확인
    도착손님 파악여부는 time 과 cPointer 가 가리키고 있는 시간비교해서
        있으면
            reception 에 (고객번호, 남은시간)
            cPointer++

    3. 대기손님이 있다면(큐) -> 수리 데스크 빈 자리 여부 확인
        있으면
            repair 에 (고객번호, 남은시간)
            A == 접수 데스크, B == 수리 데스크 이면 ans += 고객번호

    4. 1시간 경과 시뮬레이션
        time++
        접수 테스크에 있는 손님들 대기 시간 1씩 감소
        수리 데스크에 있는 손님들 대기 시간 1씩 감소
           볼일 다 끝난 손님 카운팅
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   위 1,2,3,4 는 모두 O(1)안에 끝난다.
 *   전체적인 while 반복문은 고객의 수 K, 고객의 도착시간 중 최장시간 tK 만큼 수행되므로
 *   O(K * tk)
 *
 * 공간복잡도(Space Complexity)
 *   문제에서 사용되는 배열들은 크기가 작으므로 O(1)
 *   큐는 최악의 경우 고객 K만큼 채워지므로
 *   O(K)
 *
 * */

package swexpert;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SE_2477 {

    private static class Customer {
        int no, recepNo, repairOrder;

        public Customer(int no, int recepNo, int repairOrder) {
            this.no = no;
            this.recepNo = recepNo;
            this.repairOrder = repairOrder;
        }
    }

    static int[][] reception, repair;
    static int N, M, K, A, B, cPointer, time, ans;
    //   정비창구
    //1. 먼저 정비창구로 온 고객이 우선
    //2. 두명 이상의 고객들이 접수 창구에서 동시에 접수를 완료하고
    //   정비 창구로 이동한 경우, 접수 창구번호가 작은 고객이 우선
    static PriorityQueue<Customer> pq = new PriorityQueue<>((c1, c2) -> {
        if (c1.repairOrder > c2.repairOrder) return 1;
        else if (c1.repairOrder == c2.repairOrder) {
            return c1.recepNo > c2.recepNo ? 1 : -1;
        }
        return -1;
    });
    static int[] customer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, deskNo, endCustomer, repairOrder;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            endCustomer = 0;
            repairOrder = 1;
            while (endCustomer < K) {
                // 1-1. 접수 데스크에 끝난 손님이 있는지 파악
                for (deskNo = 1; deskNo <= N; deskNo++) {
                    if (reception[deskNo][1] != 0 && reception[deskNo][2] == 0) {
                        Customer c = new Customer(reception[deskNo][1], deskNo, repairOrder);
                        repairOrder++;
                        pq.add(c);
                        reception[deskNo][1] = 0; // 빈자리 확보
                    }
                }

                // 1-2. 수리 데스크에 끝난 손님이 있는지 파악
                for (deskNo = 1; deskNo <= M; deskNo++) {
                    if (repair[deskNo][1] != 0 && repair[deskNo][2] == 0) {
                        repair[deskNo][1] = 0; // 빈자리 확보
                    }
                }

                // 2. 접수 데스크에서 빈 자리 확인
                for (deskNo = 1; deskNo <= N; deskNo++) {
                    // 손님이 남아있으며, 도착한 손님이 있다면 채우기
                    if (reception[deskNo][1] == 0 && cPointer <= K && time >= customer[cPointer]) {
                        reception[deskNo][1] = cPointer; // 고객 번호
                        reception[deskNo][2] = reception[deskNo][0]; // 접수 시간 초기화
                        cPointer++;
                    }
                }

                // 3. 수리 데스크 빈 자리 확인
                for (deskNo = 1; deskNo <= M; deskNo++) {
                    // 빈 자리 있고, 대기손님도 있다면
                    if (repair[deskNo][1] == 0 && !pq.isEmpty()) {
                        Customer c = pq.poll();
                        repair[deskNo][1] = c.no;
                        repair[deskNo][2] = repair[deskNo][0]; // 수리 시간 초기화
                        if (c.recepNo == A && deskNo == B) ans += c.no; // 접수, 수리 데스크 번호가 A,B와 같을 시
                        c = null;
                    }
                }

                // 4. 1시간 경과 시뮬레이션
                time++;
                for (deskNo = 1; deskNo <= N; deskNo++) {
                    if (reception[deskNo][1] != 0) {
                        reception[deskNo][2] -= 1;
                    }
                }
                for (deskNo = 1; deskNo <= M; deskNo++) {
                    if (repair[deskNo][1] != 0) {
                        repair[deskNo][2] -= 1;
                        if (repair[deskNo][2] == 0) endCustomer++; // 볼일 다끝난 손님 카운팅
                    }
                }
            }
            if (ans == 0) System.out.println("#" + t + " -1");
            else System.out.println("#" + t + " " + ans);
        }
    }

    static void init(Scanner sc) {
        int deskNo;
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        customer = new int[K + 2];
        reception = new int[N + 1][3];
        repair = new int[M + 1][3];
        for (deskNo = 1; deskNo <= N; deskNo++) {
            reception[deskNo][0] = sc.nextInt();
        }
        for (deskNo = 1; deskNo <= M; deskNo++) {
            repair[deskNo][0] = sc.nextInt();
        }
        for (deskNo = 1; deskNo <= K; deskNo++) {
            customer[deskNo] = sc.nextInt();
        }
        cPointer = 1;
        time = 0;
        ans = 0;
        pq.clear();
    }
}
