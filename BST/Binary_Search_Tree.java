package BST;

public class Binary_Search_Tree extends Binary_Tree {

    @Override
    public  int minValue(Node root)  {
        //initially minvalue = root
        int minval = root.data;
        //find minval
        while (root.left != null)  {
            minval = root.left.data;
            root = root.left;
        }
        return minval;
    }


    @Override
    public Node delete_Recursive(Node root, int key)  {
        //tree is empty
        if (root == null) {
            RootNotFoundException();
            return null;
        }

        //traverse the tree
        if (key < root.data)     //traverse left subtree
            root.left = delete_Recursive(root.left, key);
        else if (key > root.data)  //traverse right subtree
            root.right = delete_Recursive(root.right, key);
        else  {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = delete_Recursive(root.right, root.data);
        }
        return root;
    }

    @Override
    public boolean search(int key)  {
        root = search_Recursive(root, key);
        return root != null;
    }
    @Override
    public void insert(int key)  {

        root = insert_Recursive(root, key);
    }

    //recursive insert function
    @Override
    public Node insert_Recursive(Node root, int key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key < root.data)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (key > root.data)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }

    public void delete(int key) {

        root = delete_Recursive(root, key);
    }

    Node search_Recursive(Node root, int key)  {
        // Base Cases: root is null or key is present at root
        if (root==null || root.data==key)
            return root;
        // val is greater than root's key
        if (root.data > key)
            return search_Recursive(root.left, key);
        // val is less than root's key
        return search_Recursive(root.right, key);
    }
}


