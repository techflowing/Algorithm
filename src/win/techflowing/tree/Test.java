package win.techflowing.tree;

/**
 * 相关测试
 */
public class Test {

    public static void main(String[] args) {
        TreeTraversalTest();
    }

    private static void TreeTraversalTest() {
        TreeTraversal traversal = new TreeTraversal();
        TreeNode tree = getTree();
        System.out.println("\n层序");
        traversal.levelOrder(tree);
        System.out.println("\n前序");
        traversal.preOrderTraversal(tree);
        System.out.println("\n中序");
        traversal.inOrderTraversal(tree);
        System.out.println("\n后序");
        traversal.postOrderTraversal(tree);
        System.out.println("\n前序-非递归");
        traversal.preOrderTraversalNonRecursion(tree);
        System.out.println("\n中序-非递归");
        traversal.inOrderTraversalNonRecursion(tree);
        System.out.println("\n后序-非递归");
        traversal.postOrderTraversalNonRecursion(tree);
    }

    private static TreeNode getTree() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        return root;
    }
}
