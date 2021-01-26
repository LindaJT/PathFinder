

import PathFinder.AStar;
import PathFinder.Node;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author linjokin
 */
public class AStarTest {
    
    public int[][] map = {
        {0, 0, 0, 0, -1, -1},
        {0, 0, -1, -1, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, -1},
        {0, 0, 0, 0, -1, -1},
        {0, 0, 0, -1, -1, 0}};
    public AStar astar;
    
    @Before
    public void setUp() {
        this.astar = new AStar(this.map, 0, 0);

    }
    
    @Test
    public void findPathToReturnsAList() {
        List<Node> path = astar.findPathTo(1, 2);
        assertFalse(path.isEmpty());
    }
    
    @Test
    public void pathIsCorrectLength() {
        List<Node> path = astar.findPathTo(1, 2);
        assertEquals(3, path.size());
    }
    
    public void sameStartAndEndReturnsEmptyList() {
        List<Node> path = astar.findPathTo(0, 0);
        assertTrue(path.isEmpty());
    }
    

}
