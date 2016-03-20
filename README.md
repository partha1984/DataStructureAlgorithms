package pkgTree;

public interface IBinaryTree<T>
{
    void add(T data);
    boolean exists(T data);
    T getRoot();
    IBinaryTreeNode<T> getBinaryTreeRoot();
    void printTree(int order); //  0 --> InOrder , 1 --> PreOrder , 2 -->PostOrder
}
