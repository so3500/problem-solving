package leetcode;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LC_94_BinaryTreeInorderTraversalTest {

	private LC_94_BinaryTreeInorderTraversal lc94 = new LC_94_BinaryTreeInorderTraversal();

	@Test
	void inorderTraversal() {
		assertThat(lc94.inorderTraversal(getTree1())).isEqualTo(Arrays.asList(2, 1, 3));
		assertThat(lc94.inorderTraversal(getTree2())).isEqualTo(Arrays.asList(2, 1));
		assertThat(lc94.inorderTraversal(getTree3())).isEmpty();
		assertThat(lc94.inorderTraversal(getTree4())).isEqualTo(Arrays.asList(1, 2));
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

	private static TreeNode getTree4() {
		TreeNode right = new TreeNode(2);

		return new TreeNode(1, null, right);
	}
}