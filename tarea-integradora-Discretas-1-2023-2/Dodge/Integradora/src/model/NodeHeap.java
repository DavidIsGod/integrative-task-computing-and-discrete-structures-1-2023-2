package model;

public class NodeHeap {

    private int value;

    private NodeHeap left;

    private NodeHeap right;

    public NodeHeap(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public NodeHeap getLeft() {
        return left;
    }

    public NodeHeap getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(NodeHeap left) {
        this.left = left;
    }

    public void setRight(NodeHeap right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }


}
