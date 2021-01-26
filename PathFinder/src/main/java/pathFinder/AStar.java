/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder;

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
    
        public List<Node> findPathTo(int x, int y) {
        this.xend = x;
        this.yend = y;
        this.closed.add(this.now);
        addNeigborsToOpenList();
        while (this.now.getX() != this.xend || this.now.getY() != this.yend) {
            if (this.open.isEmpty()) { 
                return null;
            }
            this.now = this.open.get(0); 
            this.open.remove(0); 
            this.closed.add(this.now); 
            addNeigborsToOpenList();
        }
        this.path.add(0, this.now);
        while (this.now.getX() != this.xstart || this.now.getY() != this.ystart) {
            this.now = this.now.getParent();
            this.path.add(0, this.now);
        }
        return this.path;
    }

    private static boolean findNeighborInList(List<Node> array, Node node) {
        return array.stream().anyMatch((n) -> (n.getX() == node.getX() && n.getY() == node.getY()));
    }

    private double distance(int dx, int dy) {
        return Math.hypot(this.now.getX() + dx - this.xend, this.now.getY() + dy - this.yend);

    }
    private void addNeigborsToOpenList() {
        Node node;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                node = new Node(this.now, this.now.getX() + x, this.now.getY() + y, this.now.getG(), this.distance(x, y));
                if ((x != 0 || y != 0) // not this.now
                    && this.now.getX() + x >= 0 && this.now.getX() + x < this.map[0].length // check maze boundaries
                    && this.now.getY() + y >= 0 && this.now.getY() + y < this.map.length
                    && this.map[this.now.getY() + y][this.now.getX() + x] != -1 // check if square is walkable
                    && !findNeighborInList(this.open, node) && !findNeighborInList(this.closed, node)) { // if not already done
                        node.setG(node.getParent().getG() + 1.); // Horizontal/vertical cost = 1.0
                        node.setG(node.getG() + this.map[this.now.getY() + y][this.now.getX() + x]); // add movement cost for this square

                        this.open.add(node);
                }
            }
        }
        Collections.sort(this.open);
    }
}

