/*
* 문제: 11933 ATM / 80ms
* link: https://www.acmicpc.net/problem/11399
* 알고리즘: 구현
* 풀이방법:
*   각 사람이 인출하는 데 필요한 최소의 시간을 구하기 위해서 "인출 시간이 짧은 사람" 순서대로 일을 처리한다.
*   본인 순서가 온 사람을 A라고 하면. A가 인출하는동안 걸리는 시간 + 다른사람들이 기다리는 시간
*
*
* 의사코드(Pseudo Code)
*   input N
*   init delayTime[N] with N numbers
*   sort delayTime with ascending order
*   totalDelayTime <- 0
*   numOfPerson <- 0
*   for i:0 to N-1
*       totalDelayTime += numOfPerson * delayTime[i]
*       nunOfPerson -= 1
*
*   print totalDelayTime
*
* 시간복잡도(Time Complexity)
*   1차원 배열에 대한 초기화 후 정렬
*   O(NlogN)
*
* 공간복잡도(Space Complexity)
*   1차원 배열 사용
*   O(N)
*
* */


package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//public class Main{
public class ATM_11399 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N, i, totalDelayTime, numOfPerson;
        int[] delayTime = null;

        // input & initialization
        N = Integer.parseInt(br.readLine());
        delayTime = new int[N];
        st = new StringTokenizer(br.readLine());
        for (i = 0; i < N; i++) {
            delayTime[i] = Integer.parseInt(st.nextToken());
        }

        // algorithm
        Arrays.sort(delayTime);
        totalDelayTime = 0;
        numOfPerson = N;
        for (i = 0; i < N; i++) {
            totalDelayTime += numOfPerson * delayTime[i];
            numOfPerson -= 1;
        }
        System.out.println(totalDelayTime);
    }
}
