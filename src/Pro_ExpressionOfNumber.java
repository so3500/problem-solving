public class Pro_ExpressionOfNumber {
/*
    https://programmers.co.kr/learn/challenge_codes/156

	for i: 1 to N
  	x <- i
    for j: i+1 to ... until x<num
    	x <- x+j
    if x = N
    	answer <- answer+1

*/
    public int expressions(int num) {
        int answer = 0;
        int x = 0;
        for (int i=1; i<=num; i++){
            x = i;
            for (int j=i+1; x<num; j++){
                x += j;
            }
            if (x == num) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        Pro_ExpressionOfNumber expressions = new Pro_ExpressionOfNumber();
        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(expressions.expressions(15));
    }
}
