/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pathFinder.IDAStar;
import pathFinder.Node;

/**
 *
 * @author linjokin
 */
public class IDAStarTest {
    
    public int[][] map = {{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}, 
                          {-1,0,0,0,0,0,0,0,0,0,0,-1},
                          {-1,0,0,0,0,-1,-1,-1,-1,0,0,-1},
                          {-1,0,0,0,0,0,0,0,-1,0,0,-1},
                          {-1,0,0,0,0,0,0,0,-1,0,0,-1},
                          {-1,0,0,0,0,0,0,0,-1,0,0,-1},
                          {-1,0,0,0,0,0,0,0,0,0,0,-1},
                          {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};
    public IDAStar ida;
    
    public IDAStarTest() {
        this.ida = new IDAStar(this.map, 2, 4);
    }
   
    @Test
    public void findPathToReturnsAList() {
        List<Node> path = ida.findPathTo(10, 2);
        assertFalse(path.isEmpty());
    }
    
    @Test
    public void pathIsCorrectLength() {
        List<Node> path = ida.findPathTo(10, 2);
        assertEquals(9, path.size());
    }
    
    public void sameStartAndEndReturnsEmptyList() {
        List<Node> path = ida.findPathTo(1, 1);
        assertTrue(path.isEmpty());
    }
    
}
