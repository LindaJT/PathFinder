/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PathFinder;

/**
 *
 * @author linjokin
 */
public class Node implements Comparable {
    
        public Node parent;
        public int x, y;
        public double g;
        public double h;
        public Node (Node parent, int xpos, int ypos, double g, double h) {
            this.parent = parent;
            this.x = xpos;
            this.y = ypos;
            this.g = g;
            this.h = h;
       }

    @Override
    public int compareTo(Object o) {
        Node that = (Node) o;
        return (int)((this.g + this.h) - (that.g + that.h));
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
    
}

