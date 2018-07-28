package midas;

import java.util.HashSet;
import java.util.Scanner;

public class AutoMailNaming {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String comp, input, first, middle, last, emailName;
		String[] nameList, name, lastName;
		int nameCnt;

		comp = sc.next().toLowerCase();
		sc.nextLine();
		input = sc.nextLine();
		nameList = input.split(",");
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < nameList.length; i++) {
			if (nameList[i].equals(" ") || nameList[i].equals("")) {
				continue;
			}
			name = nameList[i].split(" ");
			nameCnt = 0;
			first = "";
			middle = "";
			last = "";
			for (int j = 0; j < name.length; j++) {
				if (name[j].equals("")) {
					continue;
				}
				if (nameCnt == 0) {
					first = name[j].toLowerCase();
				} else if (nameCnt == 1) {
					middle = name[j].toLowerCase();
				} else if (nameCnt == 2) {
					last = name[j].toLowerCase();
				}
				nameCnt++;
			}

			lastName = new String[2];
			emailName = "";
			// 이메일에 들어갈 이름 제작
			if (nameCnt == 2) { // first, middle
				lastName = getLast(middle);
			} else if (nameCnt == 3) { // fist, last
				lastName = getLast(last);
			}

			if (lastName.length == 1) {
				emailName = lastName[0] + first.substring(0, 1);
			} else if (lastName.length == 2) {
				emailName = lastName[0] + lastName[1] + first.substring(0, 1);
			}

			// 중복 여부 검사, 중복될 경우 뒤에 숫자 붙임
			int idx = 2;
			String tempEmailName = emailName;
			while (set.contains(tempEmailName)) {
				tempEmailName = emailName + idx;
				idx++;
			}
			set.add(tempEmailName);
			sb.append(tempEmailName).append("@").append(comp).append(".com, ");
		}
		sb.delete(sb.length()-2, sb.length());
		System.out.println(sb);
		sc.close();
	}

	public static String[] getLast(String input) {
		String[] ret;
		ret = input.split("-");
		return ret;
	}
}
