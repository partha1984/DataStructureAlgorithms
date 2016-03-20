package pkgTree;

public class CTreesUtility
{
    public static <T extends Comparable> IBinaryTree<T> getMirrorTree(IBinaryTree<T> node)
    {
        IBinaryTree<T> mirrorTree = null;
        if (node != null)
        {
            IBinaryTreeNode<T> treenode = node.getBinaryTreeRoot();
            MirrorTreeHelper(treenode);
            if (treenode != null)
            {
                mirrorTree = new CBinaryTree<T>(treenode);
            }
        }
        return mirrorTree;
    }

    public static <T extends Comparable> void MirrorTreeHelper(IBinaryTreeNode<T> node)
    {
        if (node != null)
        {
            IBinaryTreeNode<T> rightNode = node.getRightTree();
            IBinaryTreeNode<T> leftNode = node.getLeftTree();

            node.setRightTree(null);
            node.setLeftTree(null);

            if (leftNode != null)
            {
                node.setRightTree(leftNode);
            }

            if (rightNode != null)
            {
                node.setLeftTree(rightNode);
            }
            MirrorTreeHelper(node.getLeftTree());
            MirrorTreeHelper(node.getRightTree());
        }
    }
}
