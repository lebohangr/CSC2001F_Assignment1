public class TreeTraversals {

        public void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.leftchild);
            System.out.print(root + " ");
            inOrder(root.rightchid);
        }

        public void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root + " ");
            preOrder(root.leftchild);
            preOrder(root.rightchid);
        }

        public void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.leftchild);
            postOrder(root.rightchid);
            System.out.print(root + " ");
        }
}
