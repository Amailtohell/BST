package BST;

public interface Tree {
    void insert(int i);
    void delete(Binary_Tree.Node root, int key);
    void searchRecursive(Binary_Tree.Node temp, int value);
    void inorder();
    void preOrder();
    void postOrder();

}
