/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Finding shortest path with AStar
 * @author linjokin
 */
public class AStar {
    
    private final PriorityQueue<Node> open;
    private final PriorityQueue<Node> closed;
    private final List<Node> path;
    private final int[][] map;
    private Node now;
    private final int xstart;
    private final int ystart;
    private int xend, yend;
    
    public AStar(int[][] map, int xstart, int ystart) {
        
        this.open = new PriorityQueue<>();
        this.closed = new PriorityQueue<>();
        this.path = new ArrayList<>();
        this.map = map;
        this.now = new Node(null, xstart, ystart, 0, 0);
        this.xstart = xstart;
        this.ystart = ystart;
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
        this.closed.add(this.now);
        addNeigborsToOpenList();
        while (!this.open.isEmpty() /*this.now.getX() != this.xend || this.now.getY() != this.yend*/) {
           /* if (this.open.isEmpty()) { 
                return null;
            }*/
            this.now = this.open.poll(); 
            this.closed.add(this.now);
            if (this.now.getX() == this.xend && this.now.getY() == this.yend) {
                this.path.add(0, this.now);
                while (this.now.getX() != this.xstart || this.now.getY() != this.ystart) {
                    this.now = this.now.getParent();
                    this.path.add(0, this.now);
                }
                return this.path;
            }
            addNeigborsToOpenList();
          /*  if (z > 5) {
                for (int i = 0; i < this.open.size(); i++) {
                Node n = this.open.poll();
                System.out.println(n.getX() + "    " + n.getY() + "    " + n.getG() + "    " + n.getH());
            }
            return null;
            }*/
        }
        return null;
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
        int dxnew = Math.abs(dx - xend);
        int dynew = Math.abs(dy - yend);
        return (dxnew+dynew) + (Math.sqrt(2) - 2) * Math.min(dxnew, dynew);
    }
    
    /**
     * Adds neighbors for the current node
     */
 /*   private void addNeigborsToOpenList() {
        Node node;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                node = new Node(this.now, this.now.getX() + x, this.now.getY() + y, Double.MAX_VALUE, this.distance(this.now.getX() + x, this.now.getY() + y));
                if ((x != 0 || y != 0) // not this.now
                    && this.now.getX() + x >= 0 && this.now.getX() + x < this.map[0].length // check boundaries
                    && this.now.getY() + y >= 0 && this.now.getY() + y < this.map.length
                    && this.map[this.now.getY() + y][this.now.getX() + x] != -1 // check if walkable
                    && !findNeighborInList(this.open, node) && !findNeighborInList(this.closed, node)) { // check if not already done
                      /*  node.setG(node.getParent().getG() + 1.); 
                        node.setG(node.getG() + this.map[this.now.getY() + y][this.now.getX() + x]);
                        this.open.add(node);*/
                   /*   if (isDiagonal(x,y)) {
                            node.setG(node.getParent().getG() + Math.sqrt(2));
                            node.setG(node.getG() + this.map[this.now.getY() + y][this.now.getX() + x]);
                            this.open.add(node);
                      } else {
                            node.setG(node.getParent().getG() + 1);
                            node.setG(node.getG() + this.map[this.now.getY() + y][this.now.getX() + x]);
                            this.open.add(node);
                      }
                }
            }
        }
    }*/
    
    private void addNeigborsToOpenList() {
        Node node;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if ((x != 0 || y != 0) // not this.now
                    && this.now.getX() + x >= 0 && this.now.getX() + x < this.map[0].length // check boundaries
                    && this.now.getY() + y >= 0 && this.now.getY() + y < this.map.length
                    && this.map[this.now.getY() + y][this.now.getX() + x] != -1 ) {
                    if (findNode(this.closed, x, y) != null) {
                        continue;
                    }
                    double cost = 0.;
                    if (isDiagonal(x,y)) {
                        cost = this.now.getG() + Math.sqrt(2) + this.map[this.now.getY() + y][this.now.getX() + x];
                    } else {
                        cost = this.now.getG() + 1. + this.map[this.now.getY() + y][this.now.getX() + x];
                    }
                    if (findNode(this.open, x, y) == null) {
                        node = new Node(this.now, this.now.getX() + x, this.now.getY() + y, cost, this.distance(this.now.getX() + x, this.now.getY() + y));
                        this.open.add(node);
                    } else {
                        node = findNode(this.open, x, y);
                        if (node.getG() > cost) {
                            node.setG(cost);
                            node.setH(this.distance(this.now.getX() + x, this.now.getY() + y));
                            node.setParent(this.now);
                        }
                    }
                }
            }
        }
    }

    private boolean isDiagonal(int x, int y) {
        return this.now.getX() != x && this.now.getY() != y;
    }
    
    private Node findNode(PriorityQueue<Node> nodes, int x, int y) {
        int nowx = this.now.getX() + x;
        int nowy = this.now.getY() + y;
        return nodes.stream().filter((n) -> (n.getX() == nowx && n.getY() == nowy)).findFirst().orElse(null);
    }
}

