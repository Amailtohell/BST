package BST;

import java.util.LinkedList;
import java.util.Queue;
public abstract class Binary_Tree implements Tree {
    //Represent a node of binary tree
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            //Assign data to the new node, set left and right children to null
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;

    public abstract int minValue(Node root);

    public abstract Node insert_Recursive(Node root, int key);

    public abstract Node delete_Recursive(Node root, int key);

    public abstract boolean search(int key);
    //unchecked Exception
    public void RootNotFoundException() {
        try {
            throw new RootNotFound();
        }
        catch (RootNotFound e)
        {
            String s= e.getMessage();
            System.out.println(s);
        }
    }

    public void insert(int i)
    {

        root = insert(root, i);
    }
    //Inserting node - recursive method
    public Node insert(Node node, int value)
    {
        if(node == null){
            RootNotFoundException();
            return new Node(value);
        }
        // Move to the left if passed value is
        // less than the current node
        if(value < node.data)
        {
            node.left = insert(node.left, value);
        }
        // Move to the right if passed value is
        // greater than the current node
        else if(value > node.data)
        {
            node.right = insert(node.right, value);
        }
        return node;
    }


    // Inorder traversal of a binary tree
    public void inorder() {
        inorder_Recursive(root);
    }
    public void inorder_Recursive(Node temp)
    {
        if (temp == null)
            return;
        inorder_Recursive(temp.left);
        System.out.print(temp.data + " ");
        inorder_Recursive(temp.right);
    }
    public void preOrder() {
        preorder_Recursive(root);
    }
    public void preorder_Recursive(Node node)
    {
        if(node != null){
            System.out.print(node.data + " ");
            preorder_Recursive(node.left);
            preorder_Recursive(node.right);
        }
    }
    // Postorder traversal
    public void postOrder() {
        postorder_Recursive(root);
    }
    public void postorder_Recursive(Node node)
    {
        if(node != null)
        {
            postorder_Recursive(node.left);
            postorder_Recursive(node.right);
            System.out.print(node.data + " ");
        }
    }
    // Function to delete deepest
// element in binary tree
    public void deleteDeepest(Node root, Node delNode)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp;
        // Do level order traversal until last node
        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();

            if (temp == delNode)
            {
                return;
            }
            if (temp.right!=null)
            {
                if (temp.right == delNode)
                {
                    temp.right = null;
                    return;
                }
                else
                    q.add(temp.right);
            }
            if (temp.left != null)
            {
                if (temp.left == delNode)
                {
                    temp.left = null;
                    return;
                }
                else
                    q.add(temp.left);
            }
        }
    }
    // Function to delete given element
    // in binary tree
    public void delete(Node root, int key)
    {
        if (root == null)
            return;

        if (root.left == null &&
                root.right == null)
        {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null, keyNode = null;
        // Do level order traversal until
        // we find key and last node.
        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();
            if (temp.data == key)
                keyNode = temp;
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
        if (keyNode != null)
        {
            int x = temp.data;
            deleteDeepest(root, temp);
            keyNode.data = x;
        }
    }
    public static boolean flag = false;
    //searchNode() will search for the particular node in the binary tree
    public void searchRecursive(Node temp, int value)
    {
        //Check whether tree is empty
        if(root == null)
        {
            System.out.println("Tree is empty");
        }
        else
        {
            //If value is found in the given binary tree then, set the flag to true
            if(temp.data == value)
            {
                flag = true;
                return;
            }
            //Search in left subtree
            if(!flag && temp.left != null)
            {
                searchRecursive(temp.left, value);
            }
            //Search in right subtree
            if(!flag && temp.right != null)
            {
                searchRecursive(temp.right, value);
            }
        }
    }

}
