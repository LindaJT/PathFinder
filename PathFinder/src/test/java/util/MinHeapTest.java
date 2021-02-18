
package util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pathFinder.util.Node;
import pathFinder.util.MinHeap;

/**
 *
 * @author linjokin
 */
public class MinHeapTest {
    
    private MinHeap heap;
    private Node startNode;
    
    @Before
    public void setUp() {
        this.startNode = new Node(null, 0, 0, 0, 0);
        this.heap = new MinHeap(100, this.startNode);
    }
    
    @Test
    public void insertTwoNodesOfDifferentFValue() {
        Node fnode = new Node(null, 1, 1, 1, 4);
        Node snode = new Node(null, 0, 1, 1, 3);
        this.heap.insert(fnode);
        this.heap.insert(snode);
        int size = this.heap.getSize();
        assertEquals(size, 2);
        Node firstNode = this.heap.remove();
        int firstNodesX = firstNode.getX();
        int firstNodesY = firstNode.getY();
        assertEquals(firstNodesX, 0);
        assertEquals(firstNodesY, 1);
    }
}
 