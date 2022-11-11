package algorithm;

public class NodeBase {

    public NodeBase(long value) {
        this.value = value;
    }

    public static NodeBase createOneToSevenTree(){
        NodeBase root1 = new NodeBase(1);
        NodeBase root2 = new NodeBase(2);
        NodeBase root3 = new NodeBase(3);
        NodeBase root4 = new NodeBase(4);
        NodeBase root5 = new NodeBase(5);
        NodeBase root6 = new NodeBase(6);
        NodeBase root7 = new NodeBase(7);

        root2.setLeftNode(root4);
        root2.setRightNode(root5);

        root3.setLeftNode(root6);
        root3.setRightNode(root7);

        root1.setLeftNode(root2);
        root1.setRightNode(root3);

        return root1;
    }

    private long value;
    private NodeBase leftNode;
    private NodeBase rightNode;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public NodeBase getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(NodeBase leftNode) {
        this.leftNode = leftNode;
    }

    public NodeBase getRightNode() {
        return rightNode;
    }

    public void setRightNode(NodeBase rightNode) {
        this.rightNode = rightNode;
    }
}
