/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PathFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author linjokin
 */
public class AStar {
    
    private final List<Node> open;
    private final List<Node> closed;
    private final List<Node> path;
    private final int[][] map;
    private Node now;
    private final int xstart;
    private final int ystart;
    private int xend, yend;
    
    public AStar(int[][] map, int xstart, int ystart) {
        
        this.open = new ArrayList<>();
        this.closed = new ArrayList<>();
        this.path = new ArrayList<>();
        this.map = map;
        this.now = new Node(null, xstart, ystart, 0, 0);
        this.xstart = xstart;
        this.ystart = ystart;
    }
    
        public List<Node> findPathTo(int xend, int yend) {
        this.xend = xend;
        this.yend = yend;
        this.closed.add(this.now);
        addNeigborsToOpenList();
        while (this.now.x != this.xend || this.now.y != this.yend) {
            if (this.open.isEmpty()) { 
                return null;
            }
            this.now = this.open.get(0); 
            this.open.remove(0); 
            this.closed.add(this.now); 
            addNeigborsToOpenList();
        }
        this.path.add(0, this.now);
        while (this.now.x != this.xstart || this.now.y != this.ystart) {
            this.now = this.now.parent;
            this.path.add(0, this.now);
        }
        return this.path;
    }

    private static boolean findNeighborInList(List<Node> array, Node node) {
        return array.stream().anyMatch((n) -> (n.x == node.x && n.y == node.y));
    }

    private double distance(int dx, int dy) {
        return Math.hypot(this.now.x + dx - this.xend, this.now.y + dy - this.yend);

    }
    private void addNeigborsToOpenList() {
        Node node;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                node = new Node(this.now, this.now.x + x, this.now.y + y, this.now.g, this.distance(x, y));
                if ((x != 0 || y != 0) // not this.now
                    && this.now.x + x >= 0 && this.now.x + x < this.map[0].length // check maze boundaries
                    && this.now.y + y >= 0 && this.now.y + y < this.map.length
                    && this.map[this.now.y + y][this.now.x + x] != -1 // check if square is walkable
                    && !findNeighborInList(this.open, node) && !findNeighborInList(this.closed, node)) { // if not already done
                        node.g = node.parent.g + 1.; // Horizontal/vertical cost = 1.0
                        node.g += map[this.now.y + y][this.now.x + x]; // add movement cost for this square

                        this.open.add(node);
                }
            }
        }
        Collections.sort(this.open);
    }
}

