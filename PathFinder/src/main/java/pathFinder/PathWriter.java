
package pathFinder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class writes the map and path on a file
 * New file is created if it doesn't exist yet
 * 
 * @author linjokin
 */
public class PathWriter {

    
    /**
     * For visualization
     * Draws the map, found path and visited nodes to a file
     * @param astarMap map with path and visited nodes
     */
    public void drawAstarPath(int[][] astarMap) {
        String[] lines = new String[astarMap.length];
        int i = 0;
        String line = "";
        for (int[] maprow : astarMap) {
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
            lines[i] = line;
            i++;
            line = "";
        }
        try {
            FileWriter fileWriter = new FileWriter("results/pathAStar.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("A Star Path:");
            writer.newLine();
            for (int z = 0; z < lines.length; z++) {
                writer.write(lines[z]);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
    /**
     * For visualization
     * Draws the map, found path and visited nodes to a file
     * @param idastarMap map with path and visited nodes
     */
    public void drawIdaPath(int[][] idastarMap) {
        String[] lines = new String[idastarMap.length];
        String line = "";
        int i = 0;
        for (int[] maprow : idastarMap) {
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
        lines[i] = line;
        i++;
        line = "";
        }
        try {
            FileWriter fileWriter = new FileWriter("results/pathIDA.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("IDA Star Path:");
            writer.newLine();
            for (int z = 0; z < lines.length; z++) {
                writer.write(lines[z]);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
    
    
    
}
