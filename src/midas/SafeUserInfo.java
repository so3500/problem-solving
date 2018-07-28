package midas;

import java.util.Scanner;

public class SafeUserInfo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String id, pwd;
		char ans = 'T';
		boolean isCon;
		int idNumCnt, idCharCnt, pwdNumCnt, pwdCharCnt, con;
		id = sc.next();
		pwd = sc.next();

		if (id.length() < 6 || id.length() > 12 || pwd.length() < 8 || pwd.length() > 16) {
			ans = 'F';
		} else {
			idNumCnt = 0;
			idCharCnt = 0;
			pwdNumCnt = 0;
			pwdCharCnt = 0;
			con = 0;
			isCon = false;
			for (int i = 0; i < id.length(); i++) {
				if (check(id.charAt(i)) == 2) {
					idNumCnt++;
				} else if (check(id.charAt(i)) == 1) {
					idCharCnt++;
				} else { // 소문자, 숫자가 아닐 경우 F
					ans = 'F';
					break;
				}
			}
			if(ans =='T') {
				for (int i = 0; i < pwd.length(); i++) {
					if (check(pwd.charAt(i)) == 1) {
						pwdCharCnt++;
						if (i > 0 && pwd.charAt(i - 1) == pwd.charAt(i)) {
							con++;
						} else {
							con = 0;
						}
						if (con == 2) { // 연속으로 동일한 문자가 나올경우 'F'
							isCon = true;
						}
					} else if (check(pwd.charAt(i)) == 2) {
						pwdNumCnt++;
						if (i > 0 && pwd.charAt(i - 1) == pwd.charAt(i)) {
							con++;
						} else {
							con = 0;
						}
						if (con == 2) { // 연속으로 동일한 문자가 나올경우 'F'
							isCon = true;
						}
					} else { // 소문자, 숫자가 아닐 경우 F
						ans = 'F';
						break;
					}
				}	
			}

			
			if (idNumCnt == 0 || idCharCnt == 0 || pwdNumCnt == 0 || pwdCharCnt == 0 || isCon) {
				ans = 'F';
			}
		}

		System.out.println(ans);
		sc.close();
	}

	public static int check(char a) {
		int ret = 0;
		// 알파벳이면 1, 숫자이면 2 반환
		if (97 <= a && a <= 122) {
			ret = 1;
		} else if (48 <= a && a <= 57) {
			ret = 2;
		}
		return ret;
	}

}
