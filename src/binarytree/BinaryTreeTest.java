package binarytree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        Integer[] a = {1, 5, 2, 7, 4, -5, -6, -3, 8, 10, 9};
        BinaryTree<Integer> bst = new BinaryTree<>();
        for (Integer n : a) {
            bst.insert(n);
        }
        System.out.println(bst);

        bst.delete(1);
        System.out.println("Delete 1:");
        System.out.println(bst);

        bst.delete(8);
        System.out.println("Delete 8:");
        System.out.println(bst);

        System.out.println("Search 2:");
        System.out.println(bst.search(2));

        bst.insert(3);
        System.out.println("Add 3:");
        System.out.println(bst);
    }
}
