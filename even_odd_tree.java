class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        
        Queue<TreeNode> q1 = new LinkedList<>();
    
    q1.add(root);
    int level = 0;
    
    while (!q1.isEmpty()) {
        int size = q1.size();
        
        int prev = -1;
        for (int i=0; i<size; i++) {
            TreeNode current = q1.remove();
            if (prev == -1) {
                if (level % 2 == 0 && current.val % 2 == 0) {
                    return false;
                }
                if (level % 2 != 0 && current.val % 2 != 0) {
                    return false;
                }
            }
            else {
                if (level % 2 == 0 && (current.val <= prev || current.val % 2 == 0))                 {
                    return false;
                }
                if (level % 2 != 0 && (current.val >= prev || current.val % 2 != 0))                 {
                    return false;
                }
            }
            prev = current.val;
            if (current.left != null) {
                q1.add(current.left);
            }
            if (current.right != null) {
                q1.add(current.right);
            }
        }
        level++;
    }
    
    return true;
    }
}
