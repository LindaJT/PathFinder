/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author linjokin
 */
public class FileReader {
    
    private int[][] map;
    private List<String> lines = new ArrayList<>();
    
    public FileReader() {
        this.map = new int[0][0];
        
    }
    
    public int[][] readFile(String fileName) {
        try (Scanner reader = new Scanner(Paths.get(fileName))) {
            int rows = 0;
            int columns = 0;
            while (reader.hasNextLine()) {
                rows++;
                String line = reader.nextLine();
                columns = line.length();
                lines.add(line);
            }
            this.map = new int[rows][columns];
        } catch (Exception e) {
            System.out.println("Virhe " + e.getMessage());
        }

        for (int i = 0; i < lines.size(); i++) {
            for (int x = 0; x < lines.get(i).length(); x++) {
                if (lines.get(i).charAt(x) == '.') {
                    this.map[i][x] = 0;
                } else {
                    this.map[i][x] = -1;
                }
  //              System.out.print(this.labyrinth[i][x]);
            }
           // System.out.println("");
        }
        
        return this.map;
        
    }
    
}
