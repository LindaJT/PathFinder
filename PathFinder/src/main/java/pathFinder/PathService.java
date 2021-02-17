/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
     * @return distance of the shortest path
     */
    public Double aStarDistance(int xstart, int ystart, int xend, int yend) {
        if (xstart == xend && ystart == yend) {
            return 0.;
        } else if (this.map[ystart][xstart] == -1 || this.map[yend][xend] == -1) {
            return -1.;
        }
        AStar astar = new AStar(this.map, xstart, ystart);
     //   List<Node> path = astar.findPathTo(xend, yend);
        Path path = astar.findPathTo(xend, yend).flip();
        this.astarMap = new int[this.map.length][this.map[0].length];
        for (int x = 0; x < this.map.length; x++) {
            for (int y = 0; y < this.map[0].length; y++) {
                this.astarMap[x][y] = this.map[x][y];
            }
        }
        if (path != null) {
     /*       path.forEach((n) -> {
                System.out.print("[" + n.getX() + ", " + n.getY() + "] ");
                this.astarMap[n.getY()][n.getX()] = 1;
            });*/
              for (int i = 0; i < path.getSize(); i++) {
                  Node n = path.getNode(i);
                  System.out.print("[" + n.getX() + ", " + n.getY() + ", " + n.getG() + "] ");
                  this.astarMap[n.getY()][n.getX()] = 1;
              }
        } else {
            return 0.;
        }
        
        double[][] costs = astar.getCostSoFar();
        for (int x = 0; x < this.map.length; x++) {
            for (int y = 0; y < this.map[0].length; y++) {
                if (costs[x][y] > 1 && this.astarMap[x][y] != 1) {
                    this.astarMap[x][y] = (int) costs[x][y];
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
     * @return distance of the shortest path
     */
    public double idaStarDistance(int xstart, int ystart, int xend, int yend) {
        if (xstart == xend && ystart == yend) {
            return 0.;
        } else if (this.map[ystart][xstart] == -1 || this.map[yend][xend] == -1) {
            return -1.;
        }
        IDAStar idastar = new IDAStar(this.map, xstart, ystart);
        List<Node> idaPath = idastar.findPathTo(xend, yend);
        this.idastarMap = new int[this.map.length][this.map[0].length];
        for (int x = 0; x < this.map.length; x++) {
            for (int y = 0; y < this.map[0].length; y++) {
                this.idastarMap[x][y] = this.map[x][y];
            }
        }
        if (idaPath != null) {
            idaPath.forEach((n) -> {
                System.out.print("[" + n.getX() + ", " + n.getY() + "] ");
                this.idastarMap[n.getY()][n.getX()] = 1;
            });
        } else {
            return 0.;
        }
  /*      System.out.println("");
        DecimalFormat df = new DecimalFormat("#.##");
        double[][] costs = idastar.getCostSoFar();
        for (int x = 0; x < costs.length; x++) {
            for (int y = 0; y < costs[0].length; y++) {
                System.out.print(df.format(costs[x][y]) + " ");
            }
            System.out.println("");
        }
        
        System.out.println();
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
        double distance = (double) idaPath.get(idaPath.size() - 1).getG();
        return distance;
    }
    
    public int[][] getMap() {
        return map;
    }
    
    /**
     * For visualization
     * Writes the map with the path on a file
     * @param astar True, if using aStar map, false for idaStar map
     */
    public void drawPath(Boolean astar) {
        List<String> lines = new ArrayList<>();
        String line = "";
        if (astar) {
            for (int[] maprow : this.astarMap) {
                for (int mapentry : maprow) {
                    String c = "";
                    switch (mapentry) {
                        case 0:
                            c = ".";
                            break;
                        case -1:
                            c = "@";
                            break;
                        case 1:
                            c = "#";
                            break;
                        default:
                            c = "*";
                    }
                line = line + c;
            }
            lines.add(line);
            line = "";
            }
        } else {
            for (int[] maprow : this.idastarMap) {
                for (int mapentry : maprow) {
                    String c = "";
                    switch (mapentry) {
                        case 0:
                            c = ".";
                            break;
                        case -1:
                            c = "@";
                            break;
                        default:
                            c = "#";
                    }
                line = line + c;
            }
            lines.add(line);
            line = "";
            }
        }
        try {
            FileWriter fileWriter = new FileWriter("path.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("Path:");
            writer.newLine();
            for (int i = 0; i < lines.size(); i++) {
                writer.write(lines.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
    
}
