/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author linjokin
 */
public class IDAStar {
    private final List<Node> path;
    private final int[][] map;
    private Node now;
    private final int xstart;
    private final int ystart;
    private int xend, yend;
    private Stack<Node> stack;
    
    public IDAStar(int[][] map, int xstart, int ystart) {
        this.map = map;
        this.xstart = xstart;
        this.ystart = ystart;
        this.now = new Node(null, xstart, ystart, 0, 0);
        this.path = new ArrayList<>();
        this.stack = new Stack<>();
    }
    
    public List<Node> findPathTo(int x, int y) {
        this.xend = x;
        this.yend = y;
        double threshold = this.distance(0, 0);
        this.stack.add(this.now);
        while (true) {
            double temp = search(0, threshold);
            if (temp == -1.0) {
                this.path.add(0, this.now);
                while (this.now.getX() != this.xstart || this.now.getY() != this.ystart) {
                    this.now = this.now.getParent();
                    this.path.add(0, this.now);
                }
                return this.path;
            }
            threshold = temp;
        }
    }
    
    
    
        /**
     * Calculates distance to the goal
     * Allows diagonal movement, but no extra cost on diagonal moves
     * 
     * @param dx movement to x
     * @param dy movement to y
     * @return distance
     */
    private double distance(int dx, int dy) {
        return Math.max((Math.abs(dx - this.xend)), Math.abs(dy - this.yend));
    }

    private double search(int gscore, double threshold) {
        this.now = this.stack.peek();
        double f = gscore + this.distance(now.getX(), now.getY());
        if (f > threshold) {
            return f;
        }
        if (this.now.getX() == xend && this.now.getY() == yend) {
            return -1.0;
        }
        double min = Double.MAX_VALUE;
        for (Node node : this.neighborNodes()) {
            this.stack.push(node);
            double temp = this.search(gscore + 1, threshold);
            if (temp == -1.0) {
                return -1.0;
            }
            if (temp < min) {
                min = temp;
            }
            this.stack.pop();
        }
        return min;
    }
    
    private static boolean findNeighborInList(List<Node> nodes, Node node) {
        return nodes.stream().anyMatch((n) -> (n.getX() == node.getX() && n.getY() == node.getY()));
    }
    
    private List<Node> neighborNodes() {
        List<Node> neighbors = new ArrayList<>();
        Node node;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                node = new Node(this.now, this.now.getX() + x, this.now.getY() + y, 
                        this.now.getG(), this.distance(this.now.getX() + x, this.now.getY() + y));
                if ((x != 0 || y != 0) // not this.now
                    && this.now.getX() + x >= 0 && this.now.getX() + x < this.map[0].length // check boundaries
                    && this.now.getY() + y >= 0 && this.now.getY() + y < this.map.length
                    && this.map[this.now.getY() + y][this.now.getX() + x] != -1 // check if walkable
                    && !findNeighborInList(neighbors, node)) { // check if not already done
                        if (this.now.getX() != this.now.getX() + x && this.now.getY() != this.now.getY() + y) {
                            node.setG(node.getParent().getG() + Math.sqrt(2));
                            node.setG(node.getG() + this.map[this.now.getY() + y][this.now.getX() + x]);
                            neighbors.add(node);
                      } else {
                            node.setG(node.getParent().getG() + 1);
                            node.setG(node.getG() + this.map[this.now.getY() + y][this.now.getX() + x]);
                            neighbors.add(node);
                      }
                }
            }
        }
        return neighbors;
    }
    
}
