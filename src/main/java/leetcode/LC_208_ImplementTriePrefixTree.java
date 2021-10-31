package leetcode;

/**
 * related topic: Trie
 * Time Complexity:
 * Space Complexity:
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class LC_208_ImplementTriePrefixTree {

	public class Trie {
		private final TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (node.children[c - 'a'] == null) {
					node.children[c - 'a'] = new TrieNode();
				}
				node = node.children[c - 'a'];
			}
			node.isWord = true;
		}

		public boolean search(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (node.children[c - 'a'] == null) {
					return false;
				}
				node = node.children[c - 'a'];
			}
			return node.isWord;
		}

		public boolean startsWith(String prefix) {
			TrieNode node = root;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (node.children[c - 'a'] == null) {
					return false;
				}
				node = node.children[c - 'a'];
			}
			return true;
		}
	}

	class TrieNode {
		public final TrieNode[] children = new TrieNode[26];
		public boolean isWord;
	}
}