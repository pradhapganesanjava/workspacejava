package solstools.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

public class Distance_MinHeight {

	public static void main(String[] args) {
		Distance_MinHeight_Solution sol = new Distance_MinHeight_Solution();
		sol.minDepth(null);
	}
}

class Distance_MinHeight_Solution {
	public int minDepth(TreeNode root) {
		return bfs(root);
		// return bottomUp(root);
	}

	private int bfs(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> xplr = new LinkedList<>();
		xplr.add(root);
		int lev = 0;
		while (!xplr.isEmpty()) {
			lev++;
			int sz = xplr.size();
			for (int i = 0; i < sz; i++) {
				TreeNode tnd = xplr.remove();
				if (tnd == null) {
					continue;
				}
				if (tnd.left == null && tnd.right == null) {
					return lev;
				}
				xplr.add(tnd.left);
				xplr.add(tnd.right);
			}
		}
		return lev;
	}

	private int bottomUp(TreeNode cnd) {
		Integer ival = bottomUpRecur(cnd);
		return ival == null ? 0 : ival;
	}

	private Integer bottomUpRecur(TreeNode cnd) {
		if (cnd == null) { return null; }
		Integer lval = bottomUpRecur(cnd.left);
		Integer rval = bottomUpRecur(cnd.right);
		if (lval != null && rval != null) {
			return Math.min(lval, rval) + 1;
		} else if (lval != null || rval != null) {
			return (lval != null ? lval : rval) + 1; }
		return 1;
	}

	private int bottomUpX(TreeNode cnd) {
		if (cnd == null) {
			return 0;
		}
		return Math.min(bottomUp(cnd.left), bottomUp(cnd.right)) + 1;
	}
}