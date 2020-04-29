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
    public Node search(Node root, String key)
    {
        // Base Cases: when root is null or key is present at root
        if (root==null || root.key.getStageDayTime().equals(key))
            return root;

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
    public void printAreas (String args){
        if (search(root,args)== null){
            System.out.println("Areas not found");
        }else{ System.out.println(search(root,args));}

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
        if (args.length != 0) {
            if (args.length == 3) {
                String arguments = args[0] + "_" + args[1] + "_" + args[2];
                if (!valid(arguments)) {
                    dataTree.printAreas(arguments);
                }else System.out.println("Areas not found");
            } //else System.out.println("Enter 3 valid inputs!");
        }else dataTree.printAllAreas();
    }

    private void printAllAreas() {
        inOrderTraversal(root);
    }

    public void execute() throws FileNotFoundException {
        File lsSchedule = new File("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner s1 = new Scanner(lsSchedule);
        while (s1.hasNextLine()) {
            String line = s1.nextLine();
            String[] parts = line.split(" ",2);
            LSData temp = new LSData(parts[0],parts[1]);
            insert(temp);
        }
        System.out.println("Binary Search Tree Operation Count: "+ opCount);
    }
}

