
package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pathFinder.Node;
import pathFinder.util.Path;

/**
 *
 * @author linjokin
 */
public class PathTest {
    
    private Path path;
    private Node startNode;
    
    
    @Before
    public void setUp() {
        this.path = new Path(4);
        this.startNode = new Node(null, 0, 0, 0, 3);
    }
    
    @Test
    public void insertThreeNodes() {
        Node first = new Node(startNode, 0, 1, 1, 5);
        this.path.insert(first);
        Node second = new Node(startNode, 1, 1, 1.4 , 6);
        this.path.insert(second);
        Node third = new Node(startNode, 1, 0, 1, 5);
        this.path.insert(third);
        assertEquals(3, this.path.getSize());
        Node taken = this.path.getNode(0);
        assertEquals(taken.getY(), 1);
        assertEquals(taken.getX(), 0);
        Node takenThird = this.path.getNode(2);
        assertEquals(takenThird.getY(), 0);
        assertEquals(takenThird.getX(), 1);
    }
    
    @Test
    public void canReverseTheOrderofThePath() {
        this.path.insert(this.startNode);
        Node first = new Node(startNode, 0, 1, 1, 2);
        this.path.insert(first);
        Node second = new Node(first, 0, 2, 2 , 1);
        this.path.insert(second);
        Node third = new Node(second, 0, 3, 3, 0);
        this.path.insert(third);
        this.path.flip();
        Node taken = this.path.getNode(0);
        assertEquals(taken.getY(), 0);
        Node last = this.path.getNode(3);
        assertEquals(last.getY(), 3);
    }
     
    
}
