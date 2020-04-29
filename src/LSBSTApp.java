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
    public Node search(Node root, LSData key)
    {
        // Base Cases: when root is null or key is present at root
        if (root==null || root.key==key)
            return root;

        // val is greater than root's key
        if (root.key.getStageDayTime().compareTo(key.getStageDayTime()) > 0)
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
    public void printAreas (String args){


    }
    public static Boolean valid(String arguments){
        String[] parts = arguments.split("_");
        if (!parts[0].contains("1-8")){
            return false;
        }
            else if (!parts[1].contains("1-31")){
                return false;
            }else if (!parts[2].contains("00-22") || (Integer.parseInt(parts[2]) % 2 != 0)){
                return false;
        }
            return true;
    }
    public static void main(String[] args) throws FileNotFoundException {
        LSBSTApp dataTree = new LSBSTApp();
        dataTree.execute();
        if (args == null){
            dataTree.inOrderTraversal(dataTree.root);
        }else if (args.length==3){
            String arguments = args[0] +"_"+ args[1] +"_"+ args[2];
            if (valid(arguments)){
                dataTree.printAreas(arguments);}
        }else System.out.println("Areas not found");
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
            //System.out.println(temp.toString());
            insert(temp);
        }
        System.out.println("Binary Search Tree Operation Count: "+ opCount);
        //inOrderTraversal(root);
        //System.out.printf("%s\n%s\n%s",array[0].toString(), array[1500].toString(),array[2975].toString());
    }
}

