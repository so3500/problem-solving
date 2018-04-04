package examples;

import java.util.Arrays;

public class Compare {

    static class Persion implements Comparable<Persion> {
        int id, age;
        String name;

        public Persion(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Persion p) {
            if (this.age > p.age) return 1;
            else if (this.age == p.age) {
                return this.name.compareTo(p.name);
            } else return -1;
        }
    }

    public static void main(String[] args) {
        final int SIZE = 5;
        Persion[] pList = new Persion[SIZE];
        pList[0] = new Persion(1, 35, "MIKLE");
        pList[1] = new Persion(2, 35, "1ECADW");
        pList[2] = new Persion(3, 35, "A3BD");
        pList[3] = new Persion(4, 53, "HOOOL");
        pList[4] = new Persion(5, 15, "HOOO3");
        Arrays.sort(pList, ((o1, o2) -> {
            if (o1.age > o2.age) return 1;
            else if (o1.age == o2.age) {
                return o1.name.compareTo(o2.name); // 알파벳순 오름차순
//                return o2.name.compareTo(o1.name); // 알파벳역순 내림차순
//                return o1.name.length() - o2.name.length(); // 이름 길이 오름차순
//                return o2.name.length() - o1.name.length(); // 이름 길이 내림차순
            } else return -1;
        }));
//        Arrays.sort(pList);
        for (int i = 0; i < SIZE; i++) {
            System.out.println(pList[i].id + " " + pList[i].age + " " + pList[i].name);
        }

    }

}
