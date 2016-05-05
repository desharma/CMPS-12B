//Tree.java
//creates the binary tree
import static java.lang.System.*;
import java.util.Iterator;

class Tree {

    private class Node {
        String key; // key = value of the word
        Queue<Integer> value;
        Node left;
        Node right;

        Node(String newData) {
            left = null;
            right = null;
            key = newData;

        }
    }

    private Node root;
    //method prints out the depth of each element
    private void debugHelper(Node tree, int depth) {
        // Your code here might be recursive
       // System.out.print(tree.key + " " + depth);
        if (tree.left != null) {
            depth++;
            debugHelper(tree.left, depth);
            depth --;
        }

        for(int i = 0; i < depth+1; i++)
            System.out.print("  ");

        System.out.print(depth + " " + tree.key);


        System.out.println();
        if (tree.right != null) {
            depth++;
            debugHelper(tree.right, depth);
            depth --;

        }




        //throw new UnsupportedOperationException();*/
    }
    //method to print out the output of how many times each element occurs
    private void outputHelper(Node tree) {
        // Your code here might be recursive
       if (tree.left != null) {
           outputHelper(tree.left);
       }
           System.out.print(tree.key + " : ");
           Iterator<Integer> ValIterator = tree.value.iterator();
           while (ValIterator.hasNext()) {
               System.out.print(ValIterator.next() + " ");


       }
        System.out.println();
       if (tree.right != null) {
            outputHelper(tree.right);
       }

       // throw new UnsupportedOperationException();
    }
    //inserts the elements from the file
    public void insert(String key /* key = word*/, Integer linenum) {

        root = insert(root, key, linenum);

        //throw new UnsupportedOperationException();
    }

    //puts the elements into a binary tree
    private Node insert(Node node, String key, Integer linenum ) {

        if (node==null) {
            node = new Node(key);
            node.value = new Queue<Integer>();
            node.value.insert(linenum);

        }
        else {
            if (key.equals(node.key)){//key <= node.key) {

                node.value.insert(linenum);
                }
            else if (key.compareToIgnoreCase(node.key) < 0)
            {
                node.left = insert(node.left, key, linenum);
            }
            // need a method to check if key is smaller then node.key. if it is then insert right, if bigger then insert left
            else {
                node.right = insert(node.right, key, linenum);

            }
        }

        return(node); // in any case, return the new pointer to the caller
    }
    //calls debughelper
    public void debug() {
        // Show debug output of tree
        debugHelper(root, 0);
    }
    //calls outputhelper
    public void output() {
        // Show sorted words with lines where each word appears

        outputHelper(root);
    }

}
