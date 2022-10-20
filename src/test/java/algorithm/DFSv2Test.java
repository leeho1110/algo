package algorithm;

import algorithm.DFSv2.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static algorithm.DFSv2.Node.LeafDirection.LEFT;
import static algorithm.DFSv2.Node.LeafDirection.RIGHT;
import static algorithm.DFSv2.Traverse.*;
import static org.assertj.core.api.Assertions.assertThat;

class DFSv2Test {

    private DFSv2 sut;

    /**
     *              1
     *          2       3
     *        4   5   6   7
     *
     *        위와 같은 트리 구조를 구성
     */
    @BeforeEach
    public void setUp(){
        // given
        Node rootNode = new Node(1);
        Node depth1Left = new Node(2);
        Node depth1Right = new Node(3);
        Node depth2LeftOnDepth1Left = new Node(4);
        Node depth2RightOnDepth1Left = new Node(5);
        Node depth2LeftOnDepth1Right = new Node(6);
        Node depth2RightOnDepth1Right = new Node(7);

        // Put nodes to depth1
        depth1Left.putLeafTo(depth2LeftOnDepth1Left, LEFT);
        depth1Left.putLeafTo(depth2RightOnDepth1Left, RIGHT);

        depth1Right.putLeafTo(depth2LeftOnDepth1Right,LEFT);
        depth1Right.putLeafTo(depth2RightOnDepth1Right,RIGHT);

        // Put nodes to root
        rootNode.putLeafTo(depth1Left, LEFT);
        rootNode.putLeafTo(depth1Right, RIGHT);

        this.sut = new DFSv2(rootNode);
    }

    @Test
    public void testDFSSearchByPreOrder(){
        // when
        List<Integer> result = sut.searchBy(PREORDER);

        // then
        assertThat(result).containsExactly(1,2,4,5,3,6,7);
    }

    @Test
    public void testDFSSearchByInOrder(){
        // when
        List<Integer> result = sut.searchBy(INORDER);

        // then
        assertThat(result).containsExactly(4,2,5,1,6,3,7);
    }

    @Test
    public void testDFSSearchByPostOrder(){
        // when
        List<Integer> result = sut.searchBy(POSTORDER);

        // then
        assertThat(result).containsExactly(4,5,2,6,7,3,1);
    }
}