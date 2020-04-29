public class AVLApp {
    Node root;
/***
    public Node search(Node root, int key)
    {
        // Base Cases: when root is null or key is present at root
        if (root==null || root.key==key)
            return root;

        // val is greater than root's key
        if (root.key > key)
            return search(root.leftchild, key);

        // val is less than root's key
        return search(root.rightchid, key);
    }



    public void start(){

        root = insert(root, -10);
        root = insert(root, 2);
        root = insert(root, 13);
        root = insert(root, -13);
        root = insert(root, -15);
        root = insert(root, 15);
        root = insert(root, 17);
        root = insert(root, 20);

             TreeTraversals tt = new TreeTraversals();
             tt.inOrder(root);
            // System.out.println();
            // tt.postOrder(root);
            //System.out.print(search(root,15));
        }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree( );
        avlTree.start();
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

    Node insert(Node node, int key) {

        // * 1.  Perform the normal BST insertion
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.leftchild = insert(node.leftchild, key);
        else if (key > node.key)
            node.rightchid = insert(node.rightchid, key);
        else // Duplicate keys not allowed
            return node;

        // * 2. Update height of this ancestor node *
        node.height = 1 + max(height(node.leftchild),
                height(node.rightchid));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced *
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.leftchild.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.rightchid.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.leftchild.key) {
            node.leftchild = leftRotate(node.leftchild);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.rightchid.key) {
            node.rightchid = rightRotate(node.rightchid);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer *
        return node;
    }
***/
}
