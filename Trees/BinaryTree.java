package Trees;

public class BinaryTree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

    }

    public Node root;

    public void insert(int value) {

        if (root == null) {
            root = new Node(value);
            return;
        }

        Node current = root;

        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = new Node(value);
                    break;
                }

                current = current.leftChild;

            } else {
                if (current.rightChild == null) {
                    current.rightChild = new Node(value);
                    break;
                }

                current = current.rightChild;

            }

        }

    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePreOrder(Node node) {

        if (node == null) {
            return;
        }
        System.out.println(node.value);

        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
    }

    public Boolean equals(BinaryTree tree) {
        return equals(root, tree.root);
    }

    // Uses Depth first search (Pre-order traversal)
    public Boolean equals(Node first, Node second) {
        return first.value == second.value && equals(first.leftChild, second.leftChild)
                && equals(first.rightChild, second.rightChild);
    }

    public Boolean isValid() {
        return isValid(root);
    }

    public Boolean isValid(Node node) {
        if (node == null) {
            return true; // or false depending on how you define validity for an empty tree
        }

        boolean leftValid = (node.leftChild == null || (node.leftChild.value < node.value && isValid(node.leftChild)));
        boolean rightValid = (node.rightChild == null
                || (node.value < node.rightChild.value && isValid(node.rightChild)));

        return leftValid && rightValid;
    }

    public Boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.value < min || root.value > max) {
            return false;
        }

        return isBST(root.leftChild, min, root.value - 1) && isBST(root.rightChild, root.value + 1, max);
    }

    // public Boolean isValid(Node node) {
    // if (node.leftChild == null) {
    // node.leftChild = new Node(0);

    // }

    // if (node.rightChild == null) {
    // node.rightChild = new Node(0);
    // }

    // if (node.value == 0) {
    // return true;
    // }

    // return (node.leftChild.value < node.value && node.value <
    // node.rightChild.value) && isValid(node.leftChild)
    // && isValid(node.rightChild);
    // }

}
