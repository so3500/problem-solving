/*
 * 길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는 경우 true를, 아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.

제한사항
배열의 길이는 10만 이하입니다.
배열의 원소는 10만 이하의 자연수입니다.

입출력 예
arr	result
[4, 1, 3, 2]	true
[4, 1, 3]	false

입출력 예 설명
입출력 예 #1
입력이 [4, 1, 3, 2]가 주어진 경우, 배열의 길이가 4이므로 배열에는 1부터 4까지 숫자가 모두 들어 있어야 합니다.
[4, 1, 3, 2]에는 1부터 4까지의 숫자가 모두 들어 있으므로 true를 반환하면 됩니다.

입출력 예 #2
[4, 1, 3]이 주어진 경우, 배열의 길이가 3이므로 배열에는 1부터 3까지 숫자가 모두 들어 있어야 합니다. 
[4, 1, 3]에는 2가 없고 4가 있으므로 false를 반환하면 됩니다.
 * 
 * 
 * */


package programmers;

public class TestA {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1, 2, 3, 4};
        System.out.println(solution(arr));
    }

    public static boolean solution(int[] arr) {
        boolean answer = true;
        int cnt, max;
        cnt = 0;
        max = Integer.MIN_VALUE;
        boolean[] check = new boolean[100001];
        for (int i = 0; i < arr.length; i++) {
            max = Integer.max(max, arr[i]);
            if (!check[arr[i]]) {
                check[arr[i]] = true;
                cnt++;
            } else { // 중복이 한번이라도 발생하는 경우 false
                answer = false;
                break;
            }
        }

        // 위에서 중복여부를 피했지만 1~n 까지의 숫자가 한번씩 들어오지 않은 경우 false
        if (answer && cnt < max) {
            answer = false;
        }
        return answer;
    }

}
