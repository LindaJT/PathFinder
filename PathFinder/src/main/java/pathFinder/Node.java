/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder;

/**
 * Node of the map
 * @author linjokin
 */
public class Node implements Comparable<Node> {
    
        private Node parent;
        private int x, y;
        private double g;

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setH(double h) {
        this.h = h;
    }
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

    @Override
    public int compareTo(Node n) {
        Node that = n;
        return (int) ((this.g + this.h) - (that.g + that.h));
    }

    
}

