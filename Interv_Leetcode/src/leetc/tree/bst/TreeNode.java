package leetc.tree.bst;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
    TreeNode(int x) { val = x; }
    
    public String toString(){
    	return "V:"+this.val+" "+val+"L:"+this.left+" "+val+"R:"+this.right;
    }
}