

import pathFinder.algorithms.AStar;
import pathFinder.util.Node;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pathFinder.util.Path;

/**
 *
 * @author linjokin
 */
public class AStarTest {
    
    public int[][] map = {
        {-1, -1, -1, -1, -1, -1, -1, -1},
        {-1, 0, 0, 0, 0, -1, -1,-1},
        {-1, 0, 0, -1, -1, 0, 0,-1},
        {-1,0, 0, 0, 0, 0, 0,-1},
        {-1,0, 0, 0, 0, 0, -1,-1},
        {-1,0, 0, 0, 0, -1, -1,-1},
        {-1,0, 0, 0, -1, -1, 0,-1},
    {-1, -1, -1, -1, -1, -1, -1, -1}};
    public AStar astar;
    
    @Before
    public void setUp() {
        this.astar = new AStar(this.map, 1, 1);

    }
    
    @Test
    public void findPathToReturnsAList() {
        Path path = astar.findPathTo(2, 3, "uniformCost");
        assertFalse(path.getSize()== 0);
    }
    
    @Test
    public void pathHasCorrectNumberOfNodes() {
        Path path = astar.findPathTo(2, 3, "uniformCost");
        assertEquals(3, path.getSize());
    }
    
    @Test
    public void pathIsCorrectLength() {
        Path path = astar.findPathTo(6, 3, "uniformCost");
        assertEquals(5, (int) path.getNode(0).getG());
    }
    
    @Test
    public void straightPathIsCorrectLength() {
        Path path = astar.findPathTo(1, 4, "uniformCost");
        assertEquals(3, (int) path.getNode(0).getG());
    }

}
