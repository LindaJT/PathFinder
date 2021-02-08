/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import pathFinder.util.MinHeap;

/**
 * Finding shortest path with AStar
 * @author linjokin
 */
public class AStar {
    
    private final PriorityQueue<Node> open;
    private final MinHeap heap;
    private final PriorityQueue<Node> closed;
    private final List<Node> path;
    private final int[][] map;
    private Node now;
    private final int xstart;
    private final int ystart;
    private int xend, yend;
    private Node[][] came_from;
    private double[][] cost_so_far;
    
    public AStar(int[][] map, int xstart, int ystart) {
        
        this.open = new PriorityQueue<>();
        this.closed = new PriorityQueue<>();
        this.path = new ArrayList<>();
        this.map = map;
        this.now = new Node(null, xstart, ystart, 0, 0);
        this.xstart = xstart;
        this.ystart = ystart;
        this.heap = new MinHeap(this.map.length * this.map.length, this.now);
        this.came_from = new Node[this.map.length][this.map[0].length];
        this.cost_so_far = new double[this.map.length][this.map[0].length];
        this.came_from[0][0] = null;
        this.cost_so_far[0][0] = 0;
    }
    
    /**
     * Main method finding path to the coordinates given as parameters. 
     * 
     * @param x goal x coordinate
     * @param y goal y coordinate
     * @return List of nodes on the found path
     */
        public List<Node> findPathTo(int x, int y) {
        this.xend = x;
        this.yend = y;
       // this.closed.add(this.now);
        addNeigborsToOpenList();
        while (this.heap.getSize() > 0    /*!this.open.isEmpty() this.now.getX() != this.xend || this.now.getY() != this.yend*/) {
           /* if (this.open.isEmpty()) { 
                return null;
            }*/
            this.now = this.heap.remove(); 
          //  this.closed.add(this.now);
            if (this.now.getX() == this.xend && this.now.getY() == this.yend) {
                this.path.add(0, this.now);
                while (this.now.getX() != this.xstart || this.now.getY() != this.ystart) {
                    this.now = this.now.getParent();
                    this.path.add(0, this.now);
                }
                return this.path;
            }
            addNeigborsToOpenList();
        }
        return null;
    }
        
        public Node[][] getPath() {
            return this.came_from;
        }

        /**
         * To check if node is on a list
         * 
         * @param nodes list to be searched
         * @param node node to be found
         * @return true if node is found
         */
    private static boolean findNeighborInList(PriorityQueue<Node> nodes, Node node) {
        return nodes.stream().anyMatch((n) -> (n.getX() == node.getX() && n.getY() == node.getY()));
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
    
    private boolean isDiagonal(int x, int y) {
        return this.now.getX() != this.now.getX() + x && this.now.getY() != this.now.getY() + y;
    }
    
    private void addNeigborsToOpenList() {
        Node node;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int newX = this.now.getX() + x;
                int newY = this.now.getY() + y;
                if ((x != 0 || y != 0) // not this.now
                    && this.now.getX() + x >= 0 && this.now.getX() + x < this.map[0].length // check boundaries
                    && this.now.getY() + y >= 0 && this.now.getY() + y < this.map.length
                    && this.map[this.now.getY() + y][this.now.getX() + x] != -1) {
                    double cost;
                    if (isDiagonal(x, y)) {
                        cost = this.cost_so_far[this.now.getY()][this.now.getX()] + Math.sqrt(2);
                    } else {
                        cost = this.cost_so_far[this.now.getY()][this.now.getX()] + 1;
                    }
                    if (cost_so_far[newY][newX] == 0. || cost < cost_so_far[newY][newX]) {
                        cost_so_far[newY][newX] = cost;
                        double dist = distance(newX, newY);
                        node = new Node(this.now, newX, newY, cost, dist);
                        this.heap.insert(node);
                        this.came_from[newY][newX] = this.now;
                    }

                    
                }
            }
        }
    }
}

