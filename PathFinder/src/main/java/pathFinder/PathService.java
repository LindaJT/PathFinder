/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder;

import pathFinder.util.Node;
import pathFinder.algorithms.IDAStar;
import pathFinder.algorithms.AStar;
import pathFinder.util.Path;

/**
 *
 * @author linjokin
 */
public class PathService {
    
    private int[][] map;
    private int[][] astarMap;
    private int[][] idastarMap;
    
    public PathService() {
        this.map = new int[0][0];
        this.astarMap = new int[0][0];
        this.idastarMap = new int[0][0];
    }
    
    /**
     * Calls FileReader's file reading method.
     * 
     * @param fileName name of the file to be read
     * @return true if file was read and converted to a map array correctly
     */
    public boolean readFile(String fileName) {
        FileReader reader = new FileReader();
        this.map = reader.readFile(fileName);
        if (this.map.length < 3) {
            return false;
        }
        return true;
    }
    
    /**
     * Calculating distance of the shortest path
     * 
     * @param xstart start point x coordinate
     * @param ystart start point y coordinate
     * @param xend goal point x coordinate
     * @param yend goal point y coordinate
     * @param heuristic chosen heuristic function
     * @return distance of the shortest path
     */
    public Double aStarDistance(int xstart, int ystart, int xend, int yend, String heuristic) {
        if (xstart == xend && ystart == yend) {
            return 0.;
        } else if (this.map[ystart][xstart] == -1 || this.map[yend][xend] == -1) {
            return -1.;
        }
        AStar astar = new AStar(this.map, xstart, ystart);
        Path path = astar.findPathTo(xend, yend, heuristic).flip();
        this.astarMap = new int[this.map.length][this.map[0].length];
        for (int x = 0; x < this.map.length; x++) {
            System.arraycopy(this.map[x], 0, this.astarMap[x], 0, this.map[0].length);
        }

        for (int i = 0; i < path.getSize(); i++) {
            Node n = path.getNode(i);
       //     System.out.print("[" + n.getX() + ", " + n.getY() + ", " + n.getG() + "] ");
            this.astarMap[n.getY()][n.getX()] = 1;
        }
        
        
        boolean[][] visited = astar.getVisited();
        for (int x = 0; x < this.map.length; x++) {
            for (int y = 0; y < this.map[0].length; y++) {
                if (visited[x][y] && this.astarMap[x][y] != 1) {
                    this.astarMap[x][y] = 2;
                }
            }
        }

     /*   System.out.println();
        for (int[] mazerow : astarMap) {
            for (int mazeentry : mazerow) {
                switch (mazeentry) {
                    case 0:
                        System.out.print(".");
                        break;
                    case -1:
                        System.out.print("@");
                        break;
                    case 1:
                        System.out.println("#");
                        break;
                    default:
                        System.out.println("*");
                }
            }
            System.out.println();
        }*/
        double distance = (double) path.getNode(path.getSize() - 1).getG();
        return distance;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }
    
    

        /**
     * Calculating distance of the shortest path using IDA-star
     * 
     * @param xstart start point x coordinate
     * @param ystart start point y coordinate
     * @param xend goal point x coordinate
     * @param yend goal point y coordinate
     * @param heuristic chosen heuristic function
     * @return distance of the shortest path
     */
    public double idaStarDistance(int xstart, int ystart, int xend, int yend, String heuristic) {
        if (xstart == xend && ystart == yend) {
            return 0.;
        } else if (this.map[ystart][xstart] == -1 || this.map[yend][xend] == -1) {
            return -1.;
        }
        IDAStar idastar = new IDAStar(this.map, xstart, ystart);
        Path path = idastar.findPathTo(xend, yend, heuristic).flip();
        this.idastarMap = new int[this.map.length][this.map[0].length];
        for (int x = 0; x < this.map.length; x++) {
            System.arraycopy(this.map[x], 0, this.idastarMap[x], 0, this.map[0].length);
        }
        for (int i = 0; i < path.getSize(); i++) {
            Node n = path.getNode(i);
   //         System.out.print("[" + n.getX() + ", " + n.getY() + ", " + n.getG() + "] ");
            this.idastarMap[n.getY()][n.getX()] = 1;
        }
        boolean[][] visited = idastar.getVisited();
        for (int x = 0; x < this.map.length; x++) {
            for (int y = 0; y < this.map[0].length; y++) {
                if (visited[x][y] && this.idastarMap[x][y] != 1) {
                    this.idastarMap[x][y] = 2;
                }
            }
        }

        
   /*     System.out.println();
        for (int[] mazerow : idastarMap) {
            for (int mazeentry : mazerow) {
                switch (mazeentry) {
                    case 0:
                        System.out.print("_");
                        break;
                    case -1:
                        System.out.print("*");
                        break;
                    default:
                        System.out.print("#");
                }
            }
            System.out.println();
        }*/
        double distance = (double) path.getNode(path.getSize() - 1).getG();
        return distance;
    }
    
    /**
     * For visualization
     * Writes the map with the path on a file
     * @param astar True, if using aStar map, false for idaStar map
     */
    public void drawPath(Boolean astar) {
        PathWriter writer = new PathWriter();
        if (astar) {
            writer.drawAstarPath(this.astarMap);
        } else {
            writer.drawIdaPath(this.idastarMap);
        }
    }
    
}
