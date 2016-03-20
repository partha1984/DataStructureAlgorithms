package pkgJava;

import pkgTree.*;

public class classJava
{
    public static void main(String[] args)
    {
        IBinaryTree<Integer> integerTree = null;
        try
        {
            integerTree = new CBinaryTree<Integer>(10);
            integerTree.add(5);
            integerTree.add(2);
            integerTree.add(15);

            IBinaryTree<Integer> mirrorTree = CTreesUtility.getMirrorTree(integerTree);
            System.out.println("\n Printing mirror tree in InOrder ");
            mirrorTree.printTree(0);

            System.out.println("\n Printing original tree in InOrder ");
            integerTree.printTree(0);

            System.out.println("\n Root =  "+integerTree.getRoot());
        }
        catch(IllegalArgumentException error)
        {
            System.out.println("The message is "+error.getMessage());
        }
    }
}
