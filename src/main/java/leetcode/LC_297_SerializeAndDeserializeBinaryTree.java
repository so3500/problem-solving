package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * related topic:
 * Time Complexity: O()
 * Space Complexity: O()
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LC_297_SerializeAndDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeWithRecursion(root, sb);
		return sb.toString();
	}

	private void serializeWithRecursion(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("null").append(",");
			return;
		}

		sb.append(root.val).append(",");
		serializeWithRecursion(root.left, sb);
		serializeWithRecursion(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] values = data.split(",");
		Queue<String> queue = new LinkedList<>(Arrays.asList(values));
		return deserializeWithRecursion(queue);
	}

	private TreeNode deserializeWithRecursion(Queue<String> values) {
		String value = values.poll();

		if ("null".equals(value)) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.valueOf(value));
		root.left = deserializeWithRecursion(values);
		root.right = deserializeWithRecursion(values);

		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));