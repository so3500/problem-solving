package examples;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueEx {

    static class B implements Comparable<B> {
        int key, value;

        public B(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(B b) {
            return this.value >= b.value ? -1 : 1; // 내림차순
        }
    }

    public static void main(String[] args) {
        int N = 10;
        // pq는 기본 오름차순 정렬
        // 내림차순 정렬을 위해서는 아래와 같이 new Comparable 을 (람다식으로) 구현
        PriorityQueue<Integer> PA = new PriorityQueue<>(N, (a, b) -> {
            return a >= b ? -1 : 1; // 내림차순 정렬
        });

        // 람다식이 아닌 아래와 같이 구현할 경우 아주 장황한 코드를 작성해야 한다.
        PriorityQueue<Integer> PB = new PriorityQueue<>(N, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 >= o2 ? 1 : -1; // 오름차순
            }
        });
    }

    static void printQ(){
//        while (!PA.isEmpty()) {
//            System.out.print(PA.poll() + " ");
//        }
//        System.out.println();
//        while(!PB.isEmpty())
//
//        {
//            B b = PB.poll();
//            System.out.print("(" + b.key + "," + b.value + ") ");
//        }
    }

}
