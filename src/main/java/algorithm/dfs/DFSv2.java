package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DFSv2 {

    private final Node node;
    private final List<Integer> searchedOrders = new ArrayList<>();
    public DFSv2(Node node) {
        this.node = node;
    }

    enum Traverse { PREORDER, INORDER, POSTORDER }

    public List<Integer> searchBy(Traverse traverse) {
        // TODO: Order마다 내부 구현(알고리즘)이 변경된다. 이를 전략 패턴으로 수정할 수 있을까?
        if(traverse.equals(Traverse.PREORDER)){
            DFSForPreOrder(node);
        }
        if(traverse.equals(Traverse.INORDER)){
            DFSForInOrder(node);
        }
        if(traverse.equals(Traverse.POSTORDER)){
            DFSForPostOrder(node);
        }

        return searchedOrders;
    }

    private void DFSForPreOrder(Node node){
        if(Objects.isNull(node)){
            return;
        }
        searchedOrders.add(node.value);
        DFSForPreOrder(node.getLeftLeaf());
        DFSForPreOrder(node.getRightLeaf());
    }

    private void DFSForInOrder(Node node){
        if(Objects.isNull(node)){
            return;
        }
        DFSForInOrder(node.getLeftLeaf());
        searchedOrders.add(node.value);
        DFSForInOrder(node.getRightLeaf());
    }

    private void DFSForPostOrder(Node node){
        if(Objects.isNull(node)){
            return;
        }
        DFSForPostOrder(node.getLeftLeaf());
        DFSForPostOrder(node.getRightLeaf());
        searchedOrders.add(node.value);
    }

    static class Node {

        private final int value;
        private Node rightLeaf;
        private Node leftLeaf;

        enum LeafDirection { RIGHT, LEFT }

        public Node(int value) {
            this.value = value;
        }

        public void putLeafTo(Node node, LeafDirection direction) {
            if(direction.equals(LeafDirection.LEFT)){
                this.leftLeaf = node;
            }
            if(direction.equals(LeafDirection.RIGHT)){
                this.rightLeaf = node;
            }
        }

        public Node getRightLeaf() {
            return rightLeaf;
        }

        public Node getLeftLeaf() {
            return leftLeaf;
        }
    }
}
