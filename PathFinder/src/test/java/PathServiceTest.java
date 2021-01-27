

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
        boolean value = this.service.readFile("test2.txt");
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
    
  //  @Test
    //public void aStarDistanceReturnsCorrectPathLength() {
      //  this.service.getMap() = this.map;
  //      int value = this.service.aStarDistance(0, 0, 1, 2);
  //      assertEquals(2, value);
    //}
    
 /*   @Test
    public void canNotStartFromNonPassableTerrain() {
        this.service.map = this.map;
        int value = this.service.aStarDistance(4, 0, 1, 2);
        assertEquals(-1, value);
    }*/

}
