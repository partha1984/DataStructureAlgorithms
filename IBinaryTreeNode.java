package pkgTree;
public interface IBinaryTreeNode<T>
{
    T getData();

    void setLeftTree(IBinaryTreeNode<T> leftTree);
    IBinaryTreeNode<T> getLeftTree();

    public void setRightTree(IBinaryTreeNode<T> rightTree);
    public IBinaryTreeNode<T> getRightTree();

    IBinaryTreeNode<T> getClonnedObjectNode();
}

