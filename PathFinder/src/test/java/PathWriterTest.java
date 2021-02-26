
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pathFinder.PathWriter;


/**
 * Tests for PathWriter class
 * @author linjokin
 */
public class PathWriterTest {
    
    public int[][] mapToDraw = {{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}, 
                          {-1,0,0,0,1,1,1,1,0,0,0,-1},
                          {-1,0,2,1,2,-1,-1,-1,-1,0,0,-1},
                          {-1,0,1,2,0,0,0,0,-1,0,0,-1},
                          {-1,0,0,0,0,0,0,0,-1,0,0,-1},
                          {-1,0,0,0,0,0,0,0,-1,0,0,-1},
                          {-1,0,0,0,0,0,0,0,0,0,0,-1},
                          {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};
    public PathWriter writer;
    
    @Before
    public void setUp() {
        this.writer = new PathWriter();
    }
    
    @Test
    public void fileIsCreatedAstar() {
        this.writer.drawAstarPath(mapToDraw);
        boolean success = false;
        File file = new File("results/pathAStar.txt");
        if (file.exists()) {
            success = true;
        }
        assertTrue(success);
    }
    
    @Test
    public void fileIsCreatedIDAstar() {
        this.writer.drawIdaPath(mapToDraw);
        boolean success = false;
        File file = new File("results/pathIDA.txt");
        if (file.exists()) {
            success = true;
        }
        assertTrue(success);
    }
  

}
