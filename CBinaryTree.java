package pkgTree;

public class CBinaryTree<T extends Comparable> implements IBinaryTree<T>
{
    private static class CIBinaryTreeNode<T extends Comparable> implements IBinaryTreeNode<T>
    {
        private T data;
        private IBinaryTreeNode<T> leftTree;
        private IBinaryTreeNode<T> rightTree;

        public CIBinaryTreeNode(T data)
        {
            this.data      = data;
            this.leftTree  = null;
            this.rightTree = null;
        }

        public T getData()
        {
            return this.data;
        }

        public void setLeftTree(IBinaryTreeNode<T> leftTree)
        {
            this.leftTree = leftTree;
        }
        public IBinaryTreeNode<T> getLeftTree()
        {
            return this.leftTree;
        }

        public void setRightTree(IBinaryTreeNode<T> rightTree)
        {
            this.rightTree = rightTree;
        }
        public IBinaryTreeNode<T> getRightTree()
        {
            return this.rightTree;
        }

        public IBinaryTreeNode<T> getClonnedObjectNode()
        {
            IBinaryTreeNode<T> clonnedObjectNode = new CIBinaryTreeNode<T>(this.getData());
            clonnedObjectNode.setLeftTree(this.getLeftTree());
            clonnedObjectNode.setRightTree(this.getRightTree());
            return clonnedObjectNode;
        }

    }

    private IBinaryTreeNode<T> root;

    public CBinaryTree(T data) throws IllegalArgumentException
    {
        if (data == null)
        {
            throw new IllegalArgumentException("AL-TREE01-The data passed to construct the tree is NULL");
        }

        this.root = new CIBinaryTreeNode<T>(data);
    }

    public CBinaryTree(IBinaryTreeNode<T> treeStructure) throws IllegalArgumentException
    {
        if (treeStructure == null)
        {
            throw new IllegalArgumentException("AL-TREE02-The node passed to construct the tree is NULL");
        }

        this.root =  treeStructure;
    }

    public IBinaryTreeNode<T> getBinaryTreeRoot()
    {
        return this.root.getClonnedObjectNode();
    }

    public void add(T data) throws IllegalArgumentException
    {
        if (data == null)
        {
            throw new IllegalArgumentException("AL-TREE01-The data passed to add function of the tree is NULL");
        }

        IBinaryTreeNode<T> tempRoot = this.root;
        addHelper(tempRoot,data);
    }

    private void addHelper(IBinaryTreeNode<T> treeRoot,T data)
    {
        T treeData = treeRoot.getData();
        if (treeData.compareTo(data) < 0)
        {
            if (treeRoot.getRightTree() == null)
            {
                treeRoot.setRightTree(new CIBinaryTreeNode<T>(data));
            }
            else
            {
                addHelper(treeRoot.getRightTree(),data);
            }
        }
        else if ((treeData.compareTo(data) > 0))
        {
            if (treeRoot.getLeftTree() == null)
            {
                treeRoot.setLeftTree(new CIBinaryTreeNode<T>(data));
            }
            else
            {
                addHelper(treeRoot.getLeftTree(),data);
            }
        }
        else
        {
            System.out.println(" The data is same as current node data ");
            //Do nothing as the data already exists
        }
    }

    public boolean exists(T data)
    {
        IBinaryTreeNode<T> tempRoot = this.root;
        return existsHelper(tempRoot,data);
    }

    private boolean existsHelper(IBinaryTreeNode<T> tree,T data)
    {
        boolean found = false;
        if ((tree != null) & (data != null))
        {
            T treeData = tree.getData();
            int dataComparison  = treeData.compareTo(data);

            if (dataComparison == 0)
            {
                found = true;
            }
            else if (dataComparison > 0)
            {
                if (tree.getLeftTree() != null)
                {
                    found = this.existsHelper(tree.getLeftTree(),data);
                }
            }
            else
            {
                if (tree.getRightTree() != null)
                {
                    found = this.existsHelper(tree.getRightTree(),data);
                }
            }
        }
        return found;
    }

    public T getRoot()
    {
        T rootData = this.root.getData();
        return rootData;
    }

    public void printTree(int order) //  0 --> InOrder , 1 --> PreOrder , 2 -->PostOrder
    {
        IBinaryTreeNode<T> tempRoot = this.root;
        switch (order)
        {
            case 0 : System.out.println("About to do InOrder Traversal");
                     InOrderTraversal(tempRoot);
                     break;
            case 1 : System.out.println("About to do PreOrder Traversal");
                     PreOrderTraversal(tempRoot);
                     break;
            case 2 : System.out.println("About to do PostOrder Traversal");
                     PostOrderTrasersal(tempRoot);
                     break;
            default: System.out.println("The option is not a valid option : "+order);
                     break;
        }
    }

    private void InOrderTraversal(IBinaryTreeNode<T> treeNode)
    {
        if (treeNode == null)
        {
            return;
        }
        InOrderTraversal(treeNode.getLeftTree());
        System.out.println(treeNode.getData().toString());
        InOrderTraversal(treeNode.getRightTree());
    }

    private void PreOrderTraversal(IBinaryTreeNode<T> treeNode)
    {
        if (treeNode == null)
        {
            return;
        }
        System.out.println(treeNode.getData().toString());
        InOrderTraversal(treeNode.getLeftTree());
        InOrderTraversal(treeNode.getRightTree());
    }

    private void PostOrderTrasersal(IBinaryTreeNode<T> treeNode)
    {
        if (treeNode == null)
        {
            return;
        }
        InOrderTraversal(treeNode.getLeftTree());
        InOrderTraversal(treeNode.getRightTree());
        System.out.println(treeNode.getData().toString());
    }
}
