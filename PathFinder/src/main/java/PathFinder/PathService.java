/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PathFinder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author linjokin
 */
public class PathService {
    
    public int[][] map;
    
    public PathService() {
        
    }
    
    public boolean readFile(String fileName) {
        FileReader reader = new FileReader();
        this.map = reader.readFile(fileName);
        if (this.map.length == 0) {
            return false;
        }
        return true;
    }
    
    public int aStarDistance(int xstart, int ystart, int xend, int yend) {
        if (xstart == xend && ystart == yend) {
            return 0;
        } else if (this.map[ystart][xstart] == -1 || this.map[yend][xend] == -1) {
            return -1;
        }
        AStar astar = new AStar(this.map, xstart, ystart);
        List<Node> path = astar.findPathTo(xend, yend);
        if (path != null) {
            path.forEach((n) -> {
                System.out.print("[" + n.x + ", " + n.y + "] ");
                this.map[n.y][n.x] = 1;
            });
        } else {
            return 0;
        }
        System.out.println();
        for (int[] maze_row : map) {
            for (int maze_entry : maze_row) {
                switch (maze_entry) {
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
        }
        int distance = (int) path.get(path.size() - 1).getG();
        return distance;
    }
    
    public void drawPath() {
        List<String> lines = new ArrayList<>();
        String line = "";
        for (int[] map_row : map) {
            for (int map_entry : map_row) {
                String c = "";
                switch (map_entry) {
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
