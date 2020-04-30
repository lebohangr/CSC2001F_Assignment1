import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part5AVLBST {
    int opCount=0;
    int searchCount=0;
    String keyValue="";
    int subset = 297;
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
    {   searchCount++;
        // Base Cases: when root is null or key is present at root
        if (root==null || root.key.getStageDayTime().equals(key)){
            return root;}

        // val is greater than root's key
        if (root.key.getStageDayTime().compareTo(key) > 0)
            return search(root.leftchild, key);

        // val is less than root's key
        return search(root.rightchid, key);
    }
    int findHeight(Node aNode) {
        if (aNode == null) {
            return -1;
        }
        int lefth = findHeight(aNode.leftchild);
        int righth = findHeight(aNode.rightchid);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        for (int i=0;i<10;i++){
        Part5AVLBST dataTree = new Part5AVLBST();
        int size = dataTree.subset;
        String[] data = new String[size];
        int arraySize = 0;
        File lsSchedule = new File(dataTree.subset +".txt");
        Scanner s2 = new Scanner(lsSchedule);
        while (s2.hasNextLine()){
            String line = s2.nextLine();
            String[] parts = line.split(" ",1);
            dataTree.keyValue = parts[0];
            data[arraySize] = dataTree.keyValue;
            arraySize++;}
            int totalSearchCount = 0;
            dataTree.execute();
            System.out.println("Height of Tree: " + dataTree.findHeight(dataTree.root));

            for (int k=0;k<size-1;k++){
                 dataTree.search(dataTree.root,data[k]);
                 //System.out.println(dataTree.searchCount);
            }
            totalSearchCount = totalSearchCount + dataTree.searchCount;
            int average = totalSearchCount/size;
            System.out.println("Average Case for Subset of size " + size + ": " + average);
            size = size + 297;
        }

    }

    public void execute() throws FileNotFoundException {
        File lsSchedule = new File(subset + ".txt");
        Scanner s1 = new Scanner(lsSchedule);
        while (s1.hasNextLine()) {
            String line = s1.nextLine();
            String[] parts = line.split(" ",2);
            LSData temp = new LSData(parts[0],parts[1]);
            insert(temp);
        }
        System.out.println("Binary Search Tree Insertion Operation Count: "+ opCount);
    }
}

