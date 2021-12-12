package leetcode;

/**
 * related topic: Tree, Binary Tree, Depth-First Search
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC_543_DiameterOfBinaryTree {
	private static final int DISTANCE_TO_CHILD = 1;

	public int diameterOfBinaryTree(TreeNode root) {
		SearchResult result = search(root);
		return result.maxDiameter;
	}

	private SearchResult search(TreeNode root) {
		if (root == null) {
			return SearchResult.nullNode();
		}

		SearchResult left = search(root.left);
		SearchResult right = search(root.right);

		// root ~ leaf 최대 거리
		int maxDistanceToLeaf = Integer.max(left.maxLengthToLeaf, right.maxLengthToLeaf) + DISTANCE_TO_CHILD;
		// 임의의 두 node 간 거리 최대값 (root 경유)
		int diameter = left.maxLengthToLeaf + right.maxLengthToLeaf + DISTANCE_TO_CHILD * 2;
		// 임의의 두 node 간 거리 최대값
		int maxDiameter = Integer.max(diameter, Integer.max(left.maxDiameter, right.maxDiameter));

		return SearchResult.create(maxDistanceToLeaf, maxDiameter);
	}

	private static final class SearchResult {
		int maxLengthToLeaf;
		int maxDiameter;

		public static SearchResult nullNode() {
			SearchResult searchResult = new SearchResult();

			searchResult.maxLengthToLeaf = -1;
			searchResult.maxDiameter = 0;

			return searchResult;
		}

		public static SearchResult create(int maxDistanceToLeaf, int maxDiameter) {
			SearchResult searchResult = new SearchResult();

			searchResult.maxLengthToLeaf = maxDistanceToLeaf;
			searchResult.maxDiameter = maxDiameter;

			return searchResult;
		}
	}
}