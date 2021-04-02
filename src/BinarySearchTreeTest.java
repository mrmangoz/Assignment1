// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class BinarySearchTreeTest
{
   public static void main ( String [] args )
   {
      BinarySearchTree<Integer> bt = new BinarySearchTree<Integer> ();
   
/*
      // test for single node
      bt.root = new BinaryTreeNode<Integer> (10, null, null);
*/      
   
/*
      // test for 2-level tree
      bt.root = new BinaryTreeNode<Integer> (
          1, 
          new BinaryTreeNode<Integer> (2, null, null),
          new BinaryTreeNode<Integer> (3, null, null)
      );
*/      


      // test for 3-level tree
      bt.insert (5); 
      bt.insert (1); 
      bt.insert (2); 
      bt.insert (4); 
      bt.insert (7); 
      bt.insert (9); 
      bt.insert (8); 
      bt.insert (3); 
      bt.insert (6); 
      
/*
                   5
            1             7
                2      6     9
                  4        8
                 3
*/                 
      System.out.println ("Inorder : ");
      bt.inOrder ();

      System.out.println ("Search 2 : ");
      System.out.println (bt.find (2));
      System.out.println ("Search 7 : ");
      System.out.println (bt.find (7));
      System.out.println ("Search 5 : ");
      System.out.println (bt.find (5));
      System.out.println ("Search 3 : ");
      System.out.println (bt.find (3));
      System.out.println ("Search 10 : ");
      System.out.println (bt.find (10));

      System.out.println ("Delete 2 : ");
      bt.delete (2);
      bt.inOrder ();
      System.out.println ("Delete 7 : ");
      bt.delete (7);
      bt.inOrder ();
      System.out.println ("Delete 5 : ");
      bt.delete (5);
      bt.inOrder ();
      System.out.println ("Delete 3 : ");
      bt.delete (3);
      bt.inOrder ();
      System.out.println ("Delete 10 : ");
      bt.delete (10);
      bt.inOrder ();
   }
}
