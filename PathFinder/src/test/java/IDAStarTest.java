/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import pathFinder.algorithms.IDAStar;
import pathFinder.util.Path;

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
        Path path = ida.findPathTo(10, 2);
        assertFalse(path.getSize() == 0);
    }
    
    @Test
    public void correctNumberOfNodesOnThePath() {
        Path path = ida.findPathTo(10, 2);
        assertEquals(9, path.getSize());
        Path path2 = ida.findPathTo(7, 4);
        assertEquals(6, path2.getSize());
    }
    
    @Test
    public void pathLenghtIsCorrect() {
        Path path2 = ida.findPathTo(7, 4);
        assertEquals(5,  (int) path2.getNode(0).getG());
    }
}
