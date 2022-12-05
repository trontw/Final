public class FunSki {

    private static int fun = 0;
    private static int Rw = 0;
    private static int Lw = 0;
    private static int size = 0;
    private static BinaryNode newRoot;
    private static BinaryNode Lchild;
    private static BinaryNode Rchild;

    public static int compareTo(int Lw, int Rw){
        int x = Lw - Rw;
        return x;
    }
    /*
    public static void print(BinaryNode root2){
        //print(root2);
        for (int i = 0; i < size; i++)
            System.out.println(root);
    }
    */
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        BinaryNode root = tree.getRoot();
        
        // Code Starts here...
        //System.out.println("Root is = "+root);
        //System.out.println("Root Label is = "+root.getLabel());
        //System.out.println("Left Child is = "+root.getLeftChild());
        //System.out.println("Right Child is = "+root.getRightChild());
        //System.out.println("Left Child weight is = "+root.getLeftWeight());
        //System.out.println("Right Child weight is = "+root.getRightWeight());

        int Lw = root.getLeftWeight();
        int Rw = root.getRightWeight();
        String[] arr = new String[100000000]; 
        BinaryNode old_root = root;
        while (root.getLeftWeight() > 0 || root.getRightWeight() > 0){
            if (compareTo(Lw, Rw) > 0){               
                //System.out.println("<--- Go Left Marty");
                //System.out.println("Lw is = "+Lw);
                fun += Lw;
                newRoot = root.getLeftChild();
                //System.out.println("New root is: "+newRoot.getLabel());
                root = newRoot;
                Lchild = root.getLeftChild();
                //System.out.println("Left child of newRoot is: "+Lchild);
                Rchild = root.getRightChild();
                //System.out.println("Right child of newRoot is: "+Rchild);
                Lw = root.getLeftWeight();
                Rw = root.getRightWeight();
                //Preparing print array
                arr[size] = "Node: "+root.getLabel();
                ++size;
            } else if (compareTo(Lw, Rw) < 0){
                //System.out.println("Go Right Marty -->");
                //System.out.println("Lw is = "+Rw);
                fun += Rw;
                newRoot = root.getRightChild();
                //System.out.println("New root is: "+newRoot.getLabel());
                root = newRoot;
                Lchild = root.getLeftChild();
                //System.out.println("Left child of newRoot is: "+Lchild);
                Rchild = root.getRightChild();
                //System.out.println("Right child of newRoot is: "+Rchild);
                Lw = root.getLeftWeight();
                Rw = root.getRightWeight();
                arr[size] = "Node: "+root.getLabel();
                ++size;
            } else if (compareTo(Lw, Rw) == 0){
                //System.out.println("Marty goes home because he can't decide which way to go.");
            }
        }
        System.out.println("Largest Funness: "+fun);
        System.out.println(old_root);
        for (int i = 0; i < size; ++i)
            System.out.println(arr[i]);
    }
}
