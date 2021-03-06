package class5HeapAndGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * 
 * @author guoyifeng
 * Check if a given binary tree is completed. A complete binary tree is one in which every 
 * level of the binary tree is completely filled except possibly the last level. 
 * Furthermore, all nodes are as far left as possible.

	Examples
	
	        5
	
	      /    \
	
	    3        8
	
	  /   \
	
	1      4
	
	is completed.
	
	        5
	
	      /    \
	
	    3        8
	
	  /   \        \
	
	1      4        11
	
	is not completed.
	
	Corner Cases
	
	What if the binary tree is null? Return true in this case.
	How is the binary tree represented?
	
	We use the level order traversal sequence with a special symbol "#" denoting the null node.
	
	For Example:
	
	The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
	
	    1
	
	  /   \
	
	 2     3
	
	      /
	
	    4


 */
class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.key = key;
	}
}
public class CheckIfBinaryTreeIsCompleted {
	public boolean isCompleted(TreeNode root) {
		if(root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean flag = false;//if flag is set to true, it means there should not be any non-null treeNode afterwards
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur.left == null) {
				flag = true;
			} else if(flag) {// else if current node's left is not null but flag is set to true, this cause bubble in tree
				return false;
			} else {
				queue.offer(cur.left);//if cur.left != null && flag == false, add it into the queue.
			}
			
			//same logic on right child
			if(cur.right == null) {
				flag = true;
			} else if(flag) {
				return false;
			} else {
				queue.offer(cur.right);
			}
		}
		return true;
	}
}
