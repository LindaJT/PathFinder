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
public class Node implements Comparable {
    
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

    @Override
    public int compareTo(Object o) {
        Node that = (Node) o;
        return (int) ((this.g + this.h) - (that.g + that.h));
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

    
}

