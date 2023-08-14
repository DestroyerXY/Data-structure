public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        System.out.println(tree.find(8)); // true
        System.out.println(tree.find(10)); // false

        tree.inOrderTraversal(); // 2 3 4 5 6 7 8
    }
}
