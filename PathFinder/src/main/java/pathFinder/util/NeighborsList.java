
package pathFinder.util;

/**
 * Data structure to store neighboring nodes
 * @author linjokin
 */
public class NeighborsList {
    
    private Node[] nodes;
    private int size;
    
    public NeighborsList() {
        this.nodes = new Node[8];
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
    
}
