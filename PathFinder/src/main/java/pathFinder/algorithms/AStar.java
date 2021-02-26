/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder.algorithms;

import pathFinder.util.Node;
import pathFinder.util.MinHeap;
import pathFinder.util.Path;

/**
 * Finding shortest path with AStar
 * @author linjokin
 */
public class AStar {
    
    private final MinHeap heap;
    private final int[][] map;
    private Node now;
    private final int xstart;
    private final int ystart;
    private int xend, yend;
    private Node[][] cameFrom;
    private double[][] costSoFar;
    private boolean[][] visited;
    private String heuristic;
    
    public AStar(int[][] map, int xstart, int ystart) {
        
        this.map = map;
        this.now = new Node(null, xstart, ystart, 0, 0);
        this.xstart = xstart;
        this.ystart = ystart;
        this.heap = new MinHeap(this.map.length * this.map.length, this.now);
        this.cameFrom = new Node[this.map.length][this.map[0].length];
        this.costSoFar = new double[this.map.length][this.map[0].length];
        this.cameFrom[0][0] = null;
        this.costSoFar[0][0] = 0;
        this.visited = new boolean[this.map.length][this.map[0].length];
        this.visited[ystart][xstart] = true;
    }
    
    /**
     * Main method finding path to the coordinates given as parameters. 
     * 
     * @param x goal x coordinate
     * @param y goal y coordinate
     * @param heuristic chosen heuristic function
     * @return List of nodes on the found path
     */
        public Path findPathTo(int x, int y, String heuristicF) {
        this.xend = x;
        this.yend = y;
        this.heuristic = heuristicF;
        addNeigborsToOpenList();
        while (this.heap.getSize() > 0) {
            this.now = this.heap.remove(); 
            this.visited[this.now.getY()][this.now.getX()] = true;
            if (this.now.getX() == this.xend && this.now.getY() == this.yend) {
                Path path = new Path((int) this.now.getG() + 1);
                path.insert(this.now);
                while (this.now.getX() != this.xstart || this.now.getY() != this.ystart) {
                    this.now = this.now.getParent();
                    path.insert(this.now);
                }
                return path;
            }
            addNeigborsToOpenList();
        }
        return null;
    }

    public boolean[][] getVisited() {
        return visited;
    }

    /**
     * Calculates diagonal distance (uniform cost) to the goal
     * 
     * 
     * @param dx movement to x
     * @param dy movement to y
     * @return distance
     */
    private double distance(int dx, int dy) {
        if (this.heuristic.equals("uniformCost")) {
            return Math.max((Math.abs(dx - this.xend)), Math.abs(dy - this.yend));
        } else if (this.heuristic.equals("diagonal")) {
            double dmax = Math.max(Math.abs(dx - this.xend), Math.abs(dy - this.yend));
            double dmin = Math.min(Math.abs(dx - this.xend), Math.abs(dy - this.yend));
            return Math.sqrt(2) * dmin + (dmax - dmin);
        } else {
            return Math.sqrt((this.yend - dy) * (this.yend - dy) + (this.xend - dx) * (this.xend - dx));
        }
    }
    
    /**
     * Function to check if two nodes are diagonal
     * @param x change in x
     * @param y change in y
     * @return True if diagonal
     */
    private boolean isDiagonal(int x, int y) {
        return this.now.getX() != this.now.getX() + x && this.now.getY() != this.now.getY() + y;
    }
    
    
    /**
     * Adds current node's neighbors to the heap
     */
    private void addNeigborsToOpenList() {
        Node node;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int newX = this.now.getX() + x;
                int newY = this.now.getY() + y;
                if ((x != 0 || y != 0) // not this.now
                    && this.map[this.now.getY() + y][this.now.getX() + x] != -1) {
                    double cost;
                    if (isDiagonal(x, y)) {
                        cost = this.costSoFar[this.now.getY()][this.now.getX()] + Math.sqrt(2);
                    } else {
                        cost = this.costSoFar[this.now.getY()][this.now.getX()] + 1;
                    }
                    if (this.costSoFar[newY][newX] == 0. || cost < this.costSoFar[newY][newX]) {
                        this.costSoFar[newY][newX] = cost;
                        double dist = distance(newX, newY);
                        node = new Node(this.now, newX, newY, cost, dist);
                        this.heap.insert(node);
                        this.cameFrom[newY][newX] = this.now;
                    }
                }
            }
        }
    }
}

