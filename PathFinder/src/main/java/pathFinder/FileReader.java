
package pathFinder;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *This class reads the file and converts the map in it
 * into a 2D integer array
 * @author linjokin
 */
public class FileReader {
    
    private int[][] map;
    private List<String> lines = new ArrayList<>();
    
    public FileReader() {
        this.map = new int[0][0];
        
    }
    
    /**
     * Tries to read the file with the given filename
     * If file is in correct form, converts the file to map array
     * Adds walls to the outer edges
     * 
     * @param fileName name of the file
     * @return map array
     */
    public int[][] readFile(String fileName) {
        lines.add("");
        int rows = 0;
        int columns = 0;
        try (Scanner reader = new Scanner(Paths.get(fileName))) {

            while (reader.hasNextLine()) {
                rows++;
                String line = "_" + reader.nextLine() + "_";
                columns = line.length();
                lines.add(line);
            }
            lines.add("");
            this.map = new int[rows + 2][columns];
        } catch (Exception e) {
            System.out.println("Virhe " + e.getMessage());
        }

        for (int i = 0; i < lines.size(); i++) {
            for (int x = 0; x < columns; x++) {
                if (i == 0 || i == lines.size() - 1) {
                    this.map[i][x] = -1;
                } else {
                    if (lines.get(i).charAt(x) == '.') {
                    this.map[i][x] = 0;
                    } else {
                        this.map[i][x] = -1;
                    }
                }
            }
        }
        
        return this.map;
        
    }
}
