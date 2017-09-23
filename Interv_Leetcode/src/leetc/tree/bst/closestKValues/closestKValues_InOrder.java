package leetc.tree.bst.closestKValues;

import java.util.LinkedList;
import java.util.List;

import leetc.tree.bst.TreeNode;

public class closestKValues_InOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        closestKValuesHelper(list, root, target, k);
        return list;
    }
    
    /**
     * @return <code>true</code> if result is already found.
     */
    private boolean closestKValuesHelper(LinkedList<Integer> list, TreeNode root, double target, int k) {
        if (root == null) {
            return false;
        }
        
        if (closestKValuesHelper(list, root.left, target, k)) {
            return true;
        }
        
        if (list.size() == k) {
            if (Math.abs(list.getFirst() - target) < Math.abs(root.val - target)) {
                return true;
            } else {
                list.removeFirst();
            }
        }
        
        list.addLast(root.val);
        return closestKValuesHelper(list, root.right, target, k);
    }

}

