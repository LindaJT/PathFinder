
package util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pathFinder.util.Node;
import pathFinder.util.NeighborsList;

/**
 *
 * @author linjokin
 */
public class NeighborsListTest {
    
    private NeighborsList neighbors;
    private Node startNode;
    
    @Before
    public void setUp() {
        this.neighbors = new NeighborsList();
        this.startNode = new Node(null, 0, 0, 0, 0);
    }
    @Test
    public void insertOneNode() {
        Node node = new Node(startNode, 0, 1, 0, 0);
        this.neighbors.insert(node);
        assertEquals(1, this.neighbors.getSize());
        Node first = this.neighbors.getNode(0);
        assertEquals(first.getY(), 1);
    }
    
    @Test 
    public void insertThreeNodes(){
        Node first = new Node(startNode, 0, 1, 1, 5);
        this.neighbors.insert(first);
        Node second = new Node(startNode, 1, 1, 1.4 , 6);
        this.neighbors.insert(second);
        Node third = new Node(startNode, 1, 0, 1, 5);
        this.neighbors.insert(third);
        assertEquals(3, this.neighbors.getSize());
        Node taken = this.neighbors.getNode(0);
        assertEquals(taken.getY(), 1);
        assertEquals(taken.getX(), 0);
        Node takenThird = this.neighbors.getNode(2);
        assertEquals(takenThird.getY(), 0);
        assertEquals(takenThird.getX(), 1);
    }
    
    
}
