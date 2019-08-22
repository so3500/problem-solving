///*
// * 문제: 김식당
// * 알고리즘:
// *  벡터를 이용하여 선형 자료구조 저장
// *  필요 시 정렬, 삭제, 조회
// * 풀이방법:
// *  order 질의: 데이터 저장
// *  sort 질의: 데이터 정렬, compare 함수를 overrdie 한 comparator 인터페이스 구현체 사용
// *  complete 질의: 데이터 삭제
// *
// * 의사코드(Pseudo Code)
// *
// * 시간복잡도(Time Complexity)
// *  입력 N에 대하여
// *      삽입: O(1) => O(N)
// *      삭제: O(N) => O(N^2)
// *      조회: O(N): 선형 탐색 필요
// *  O(N^2)
// *
// * 공간복잡도(Space Complexity)
// *  크기 N 입력에 대해 1차원 벡터를 이용하여 구현
// *  O(N)
// * */
//
//package boj;
//
//import kotlin.Pair;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.StringTokenizer;
//import java.util.Vector;
//
////public class Main {
//public class KimRestaurant_14612 {
//    static StringBuffer buffer;
//
//    public static void main(String[] args) throws Exception {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//        StringTokenizer st = null;
//
//        int N, M, i, tableNo, orderTime;
//        String query;
//        Vector<Pair<Integer, Integer>> orderVector = new Vector<>(); // Pair<tableNum, orderTime>
//        buffer = new StringBuffer();
//
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        for (i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            query = st.nextToken();
//            if (query.equals("order")) {
//                tableNo = Integer.parseInt(st.nextToken());
//                orderTime = Integer.parseInt(st.nextToken());
//                Pair<Integer, Integer> elm = new Pair<>(tableNo, orderTime);
//                orderVector.add(elm);
//            } else if (query.equals("complete")) {
//                tableNo = Integer.parseInt(st.nextToken());
//                completeOrder(orderVector, tableNo);
////                if (orderVector.isEmpty()) continue;
//            } else if (query.equals("sort")) {
//                orderVector.sort(new orderTimeCompare());
//            }
//            if (orderVector.isEmpty()) {
//                System.out.println("sleep");
//            } else {
//                printOrder(orderVector);
//            }
//        }
//    }
//
//    static class orderTimeCompare implements Comparator<Pair<Integer, Integer>> {
//        // 주문시간 별 오름차순 정렬
//        // 주문시간이 같을 시 테이블 번호(key)순으로 정렬
//        @Override
//        public int compare(Pair<Integer, Integer> arg0, Pair<Integer, Integer> arg1) {
//            if (arg0.getValue() == arg1.getValue()) {
//                return arg0.getKey().compareTo(arg1.getKey());
//            } else {
//                return arg0.getValue().compareTo(arg1.getValue());
//            }
//        }
//    }
//
//    private static void printOrder(Vector<Pair<Integer, Integer>> order) {
//        if (buffer.length() > 0) {
//            buffer.delete(0, buffer.length());
//        }
//        for (Pair p : order) {
//            buffer.append(p.getKey()).append(" ");
//        }
//        buffer.deleteCharAt(buffer.length() - 1); // 맨 마지막 공백 제거
//        System.out.println(buffer);
//    }
//
//    private static void completeOrder(Vector<Pair<Integer, Integer>> order, int tableNo) {
//        for (int i = 0; i < order.size(); i++) {
//            if (order.get(i).getKey() == tableNo) {
//                order.remove(i);
//                break;
//            }
//        }
//    }
//}
