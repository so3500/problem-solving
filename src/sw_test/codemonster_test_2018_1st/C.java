package sw_test.codemonster_test_2018_1st;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class SolutionC {

	class Node {
		int no;
		int upPower;
		int downHealth;

		public Node(int no, int upPower, int downHealth) {
			this.no = no;
			this.upPower = upPower;
			this.downHealth = downHealth;
		}
	}

	int[] answer = {};
	int[] healths;
	List<Node> itemList;

	public int[] solution(int[] healths, int[][] items) {
		init(healths, items);
		solve();
		return answer;
	}

	public void init(int[] healths, int[][] items) {
		this.healths = healths;
		Arrays.sort(healths);

		itemList = new LinkedList<>();
		for (int idx = 0; idx < items.length; idx++) {
			itemList.add(new Node(idx + 1, items[idx][0], items[idx][1]));
		}
		Collections.sort(itemList, (o1, o2) -> o1.downHealth - o2.downHealth);

	}

	public void solve() {
		List<Integer> noList = new ArrayList<>();
		for (int hIdx = 0; hIdx < healths.length; hIdx++) {
			int health = healths[hIdx];
			int no = 0;
			Node lastNode = null;
			for (Node node : itemList) {
				if (health - node.downHealth >= 100) {
					no = node.no;
					lastNode = node;
				} else {
					break;
				}
			}
			
			if(no > 0) {
				itemList.remove(lastNode);
				noList.add(no);
			}
		}
		
		if(noList.size() > 0) {
			answer = noList.stream().mapToInt(i -> i).toArray();
			Arrays.sort(answer);
		}
	}

}

public class C {

	public static void main(String[] args) {
		SolutionC solution = new SolutionC();
		int[] healths = {200, 120, 150};
		int[][] items = {{30, 100}, {500, 30}, {100, 400}};
		solution.solution(healths, items);
	}
}
