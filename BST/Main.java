package BST;

import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        int ch,val,init;
        boolean I_want_to_continue=true;
        Scanner sc=new Scanner(System.in);
        Binary_Search_Tree b = new Binary_Search_Tree();
        try {
            while (I_want_to_continue) {
                System.out.println("Enter 1 to insert element in the BST");
                System.out.println("Enter 2 to delete the key element from the BST");
                System.out.println("Enter 3 to search the key element in the BST");
                System.out.println("Enter 4 to see the Inorder Traversal");
                System.out.println("Enter 5 to see the Postorder Traversal");
                System.out.println("Enter 6 to see the Preorder Traversal");

                ch = sc.nextInt();

                switch (ch) {
                    case 1 -> {
                        System.out.println("Enter the element to insert in the BST");
                        val = sc.nextInt();
                        b.insert(val);
                        System.out.println("Element Inserted");
                         }
                    case 2 -> {
                        System.out.println("Enter the element to from the BST");
                        val = sc.nextInt();
                        b.delete(val);
                        System.out.println("Element deleted");

                    }
                    case 3 -> {
                        System.out.println("Enter the element to search in the BST");
                        val = sc.nextInt();
                        if (b.search(val)) {
                            System.out.println("found");
                        } else {
                            System.out.println("not found");
                        }


                    }
                    case 4 -> b.inorder();
                    case 5 -> b.postOrder();
                    case 6 -> b.preOrder();
                    default -> System.out.println("Enter valid choice");
                }
                System.out.println("Enter 1 to continue with the operations else 0");
                init = sc.nextInt();
                I_want_to_continue = init == 1;
            }
        }
        catch (Exception e)
        {
            if(e instanceof NumberFormatException)
                System.out.println("Invalid input format");
            if(e instanceof NullPointerException)
                System.out.println("NUll Pointer");
        }
    }
}