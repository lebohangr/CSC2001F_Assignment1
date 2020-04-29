import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTree {

    private Node root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {
        int opCount=0;
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.leftchild = insertRec(root.leftchild, key);
        else if (key > root.key)
            root.rightchid = insertRec(root.rightchid, key);

        /* return the (unchanged) node pointer */
        return root;
    }


    public void inOrderTraversal(Node focusNode) {
        if (focusNode == null) {
            return;
        }
        inOrderTraversal(focusNode.leftchild);
        System.out.println(focusNode);
        inOrderTraversal(focusNode.rightchid);
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree dataTree = new BinarySearchTree();
        dataTree.execute();
    }

    public void execute() throws FileNotFoundException {
        File lsSchedule = new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner s1 = new Scanner(lsSchedule);

        while (s1.hasNextLine()) {
            String line = s1.nextLine();
            insert(22);
            s1.useDelimiter("\\s*:\\s*");
            inOrderTraversal(root);
        }


    }
}

