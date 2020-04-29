import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AVLApp {
    Node root;
    int opCount = 0;
    int searchCount = 0;

    public Node search(Node root, String key) {
        searchCount++;
        // Base Cases: when root is null or key is present at root
        if (root == null || root.key.getStageDayTime().equals(key)) {
            return root;
        }


        // val is greater than root's key
        if (root.key.getStageDayTime().compareTo(key) > 0)
            return search(root.leftchild, key);

        // val is less than root's key
        return search(root.rightchid, key);
    }


    public void inOrderTraversal(Node focusNode) {
        if (focusNode == null) {
            return;
        }
        inOrderTraversal(focusNode.leftchild);
        System.out.println(focusNode.toString());
        inOrderTraversal(focusNode.rightchid);
    }

    public void printAreas(String args) {
        if (search(root, args) == null) {
            System.out.println("Areas not found");
        } else {
            System.out.println(search(root, args));
            System.out.println("AVL Tree Search Operation Count: " + searchCount);
        }

    }

    public static Boolean valid(String arguments) {

        String[] parts = arguments.split("_");
        if (!parts[0].contains("1-8")) {
            return false;
        } else if (!parts[1].contains("1-31")) {
            return false;
        } else if (!parts[2].contains("00-22") || (Integer.parseInt(parts[2]) % 2 != 0)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        AVLApp dataTree = new AVLApp();
        dataTree.execute();
        if (args.length != 0) {
            if (args.length == 3) {
                String arguments = args[0] + "_" + args[1] + "_" + args[2];
                if (!valid(arguments)) {
                    dataTree.printAreas(arguments);
                } else System.out.println("Areas not found");
            } //else System.out.println("Enter 3 valid inputs!");
        } else dataTree.printAllAreas();
    }

    private void printAllAreas() {
        inOrderTraversal(root);
    }

    public void execute() throws FileNotFoundException {
        File lsSchedule = new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner s1 = new Scanner(lsSchedule);
        while (s1.hasNextLine()) {
            String line = s1.nextLine();
            String[] parts = line.split(" ", 2);
            LSData temp = new LSData(parts[0], parts[1]);
            insert(temp);
        }
        System.out.println("AVL Tree Insertion Operation Count: " + opCount);
    }

    // A utility function to get the height of the tree
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y) {
        Node x = y.leftchild;
        Node T2 = x.rightchid;

        // Perform rotation
        x.rightchid = y;
        y.leftchild = T2;

        // Update heights
        y.height = max(height(y.leftchild), height(y.rightchid)) + 1;
        x.height = max(height(x.leftchild), height(x.rightchid)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.rightchid;
        Node T2 = y.leftchild;

        // Perform rotation
        y.leftchild = x;
        x.rightchid = T2;

        //  Update heights
        x.height = max(height(x.leftchild), height(x.rightchid)) + 1;
        y.height = max(height(y.leftchild), height(y.rightchid)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.leftchild) - height(N.rightchid);
    }

    public void insert(LSData key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node node, LSData key) {

        // * 1.  Perform the normal BST insertion
        if (node == null)
            return (new Node(key));
        opCount++;
        if (key.getStageDayTime().compareTo(node.key.getStageDayTime()) < 0)
            node.leftchild = insertRec(node.leftchild, key);
        else if (key.getStageDayTime().compareTo(node.key.getStageDayTime()) > 0)
            node.rightchid = insertRec(node.rightchid, key);
        else // Duplicate keys not allowed
            return node;

        // * 2. Update height of this ancestor node *
        node.height = 1 + max(height(node.leftchild),
                height(node.rightchid));

        /*3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case*/
        if (balance > 1 && key.getStageDayTime().compareTo(node.leftchild.key.getStageDayTime()) < 0)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key.getStageDayTime().compareTo(node.rightchid.key.getStageDayTime()) > 0)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key.getStageDayTime().compareTo(node.leftchild.key.getStageDayTime()) > 0) {
            node.leftchild = leftRotate(node.leftchild);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key.getStageDayTime().compareTo(node.rightchid.key.getStageDayTime()) < 0) {
            node.rightchid = rightRotate(node.rightchid);
            return leftRotate(node);
        }

        // return the (unchanged) node pointer *
        return node;
    }

}
