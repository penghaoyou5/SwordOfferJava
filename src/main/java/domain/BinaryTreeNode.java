package domain;

public class BinaryTreeNode<T> {

    public T value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;

    public  BinaryTreeNode(T value) {
        this.value = value;
    }


    public BinaryTreeNode<T> addLeft(T value){
        BinaryTreeNode leftNode = new BinaryTreeNode(value);
        left = leftNode;
        leftNode.parent = this;
        return leftNode;
    }

    public BinaryTreeNode<T> addRight(T value){
        BinaryTreeNode rightNode = new BinaryTreeNode(value);
        right = rightNode;
        rightNode.parent = this;
        return rightNode;
    }
}
