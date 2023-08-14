public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;


    private Node root; // корень дерева

    public RedBlackTree() {
        root = null;
    }

    // метод для проверки, является ли узел красным
    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    // метод для изменения цвета узла
    private void flipColors(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    // метод для выполнения левого поворота
    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    // метод для выполнения правого поворота
    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    // метод для вставки нового элемента в дерево
    public void insert(int data) {
        root = insertNode(root, data);
        root.color = BLACK;
    }

    // рекурсивный метод для вставки нового элемента в дерево
    private Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insertNode(node.left, data);
        } else if (data > node.data) {
            node.right = insertNode(node.right, data);
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    // метод для поиска элемента в дереве
    public boolean find(int data) {
        return findNode(root, data);
    }

    // рекурсивный метод для поиска элемента в дереве
    private boolean findNode(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (data < node.data) {
            return findNode(node.left, data);
        } else if (data > node.data) {
            return findNode(node.right, data);
        } else {
            return true;
        }
    }

    // метод для вывода элементов дерева в порядке возрастания
    public void inOrderTraversal() {
        inOrder(root);
    }

    // рекурсивный метод для вывода элементов дерева в порядке возрастания
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

}