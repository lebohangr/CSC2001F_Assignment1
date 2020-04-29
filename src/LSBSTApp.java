import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LSBSTApp {
    int opCount=0;
    private Node root;

    public void insert(LSData key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, LSData key)  {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
        opCount++;
        /* Otherwise, recur down the tree */
        if  (key.getStageDayTime().compareTo(root.key.getStageDayTime())<0)
            root.leftchild = insertRec(root.leftchild, key);
        else if (key.getStageDayTime().compareTo(root.key.getStageDayTime())>0)
            root.rightchid = insertRec(root.rightchid, key);

        /* return the (unchanged) node pointer */
        return root;
    }


    public void inOrderTraversal(Node focusNode) {
        if (focusNode == null) {
            return;
        }
        inOrderTraversal(focusNode.leftchild);
        System.out.println(focusNode.toString());
        inOrderTraversal(focusNode.rightchid);
    }

    public static void main(String[] args) throws FileNotFoundException {
        LSBSTApp dataTree = new LSBSTApp();
        dataTree.execute();
       // dataTree.inOrderTraversal(dataTree.root);
        //System.out.println(dataTree.root.rightchid.toString());
    }

    public void execute() throws FileNotFoundException {
        File lsSchedule = new File("src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner s1 = new Scanner(lsSchedule);
        while (s1.hasNextLine()) {
            String line = s1.nextLine();
            String[] parts = line.split(" ",2);
            LSData temp = new LSData(parts[0],parts[1]);
            System.out.println(temp.toString());
            insert(temp);
        }
        System.out.println(opCount);
        //inOrderTraversal(root);
        //System.out.printf("%s\n%s\n%s",array[0].toString(), array[1500].toString(),array[2975].toString());
    }
}

