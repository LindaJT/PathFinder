/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder.algorithms;

import pathFinder.util.NeighborsList;
import pathFinder.util.Node;
import pathFinder.util.Path;

/**
 *
 * @author linjokin
 */
public class IDAStar {
    private final int[][] map;
    private Node now;
    private final int xstart;
    private final int ystart;
    private int xend, yend;
    private final double[][] costSoFar;
    private final boolean[][] inStack;
    
    public IDAStar(int[][] map, int xstart, int ystart) {
        this.map = map;
        this.xstart = xstart;
        this.ystart = ystart;
        this.now = new Node(null, xstart, ystart, 0, 0);
        this.costSoFar = new double[this.map.length][this.map[0].length];
        this.costSoFar[0][0] = 0.;
        this.inStack = new boolean[this.map.length][this.map[0].length];
    }
    
        /**
     * Main method finding path to the coordinates given as parameters. 
     * 
     * @param goalX goal x coordinate
     * @param goalY goal y coordinate
     * @return List of nodes on the found path
     */
    public Path findPathTo(int goalX, int goalY) {
        this.xend = goalX;
        this.yend = goalY;
        double threshold = this.distance(xstart, ystart);
        Node startNode = this.now;
        this.inStack[startNode.getY()][startNode.getX()] = true;
     
        while (true) {
            double temp = search(startNode, 0, threshold);
            if (temp == -1.0) {
                if (this.now.getX() == this.xend && this.now.getY() == this.yend) {
                    Path path = new Path((int) this.now.getG() + 1);
                    path.insert(this.now);
                    while (this.now.getX() != this.xstart || this.now.getY() != this.ystart) {
                        this.now = this.now.getParent();
                        path.insert(this.now);
                    }
                    return path;
                }
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

    /**
     * Recursive function to go throw different paths
     * Returns -1.0, if goal node is found
     * @param currentNode
     * @param gscore distance travelled
     * @param threshold 
     * @return
     */
    private double search(Node currentNode, double gscore, double threshold) {
        double f = gscore + this.distance(currentNode.getX(), currentNode.getY());
        currentNode.setG(gscore);
        currentNode.setH(this.distance(currentNode.getX(), currentNode.getY()));
        if (f > threshold) {
            return f;
        }
        if (currentNode.getX() == this.xend && currentNode.getY() == this.yend) {
            this.now = currentNode;
            return -1.0;
        }
        double min = Double.MAX_VALUE;
        NeighborsList neighbors = this.neighborNodes(currentNode);
        for (int i = 0; i < neighbors.getSize(); i++) {
            Node neighbor = neighbors.getNode(i);
            if (!this.inStack[neighbor.getY()][neighbor.getX()]) {
                this.inStack[neighbor.getY()][neighbor.getX()] = true;
                double cost;
                if (isDiagonal(currentNode, neighbor.getX(), neighbor.getY())) {
                    cost = Math.sqrt(2);
                } else {
                    cost = 1.;
                }
                double temp = this.search(neighbor, gscore + cost, threshold);
                if (temp == -1.0) {
                    return -1.0;
                }
                if (temp < min) {
                    min = temp;
                }
                this.inStack[neighbor.getY()][neighbor.getX()] = false;
            }
        }
        return min;
    }
        /**
     * Function to check if two nodes are diagonal
     * @param x change in x
     * @param y change in y
     * @return True if diagonal
     */
    private boolean isDiagonal(Node parent, int x, int y) {
        return parent.getX() != x && parent.getY() != y;
    }
    
    /**
     * Adds the neighbors of current node to 
     * neighborsList data structure
     * @param currentNode 
     * @return list of neighbors
     */
    private NeighborsList neighborNodes(Node currentNode) {
        NeighborsList neighbors = new NeighborsList();
        Node node;
        boolean[][] visited = new boolean[3][3];
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int newX = currentNode.getX() + x;
                int newY = currentNode.getY() + y;
                if ((x != 0 || y != 0) // not this.now
                    && this.map[newY][newX] != -1 // check if walkable
                    && !visited[y + 1][x + 1]) { // check if not already done
                        double cost;
                        if (currentNode.getX() != currentNode.getX() + x && currentNode.getY() != currentNode.getY() + y) {
                            cost = currentNode.getG() + Math.sqrt(2);
                      } else {
                            cost = currentNode.getG() + 1;
                      } 
                        double dist = distance(newX, newY);
                        node = new Node(currentNode, newX, newY, cost, dist);
                        neighbors.insert(node);
                }
            }
        }
        return neighbors;
    }
    
}
