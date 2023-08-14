class Node {
    private static final boolean RED = false;
    int data; // значение узла
    Node left, right; // ссылки на левого и правого потомков
    boolean color; // цвет узла

    Node(int data) {
        this.data = data;
        this.color = RED;
        this.left = this.right = null;
    }
}