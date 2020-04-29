public class Node {
    int key;
    Node leftchild;
    Node rightchid;
    int height;
    int size;
    String listOfAreas;

    public Node(int key){
        this.key = key;
        leftchild = rightchid = null;
        height = 1;
        size = 1;
        }

    public String toString(){
        return "LSData{" +
                "StageDayTime='" + key + '\'' +
                ", listOfAreas='" + listOfAreas + '\'' +
                '}';
    }
}
