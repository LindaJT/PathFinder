

import pathFinder.FileReader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileReaderTest {
    
    public FileReader reader;
    
    
    @Before
    public void setUp() {
        this.reader = new FileReader();
    }
    
    @Test
    public void readFileReturnsCorrectArray() {
        int[][] map = {{-1, -1, -1, -1, -1, -1, -1, -1, -1}, 
                        {-1, 0, 0, 0, 0, -1, -1, 0, -1},
                        {-1, 0, 0, -1, -1, -1, 0, 0, -1},
                        {-1, 0, 0, 0, -1, -1, 0, 0, -1},
                        {-1, 0, 0, 0, 0, 0, 0, 0, -1},
                        {-1, -1, -1, -1, -1, -1, -1, -1, -1}};
        int[][] returnedMap = this.reader.readFile("testFiles/test.txt");
        assertEquals(map.length, returnedMap.length);
        assertEquals(map[0].length, returnedMap[0].length);
        assertEquals(map[2][3], returnedMap[2][3]);
        assertEquals(map[3][5], returnedMap[3][5]);
    }

}
