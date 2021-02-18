

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
        Path path = astar.findPathTo(2, 3);
        assertFalse(path.getSize()== 0);
    }
    
    @Test
    public void pathIsCorrectLength() {
        Path path = astar.findPathTo(2, 3);
        assertEquals(3, path.getSize());
    }
    
    public void sameStartAndEndReturnsEmptyList() {
        Path path = astar.findPathTo(1, 1);
        assertEquals(path.getSize(), 0);
    }
    

}
