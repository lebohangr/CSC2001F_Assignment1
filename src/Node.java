public class Node {

    Node leftchild;
    Node rightchid;
    int height;
    LSData key;

    public Node(LSData key){
        this.key = key;
        leftchild = rightchid = null;
        height = 1;
        }

    public String toString(){
        return "LSData{" +
                "StageDayTime='" + key.getStageDayTime() + '\'' +
                ", listOfAreas='" + key.getListOfAreas() + '\'' +
                '}';
    }
}
