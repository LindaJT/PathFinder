/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder.util;

/**
 * Node of the map
 * @author linjokin
 */
public class Node {
    
        private Node parent;
        private int x, y;
        private double g;
        private double h;
        
        public Node(Node parent, int xpos, int ypos, double g, double h) {
            this.parent = parent;
            this.x = xpos;
            this.y = ypos;
            this.g = g;
            this.h = h;
       }

    public Node getParent() {
        return parent;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getG() {
        return g;
    }

    public double getH() {
        return h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setG(double g) {
        this.g = g;
    }
    
    public double getF() {
        return this.g + this.h;
    }
}

