
package pathFinder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class writes the map and path on a file
 * New file is created if it doesn't exist yet
 * 
 * @author linjokin
 */
public class PathWriter {

    void drawAstarPath(int[][] astarMap) {
        List<String> lines = new ArrayList<>();
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
        lines.add(line);
        line = "";
        }
        try {
            FileWriter fileWriter = new FileWriter("pathAStar.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("A Star Path:");
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

    void drawIdaPath(int[][] idastarMap) {
        List<String> lines = new ArrayList<>();
        String line = "";
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
        lines.add(line);
        line = "";
        }
        try {
            FileWriter fileWriter = new FileWriter("pathIDA.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("IDA Star Path:");
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
