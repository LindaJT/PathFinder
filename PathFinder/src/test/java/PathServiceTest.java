

import pathFinder.PathService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PathServiceTest {
    
    public PathService service;
    public int[][] map = {
        {0, 0, 0, 0, -1, -1},
        {0, 0, -1, -1, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, -1},
        {0, 0, 0, 0, -1, -1},
        {0, 0, 0, -1, -1, 0}};
    
    @Before
    public void setUp() {
        this.service = new PathService();
    }
    
    @Test 
    public void readFileCanReadExcistingMap() {
        boolean value = this.service.readFile("test.txt");
        assertTrue(value);
    }
    
    @Test 
    public void readFileCanNotReadNonExcistingMap() {
        boolean value = this.service.readFile("tst.txt");
        assertFalse(value);
    }
    
    @Test
    public void readFileCanNotReadEmptyFile() {
        boolean value = this.service.readFile("empty.txt");
        assertFalse(value);
    }
    
    @Test
    public void aStarDistanceReturnsZeroIfStartAndEndAreSame() {
        int value = this.service.aStarDistance(1, 1, 1, 1);
        assertEquals(0, value);
    }
    
    @Test
    public void aStarDistanceReturnsCorrectPathLength() {
        this.service.setMap(this.map);
        int value = this.service.aStarDistance(0, 0, 1, 2);
        assertEquals(2, value);
    }
    
    @Test
    public void canNotStartFromNonPassableTerrain() {
        this.service.setMap(this.map);
        int value = this.service.aStarDistance(4, 0, 1, 2);
        assertEquals(-1, value);
    }
    
        @Test
    public void idaStarDistanceReturnsZeroIfStartAndEndAreSame() {
        int value = this.service.idaStarDistance(1, 1, 1, 1);
        assertEquals(0, value);
    }
    
    @Test
    public void idaStarDistanceReturnsCorrectPathLength() {
        this.service.setMap(this.map);
        int value = this.service.idaStarDistance(0, 0, 1, 2);
        assertEquals(2, value);
    }
    
    @Test
    public void idaStarcanNotStartFromNonPassableTerrain() {
        this.service.setMap(this.map);
        int value = this.service.idaStarDistance(4, 0, 1, 2);
        assertEquals(-1, value);
    }

}
