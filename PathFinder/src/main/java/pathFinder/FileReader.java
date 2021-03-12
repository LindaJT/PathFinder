
package pathFinder;

import java.nio.file.Paths;
import java.util.Scanner;

/**
 *This class reads the file and converts the map in it
 * into a 2D integer array
 * @author linjokin
 */
public class FileReader {
    
    private int[][] map;
    private String[] array;
    
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
        System.out.println("Täällä");
        int rows = 0;
        int columns = 0;
        try (Scanner reader = new Scanner(Paths.get(fileName))) {
            while(reader.hasNextLine()) {
                reader.nextLine();
                rows++;
            }
            array = new String[rows + 2];
            array[0] = "";
            int i = 1;
            System.out.println("ROWS " + rows);
            Scanner newReader = new Scanner(Paths.get(fileName));
            while (newReader.hasNextLine()) {
                String line = "_" + newReader.nextLine() + "_";
                columns = line.length();
                array[i] = line;
                i++;
            }
            array[array.length - 1] = "";
            this.map = new int[rows + 2][columns];
        } catch (Exception e) {
            System.out.println("Virhe " + e.getMessage());
        }
        if (rows < 2) {
            return this.map;
        }
        for (int i = 0; i < array.length; i++) {
            for (int x = 0; x < columns; x++) {
                if (i == 0 || i == array.length - 1) {
                    this.map[i][x] = -1;
                } else {
                    if (array[i].charAt(x) == '.') {
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
