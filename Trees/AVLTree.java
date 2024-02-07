package Trees;

public class AVLTree {
    private int value;
    private AVLTree node;
    private int height;
    private int balanceFactor;
    private AVLTree leftChild;
    private AVLTree rightChild;

    public AVLTree() {
    }

    public AVLTree(int value) {
        this.value = value;
    }

    public void insert(int value) {
        node = insert(node, value);
    }

    public AVLTree insert(AVLTree node, int value) {

        if (node == null) {
            return new AVLTree(value);
        }

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value);
        } else {
            node.rightChild = insert(node.rightChild, value);
        }

        height = calculateHeight(node);

        return node;
    }

    public int calculateHeight() {
        return calculateHeight(node);
    }

    public int calculateHeight(AVLTree node) {

        if (node == null) {
            return -1;
        }
        return Math.max(calculateHeight(node.leftChild), calculateHeight(node.rightChild)) + 1;
    }

    public int balanceFactor() {
        return balanceFactor(node);
    }

    public int balanceFactor(AVLTree node) {
        return calculateHeight(node.leftChild) - calculateHeight(node.rightChild);

        // if (balanceFactor > 1) {
        // return "left skewed";
        // } else if (balanceFactor < -1) {
        // return "right skewed";
        // } else {
        // return "balanced";
        // }
    }

    public void autoBalance() {
        autoBalance(node);
    }

    public void autoBalance(AVLTree node) {
        balanceFactor = balanceFactor(node);

        if (balanceFactor > 1) {

        } else if (balanceFactor < -1) {
            int balanceRight = balanceFactor(node.rightChild);
            if (balanceRight > 0) {
                System.out.println("do rightrotate at: " + node.rightChild.value + "and leftrotate at:"
                        + node.value);
            }
        }
    }

    private AVLTree rotateLeft(AVLTree root) {
        AVLTree newRoot = root.rightChild;

    }
}
