/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Step 1: Initialize the result list to store final zigzag level order traversal
        List<List<Integer>> result = new ArrayList<>();

        // If the tree is empty, return the empty result
        if (root == null) {
            return result;
        }

        // Step 2: Initialize the queue for level order traversal
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root); // Step 3: Enqueue the root node

        // Initialize flag to control the traversal direction
        boolean leftToRight = true;

        // Step 4: Loop until the queue is empty
        while (!nodesQueue.isEmpty()) {
            // Get the number of nodes at the current level
            int size = nodesQueue.size();

            // Step 4: Create a list to store the current level nodes
            List<Integer> row = new ArrayList<>(Collections.nCopies(size, 0));

            // Step 5: Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                // Pop the front node from the queue
                TreeNode node = nodesQueue.poll();

                // Determine index based on direction of traversal
                int index = leftToRight ? i : (size - 1 - i);

                // Insert the node's value at the determined index
                row.set(index, node.val);

                // Step 6: Enqueue left and right children if they exist
                if (node.left != null) {
                    nodesQueue.add(node.left);
                }
                if (node.right != null) {
                    nodesQueue.add(node.right);
                }
            }

            // Step 7: Add the current level's result to the final answer
            result.add(row);

            // Reverse the traversal direction for the next level
            leftToRight = !leftToRight;
        }

        // Step 8: Return the complete zigzag level order traversal
        return result;
    }
}
