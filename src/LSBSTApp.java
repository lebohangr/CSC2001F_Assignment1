import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LSBSTApp {
    int opCount=0;
    private Node root;

    public void insert(LSData key) throws FileNotFoundException {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, LSData key) throws FileNotFoundException {
        opCount++;


        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key,root.listOfAreas);
            return root;
        }

        /* Otherwise, recur down the tree */
        if  (key.getStageDayTime().compareTo(root.key)<0)
            root.leftchild = insertRec(root.leftchild, key);
        else if (key.getStageDayTime().compareTo(root.key)>0)
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
        LSBSTApp dataTree = new LSBSTApp();
        dataTree.execute();
        dataTree.inOrderTraversal(dataTree.root);
    }

    public void execute() throws FileNotFoundException {
        File lsSchedule = new File("src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner s1 = new Scanner(lsSchedule);
        int counter = 0;
        while (s1.hasNextLine() ||(counter <= 2796)) {
            String line = s1.nextLine();
            String[] parts = line.split(" ",2);
            LSData temp = new LSData(parts[0],parts[1]);
            root.listOfAreas = temp.getListOfAreas();
            insertRec(root,temp.getStageDayTime());
            counter++;
        }
        //System.out.printf("%s\n%s\n%s",array[0].toString(), array[1500].toString(),array[2975].toString());


    }
}

