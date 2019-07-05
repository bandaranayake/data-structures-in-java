public class BST {
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(value, root);
        }
    }

    private void insert(int value, Node node) {
        if (node != null) {
            if (node.getValue() < value) {
                if (node.getRight() == null) {
                    node.setRight(new Node(value));
                } else {
                    insert(value, node.getRight());
                }
            } else {
                if (node.getLeft() == null) {
                    node.setLeft(new Node(value));
                } else {
                    insert(value, node.getLeft());
                }
            }
        }
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.println(node.getValue() + " ");
            printInOrder(node.getRight());
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.println(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.println(node.getValue() + " ");
        }
    }
}