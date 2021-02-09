/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import pathFinder.util.NeighborsList;

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
    private double[][] costSoFar;
    private boolean[][] inStack;
    
    public IDAStar(int[][] map, int xstart, int ystart) {
        this.map = map;
        this.xstart = xstart;
        this.ystart = ystart;
        this.now = new Node(null, xstart, ystart, 0, 0);
        this.path = new ArrayList<>();
        this.stack = new Stack<>();
        this.costSoFar = new double[this.map.length][this.map[0].length];
        this.costSoFar[0][0] = 0.;
        this.inStack = new boolean[this.map.length][this.map[0].length];
    }
    
    public List<Node> findPathTo(int x, int y) {
        this.xend = x;
        this.yend = y;
        double threshold = this.distance(xstart, ystart);
        this.stack.add(this.now);
        this.inStack[this.now.getY()][this.now.getX()] = true;
     
        while (true) {
            System.out.println("EKA WHILE");
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

    private double search(double gscore, double threshold) {
        System.out.println("SEARCH " + gscore + " " + threshold);
        this.now = this.stack.peek();
        System.out.println("NOW " + this.now.getX() + " " + this.now.getY() + " " + this.inStack[this.now.getY()][this.now.getX()]);
        double f = gscore + this.distance(now.getX(), now.getY());
        this.now.setG(gscore);
        this.now.setH(this.distance(now.getX(), now.getY()));
        System.out.println("F " + f);
        if (f > threshold) {
            return f;
        }
        if (this.now.getX() == xend && this.now.getY() == yend) {
            return -1.0;
        }
        double min = Double.MAX_VALUE;
        NeighborsList neighbors = this.neighborNodes();
        for (int i = 0; i < neighbors.getSize(); i++) {
            Node neighbor = neighbors.getNode(i);
            if (!this.inStack[neighbor.getY()][neighbor.getX()]) {
                this.stack.push(neighbor);
                this.inStack[neighbor.getY()][neighbor.getX()] = true;
                double cost;
                if (isDiagonal(neighbor.getX(), neighbor.getY())) {
                    cost = Math.sqrt(2);
                } else {
                    cost = 1.;
                }
                double temp = this.search(gscore + cost, threshold);
                if (temp == -1.0) {
                    return -1.0;
                }
                if (temp < min) {
                    min = temp;
                }
                Node removed = this.stack.pop();
                this.inStack[removed.getY()][removed.getX()] = false;
            }
        }
        return min;
    }
    
    private boolean isDiagonal(int x, int y) {
        return this.now.getX() - x == 0 && this.now.getY() - y == 0;
    }
    
    private static boolean findNeighborInList(List<Node> nodes, Node node) {
        return nodes.stream().anyMatch((n) -> (n.getX() == node.getX() && n.getY() == node.getY()));
    }
    
    private NeighborsList neighborNodes() {
        System.out.println("NEIGHBORS");
        NeighborsList neighbors = new NeighborsList();
        Node node;
        boolean[][] visited = new boolean[3][3];
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int newX = this.now.getX() + x;
                int newY = this.now.getY() + y;
                if ((x != 0 || y != 0) // not this.now
                    && this.now.getX() + x >= 0 && this.now.getX() + x < this.map[0].length // check boundaries
                    && this.now.getY() + y >= 0 && this.now.getY() + y < this.map.length
                    && this.map[this.now.getY() + y][this.now.getX() + x] != -1 // check if walkable
                    && !visited[y + 1][x + 1]) { // check if not already done
                        double cost;
                        if (this.now.getX() != this.now.getX() + x && this.now.getY() != this.now.getY() + y) {
                            cost = this.costSoFar[this.now.getY()][this.now.getX()] + Math.sqrt(2);
                      } else {
                            cost = this.costSoFar[this.now.getY()][this.now.getX()] + 1;
                      }
                        costSoFar[newY][newX] = cost;
                        double dist = distance(newX, newY);
                        node = new Node(this.now, newX, newY, cost, dist);
                        neighbors.insert(node);
                        System.out.println("LISÄTÄÄN " + node.getX() + " " + node.getY() + " " + node.getG() + " " + node.getH());
                        visited[y + 1][x + 1] = true;
                }
            }
        }
        return neighbors;
    }
    
}
