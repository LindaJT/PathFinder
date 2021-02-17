
package pathFinder.util;

import pathFinder.Node;

/**
 * Data structure to store the found path
 * @author linjokin
 */
public class Path {
    
    private Node[] nodes;
    private int size;
    
    public Path(int max) {
        this.nodes = new Node[max];
        this.size = 0;
    }
    
    public void insert(Node node) {
        this.nodes[this.size] = node;
        this.size++;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public Node getNode(int pos) {
        return this.nodes[pos];
    }
    
    public Path flip() {
        Path reversed = new Path(this.size);
        for (int i = this.size -1; i>=0; i--) {
            reversed.insert(this.nodes[i]);
        }
        return reversed;
    }
    
}
