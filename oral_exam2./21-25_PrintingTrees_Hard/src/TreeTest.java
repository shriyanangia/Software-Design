// Fig. 21.18: TreeTest.java
// Binary tree test program.

import com.deitel.datastructures.Tree;

import javax.swing.tree.TreeNode;
import java.security.SecureRandom;

/**
 * Main driver class that tests Tree.java
 *
 * Code taken from textbook example in Chapter 21 and then edited to
 * answer the course question
 */

public class TreeTest {
    public static void main(String[] args) {

        /**
         * This method will automatically be called when TreeTest.java is run.
         *
         * @param args Command line arguments.
         */

        Tree<Integer> tree = new Tree<Integer>();
        SecureRandom randomNumber = new SecureRandom();

        System.out.println("Inserting the following values: ");

        // insert 10 random integers from 0-99 in tree
        for (int i = 1; i <= 10; i++) {
            int value = randomNumber.nextInt(100);
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();
        System.out.println();

        Tree<Integer> tree2 = new Tree<Integer>();
        tree2.insertNode(49);
        tree2.insertNode(28);
        tree2.insertNode(83);
        tree2.insertNode(18);
        tree2.insertNode(40);
        tree2.insertNode(71);
        tree2.insertNode(97);
        tree2.insertNode(11);
        tree2.insertNode(19);
        tree2.insertNode(32);
        tree2.insertNode(44);
        tree2.insertNode(69);
        tree2.insertNode(72);
        tree2.insertNode(92);
        tree2.insertNode(99);
        tree2.outputTreeTraversal();

    }
} // end class TreeTest


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
