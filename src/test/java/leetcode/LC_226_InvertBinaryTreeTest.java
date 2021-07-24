package leetcode;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LC_226_InvertBinaryTreeTest {

	private final LC_226_InvertBinaryTree lc226 = new LC_226_InvertBinaryTree();

	// [1,2,3] -> [1,3,2]
	@Test
	void invertTree1() {
		TreeNode root = lc226.invertTree(getTree1());

		assertAll(
			() -> assertThat(root.val).isEqualTo(1),
			() -> assertThat(root.left.val).isEqualTo(3),
			() -> assertThat(root.right.val).isEqualTo(2)
		);
	}

	// [1,2] -> [1,null,2]
	@Test
	void invertTree2() {
		TreeNode root = lc226.invertTree(getTree2());

		assertAll(
			() -> assertThat(root.val).isEqualTo(1),
			() -> assertThat(root.left).isNull(),
			() -> assertThat(root.right.val).isEqualTo(2)
		);
	}

	// [] -> []
	@Test
	void invertTree3() {
		TreeNode root = lc226.invertTree(getTree3());

		assertThat(root).isNull();
	}

	private static TreeNode getTree1() {
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);

		return new TreeNode(1, left, right);
	}

	private static TreeNode getTree2() {
		TreeNode left = new TreeNode(2);

		return new TreeNode(1, left, null);
	}

	private static TreeNode getTree3() {
		return null;
	}

}