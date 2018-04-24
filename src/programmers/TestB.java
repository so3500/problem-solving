/*
* 문제: 2018 여름 인턴십 코딩 데모 테스트 / 문제2
* link: https://programmers.co.kr/competitions
* 알고리즘: DP
* 풀이방법:
* 	pelindrom[left][right]: index 가 left 에서 시작하고 right 에서 끝나는 문자열의 펠린드롬 여부
* 	길이가 1인 문자열은 모두 펠린드롬 처리
* 	길이가 2인 문자열은 left, right가 같을 때 펠린드롬 처리
* 	길이가 3 이상인 문자열부터는
* 		left+1, right-1 인 문자열이 펠린드롬이며 + left, right가 같으면 펠린드롬 처리
* 
* 	이때 순회하는 문자열의 개수는
* 	n + (n-1) + (n-2) + ... + 1
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*
* 공간복잡도(Space Complexity)
*
*
앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.

예를들면, 문자열 s가 abcdcba이면 7을 return하고 abacde이면 3을 return합니다.

제한사항
문자열 s의 길이 : 2500 이하의 자연수
문자열 s는 알파벳 소문자로만 구성
입출력 예
s	answer
abcdcba	7
abacde	3
입출력 예 설명
입출력 예 #1
4번째자리 'd'를 기준으로 문자열 s 전체가 팰린드롬이 되므로 7을 return합니다.

입출력 예 #2
2번째자리 'b'를 기준으로 aba가 팰린드롬이 되므로 3을 return합니다.
* */

package programmers;

public class TestB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("abacde");
		solution("abcdcba");
	}

	public static int solution(String s) {
		int answer = 0;
		int left, right, mid, maxPelLen;
		boolean[][] pelindrom = new boolean[s.length()][s.length()];

		maxPelLen = 1;
		// 길이 1
		for (left = 0; left < s.length(); left++) {
			pelindrom[left][left] = true;
		}
		// 길이 2
		for (left=0; left<s.length()-1; left++) {
			right =left+1;
			if(s.charAt(left) == s.charAt(right)) {
				pelindrom[left][right]=true;
			}
		}
		// 길이 3 이상
		for (mid = 1; mid < s.length(); mid++) {
			for (left = 0; left < s.length() - mid - 1; left++) {
				right = left + mid + 1;
				if (s.charAt(left) == s.charAt(right) && pelindrom[left + 1][right - 1]) {
					pelindrom[left][right] = true;
					if (maxPelLen < right - left + 1) {
						maxPelLen = right - left + 1;
					}
				}
			}
		}
		answer = maxPelLen;
		return answer;
	}

}
