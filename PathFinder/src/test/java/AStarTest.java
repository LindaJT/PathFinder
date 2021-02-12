

import pathFinder.AStar;
import pathFinder.Node;
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
        List<Node> path = astar.findPathTo(2, 3);
        assertFalse(path.isEmpty());
    }
    
    @Test
    public void pathIsCorrectLength() {
        List<Node> path = astar.findPathTo(2, 3);
        assertEquals(3, path.size());
    }
    
    public void sameStartAndEndReturnsEmptyList() {
        List<Node> path = astar.findPathTo(1, 1);
        assertTrue(path.isEmpty());
    }
    

}
